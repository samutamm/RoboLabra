package robo.main;

import lejos.nxt.LightSensor;
import lejos.util.Delay;

public class RobotInitializer {

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
