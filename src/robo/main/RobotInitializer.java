package robo.main;

import robo.domain.*;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.util.Delay;

public class RobotInitializer {
	
	private Convoyer convoyer;
	private Sorter sorter;
	private LightSensor light;
	
	public RobotInitializer(Convoyer convoyer, Sorter sorter, LightSensor light) {
		this.convoyer = convoyer;
		this.sorter = sorter;
		this.light = light;
	}
	
	
	public void run() {
		int emptyLightValue = findStartLightValue(this.light);
		
		LCD.drawString("Is coin ready?" , 0, 0);
		Button.waitForPress();
		
		while(!Button.ESCAPE.isPressed()) { 
			Coin coin = this.sorter.openPortUntilCoinFlops(2, emptyLightValue, this.light);
			LCD.clear();
			
			this.convoyer.moveCoin(50, coin.convoyerAngles);
			
			LCD.drawString("Press Escape to stop or put an other coin and press Enter.", 0, 3);
			Delay.msDelay(1000);
			while(noNewCoinAdded(this.light) && Button.readButtons() == 0);
		}
	}
	
	private static boolean noNewCoinAdded(LightSensor light) {
		Delay.msDelay(100);
		return light.getLightValue() < 50;
	}

	public int findStartLightValue(LightSensor light) {
		int emptyLightValue = light.getLightValue();
		Delay.msDelay(100);
		while(emptyLightValue != light.getLightValue()) {
			emptyLightValue = light.getLightValue();
			Delay.msDelay(100);
		}
		return emptyLightValue;
	}
}
