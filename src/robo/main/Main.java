package robo.main;

import robo.contollers.MotorController;
import robo.domain.Convoyer;
import robo.domain.Sorter;
import lejos.nxt.*;

public class Main {
	
	
	public static void main(String[] args) {

		Convoyer convoyer = new Convoyer(new MotorController(Motor.B));
		Sorter sorter = new Sorter(new MotorController(Motor.A));
		LightSensor light = new LightSensor(SensorPort.S1);
		Robot ri = new Robot(convoyer, sorter, light);

		ri.run();
		LCD.clear();
		LCD.drawString("Finished", 0, 0);

		Button.waitForPress();
	}	
}
