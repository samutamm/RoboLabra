package robo.main;

import java.util.List;

import robo.Calculator.Calculator;
import robo.contollers.MotorController;
import robo.domain.Convoyer;
import robo.domain.Sorter;
import lejos.nxt.*;

public class Main {
	
	
	public static void main(String[] args) {

		Convoyer convoyer = new Convoyer(new MotorController(Motor.B));
		Calculator calc = new Calculator();
		Sorter sorter = new Sorter(new MotorController(Motor.A), calc);
		LightSensor light = new LightSensor(SensorPort.S1);
		Robot robo = new Robot(convoyer, sorter, light);

		robo.run();
		
		LCD.clear();
		LCD.drawString("Coin stats:", 0, 0);
		List<String> coinStats = calc.getStatistics();
		for(int i = 0; i < coinStats.size(); i++) {
			LCD.drawString(coinStats.get(i), 0, i+1);
		}

		Button.waitForPress();
	}
}
