package com.secret.rc;

import java.awt.AWTException;
import java.io.IOException;

public class MainClass {
	public static void main (String [] args) throws AWTException, IOException {
		RCRobot rc = new RCRobot();
		RCSocket nike = new RCSocket();
		nike.callback = rc;
	}
}