package robo.domain;

import robo.contollers.MotorController;
import lejos.util.Delay;

public class Convoyer {
	private MotorController motor;
	
	public Convoyer(MotorController motor) {
		this.motor = motor;
	}
	
	public void moveCoin(int speed, int rotate) {
		Delay.msDelay(300);
		this.motor.setSpeed(speed);
		this.motor.rotate(rotate);
		Delay.msDelay(1000);
		this.motor.setSpeed(speed*10);
		this.motor.rotate(-50);
		this.motor.stop();
		Delay.msDelay(1000);
		this.motor.setSpeed(speed);
		int rotateBack = -(rotate - 50);
		this.motor.rotate(rotateBack);
	}
}
