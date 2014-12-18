package org.lejos.example;

import lejos.nxt.*;
import lejos.util.Delay;

/**
 * RoboLara
 * 
 */
public class RoboTesti {

	public static void main(String[] args) {
		LCD.drawString("Hello world!", 0, 0);
		Button.waitForPress();
	}
}
