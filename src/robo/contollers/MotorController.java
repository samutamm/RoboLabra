package robo.contollers;

import lejos.nxt.*;

public class MotorController {
	private NXTRegulatedMotor motor;
	
	public MotorController(NXTRegulatedMotor motor) {
		this.motor = motor;
	}
	
	public void rotate(int angle) { this.motor.rotate(angle); }
	
	public void setSpeed(int speed) {this.motor.setSpeed(speed); }
	
	public void stop() { this.motor.stop(); }

	
}
