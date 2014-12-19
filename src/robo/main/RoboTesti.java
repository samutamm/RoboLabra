package robo.main;

import lejos.nxt.*;
import lejos.util.Delay;

/**
 * RoboLara
 * 
 */
public class RoboTesti {

	public static void main(String[] args) {
//		TouchSensor touch = new TouchSensor(SensorPort.S2);
//		LightSensor light = new LightSensor(SensorPort.S1);
//		while (!touch.isPressed()) {
//			Delay.msDelay(100);
//			LCD.drawInt(light.getLightValue(), 4, 0, 0);
//			LCD.drawInt(light.getNormalizedLightValue(), 4, 0, 1);
//			LCD.drawInt(SensorPort.S2.readRawValue(), 4, 0, 2);
//			LCD.drawInt(SensorPort.S2.readValue(), 4, 0, 3);
//		}
//		LCD.drawString("Finished", 0, 0);
		LCD.drawString("Start", 0, 0);
		Button.waitForPress();
		Motor.A.rotate(120);
		LCD.drawInt(Motor.A.getTachoCount(), 0, 0);
		Button.waitForPress();
	}
}
