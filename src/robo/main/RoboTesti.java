package robo.main;

import lejos.nxt.*;
import lejos.util.Delay;

/**
 * RoboLara
 * 
 */
public class RoboTesti {
	
	
	public static void main(String[] args) {

		Convoyer convoyer = new Convoyer();
		Sorter sorter = new Sorter();
		LightSensor light = new LightSensor(SensorPort.S1);
		RobotInitializer ri = new RobotInitializer(convoyer, sorter, light);

		ri.run();
		LCD.clear();
		LCD.drawString("Finished", 0, 0);

		Button.waitForPress();
	}	
}
