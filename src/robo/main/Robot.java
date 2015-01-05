package robo.main;

import robo.domain.*;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.util.Delay;

public class Robot {
	
	private Convoyer convoyer;
	private Sorter sorter;
	private LightSensor light;
	
	public Robot(Convoyer convoyer, Sorter sorter, LightSensor light) {
		this.convoyer = convoyer;
		this.sorter = sorter;
		this.light = light;
	}
	
	
	public void run() {
		int emptyLightValue = findStartLightValue();
		
		LCD.drawString("Is coin ready?" , 0, 0);
		Button.waitForPress();
		
		while(!Button.ESCAPE.isPressed()) { 
			Coin coin = this.sorter.openPortUntilCoinFlops(2, emptyLightValue, this.light);
			LCD.clear();
			
			this.convoyer.moveCoin(50, coin.convoyerAngles);
			
			LCD.drawString("Press Escape to stop or put an other coin and press Enter.", 0, 3);
			Delay.msDelay(1000);
			while(noNewCoinAdded() && Button.readButtons() == 0);
		}
	}
	
	private boolean noNewCoinAdded() {
		Delay.msDelay(100);
		return this.light.getLightValue() < 50;
	}

	public int findStartLightValue() {
		int emptyLightValue = this.light.getLightValue();
		Delay.msDelay(100);
		while(emptyLightValue != this.light.getLightValue()) {
			emptyLightValue = this.light.getLightValue();
			Delay.msDelay(100);
		}
		return emptyLightValue;
	}
}
