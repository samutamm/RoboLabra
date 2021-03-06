package robo.main;

import java.util.List;

import robo.Calculator.Calculator;
import robo.contollers.MotorController;
import robo.domain.*;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.util.Delay;

public class Robot {
	
	private Convoyer convoyer;
	private Sorter sorter;
	private Calculator calculator;
	
	public Robot() {
		this.calculator = new Calculator();
		this.sorter = new Sorter(new MotorController(Motor.A), new LightSensor(SensorPort.S1));
		this.convoyer = new Convoyer(new MotorController(Motor.B));
	}
	
	
	public void run() {
		LCD.drawString("Is coin ready?" , 0, 0);
		Button.waitForPress();
		
		while(!Button.ESCAPE.isPressed()) { 
			Coin coin = this.sorter.openPortUntilCoinFlops(2);
			this.calculator.addCoin(coin);
			LCD.clear();
			LCD.drawString("total money in cents: ", 0, 1);
			LCD.drawInt(this.calculator.cents, 0, 2);
			this.convoyer.moveCoin(50, coin.convoyerAngles);
			
			LCD.drawString("Press Escape to stop or put an other coin and press Enter.", 0, 3);
			Delay.msDelay(1000);
			while(this.sorter.noNewCoinAdded() && Button.readButtons() == 0);
		}
		
		this.printStatisticsAtEnd();
	}
	
	public void printStatisticsAtEnd() {
		LCD.clear();
		LCD.drawString("Coin stats:", 0, 0);
		List<String> coinStats = calculator.getStatistics();
		for(int i = 0; i < coinStats.size(); i++) {
			LCD.drawString(coinStats.get(i), 0, i+1);
		}

		Button.waitForPress();
	}
}
