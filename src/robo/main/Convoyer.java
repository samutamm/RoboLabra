package robo.main;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.util.Delay;

public class Convoyer {
	public void moveUntilButtonPress(int speed) {
		Button.waitForPress();
		Motor.B.setSpeed(speed);
		//Motor.B.forward(); //tässä myötäpäivään
		Motor.B.rotate(370);
		Delay.msDelay(1000);
		Motor.B.setSpeed(speed*5);
		Motor.B.rotate(-50);
		Motor.B.stop();
		LCD.drawInt(Motor.B.getTachoCount(), 0, 0);
		Button.waitForPress();
	}
}
