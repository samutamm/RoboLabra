package robo.main;

import lejos.nxt.*;
import lejos.util.Delay;

/**
 * RoboLara
 * 
 */
public class RoboTesti {
	private final static int differentNumber = 2;
	
	
	public static void main(String[] args) {

		Convoyer convoyer = new Convoyer();
		convoyer.moveUntilButtonPress(50);
//		RobotInitializer ri = new RobotInitializer();
//		Sorter sorter = new Sorter();
//		LightSensor light = new LightSensor(SensorPort.S1);
//		Motor.A.setSpeed(100);
//		int emptyLightValue = ri.findStartLightValue(light);
//		
//		LCD.drawString("Is coin ready?" , 0, 0);
//		LCD.drawString("EmtyLightValue is initialized to ", 0, 1);
//		LCD.drawInt(emptyLightValue, 0, 2);
//		Button.waitForPress();
//		run(sorter, light, emptyLightValue);
//		LCD.clear();
//		LCD.drawString("Finished", 0, 0);
//
//		Button.waitForPress();
	}
	private static void run(Sorter sorter, LightSensor light, int emptyLightValue) {
		LCD.clear();
		while(!Button.ESCAPE.isPressed()) { 
			int degreesBeforeCoinDrops = sorter.openPortUntilCoinFlops(differentNumber, emptyLightValue, light);
			LCD.clear();
			LCD.drawString("Last coin dropped in degree: ", 0, 0);
			LCD.drawInt(degreesBeforeCoinDrops, 0, 1);
			LCD.drawString("Press Escape to stop or put an other coin and press Enter.", 0, 3);
			Delay.msDelay(1000);
			while(noNewCoinAdded(light) && Button.readButtons() == 0);
		}
	}
	
	private static boolean noNewCoinAdded(LightSensor light) {
		Delay.msDelay(100);
		return light.getLightValue() < 50;
	}
	
	public static void drawToLCDScreen(LightSensor light) {
		LCD.drawInt(light.getLightValue(), 4, 0, 0);
		LCD.drawInt(light.getNormalizedLightValue(), 4, 0, 1);
	}
	
	
}
