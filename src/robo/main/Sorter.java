package robo.main;

import robo.domain.*;
import robo.Calculator.*;
import java.util.*;
import robo.contollers.*;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.util.Delay;



public class Sorter {
	private Coins coins;
	private Calculator calculator;
	private MotorController motor;
	
	public Sorter() {
		this.coins = new Coins();
		this.calculator = new Calculator();
		this.motor = new MotorController(Motor.A);
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
			//drawToLCDScreen(light);
			if(Button.ENTER.isPressed()) return 0;
		}
		Delay.msDelay(50);
		this.motor.rotate(25);
		degrees += 25;
		return degrees;
	}
	
	public void drawToLCDScreen(LightSensor light) {
		LCD.drawInt(light.getLightValue(), 4, 0, 0);
		LCD.drawInt(light.getNormalizedLightValue(), 4, 0, 1);
	}
}
