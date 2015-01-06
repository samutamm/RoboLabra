package robo.domain;

import robo.Calculator.*;
import robo.contollers.*;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.util.Delay;



public class Sorter {
	private Coins coins;
	private Calculator calculator;
	private MotorController motor;
	
	public Sorter(MotorController motor, Calculator calc) {
		this.coins = new Coins();
		this.calculator = calc;
		this.motor = motor;
		this.motor.setSpeed(100);
	}
	
	public Coin openPortUntilCoinFlops(int diff, int emptyLightValue, LightSensor light) {
		int degrees = openUntilDrops(diff, emptyLightValue, light);
		Coin coin = this.coins.getCorrespondingCoin(degrees);
		this.calculator.addCoin(coin);
		LCD.clear();
		LCD.drawString(coin.name, 0, 0);
		LCD.drawString("total money in cents: ", 0, 1);
		LCD.drawInt(this.calculator.cents, 0, 2);
		Delay.msDelay(2000);
		
		this.motor.rotate(-(coin.calibrate));
		return coin;
	}

	private int openUntilDrops(int diff, int emptyLightValue, LightSensor light) {
		int degrees = 0;
		while(emptyLightValue + diff < light.getLightValue()) {
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
}
