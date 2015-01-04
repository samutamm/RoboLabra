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
<<<<<<< HEAD
		//int rotateBack = -(rotate - (50 - (rotate / 200)));
		int rotateBack = -(rotate - 50);
		Motor.B.rotate(rotateBack);
=======
<<<<<<< HEAD
		//int rotateBack = -(rotate - (50 - (rotate / 200)));
		int rotateBack = -(rotate - 50);
		Motor.B.rotate(rotateBack);
=======
		Motor.B.rotate(-(rotate - 47));
>>>>>>> 399b681cb032e3dad34ff53e4744e22c3cd3fea1
>>>>>>> 90aa8878659393c4809868a7999e1e9e9e74e0d0
	}
}
