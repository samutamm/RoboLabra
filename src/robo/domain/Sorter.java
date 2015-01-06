package robo.domain;

import robo.Calculator.*;
import robo.contollers.*;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.util.Delay;

public class Sorter {
	private Coins coins;
	private MotorController motor;
	private LightSensor light;
	private int emptyLightValue;
	
	public Sorter(MotorController motor, LightSensor light) {
		this.coins = new Coins();
		this.light = light;
		this.motor = motor;
		this.motor.setSpeed(100);
		this.emptyLightValue = this.findStartLightValue();
	}
	
	public Coin openPortUntilCoinFlops(int diff) {
		int degrees = openUntilDrops(diff);
		Coin coin = this.coins.getCorrespondingCoin(degrees);
		LCD.clear();
		LCD.drawString(coin.name, 0, 0);
		Delay.msDelay(500);
		
		this.motor.rotate(-(coin.calibrate));
		return coin;
	}

	private int openUntilDrops(int diff) {
		int degrees = 0;
		while(this.emptyLightValue + diff < this.light.getLightValue()) {
			Delay.msDelay(50);
			this.motor.rotate(25);
			degrees += 25;
			if(Button.ENTER.isPressed()) return 0;
		}
		Delay.msDelay(50);
		this.motor.rotate(25);
		degrees += 25;
		return degrees;
	}
	
	public boolean noNewCoinAdded() {
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
