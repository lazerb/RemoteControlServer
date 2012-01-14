package com.secret.rc;

import java.awt.AWTException;
import java.awt.Robot;

public class RCRobot implements RCSocketCallback {
	private Robot walle;
	public RCRobot () throws AWTException {
		walle = new Robot();
	}
	public void getAction (String input) {
		if (input.startsWith("key:")) {
			try {
				walle.keyPress(Integer.parseInt(input.substring(4)));
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		else if (input.startsWith("mouse:")) {
			try {
				walle.mousePress(Integer.parseInt(input.substring(6)));
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		else if (input.startsWith("move:")) {
			try {
				int x = Integer.parseInt(input.substring(5, input.indexOf(",")));
				int y = Integer.parseInt(input.substring(input.indexOf(",") + 1));
				walle.mouseMove(x, y);
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}
}