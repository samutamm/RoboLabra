package robo.main;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.util.Delay;

public class Convoyer {
	public void moveCoin(int speed, int rotate) {
		Delay.msDelay(300);
		Motor.B.setSpeed(speed);
		Motor.B.rotate(rotate);
		Delay.msDelay(1000);
		Motor.B.setSpeed(speed*10);
		Motor.B.rotate(-50);
		Motor.B.stop();
		Delay.msDelay(1000);
		Motor.B.setSpeed(speed);
		//int rotateBack = -(rotate - (50 - (rotate / 200)));
		int rotateBack = -(rotate - 50);
		Motor.B.rotate(rotateBack);
	}
}
