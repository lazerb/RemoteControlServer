package com.secret.rc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RCSocket {
	private PrintWriter out;
	private BufferedReader in;
	public RCSocketCallback callback;
	public RCSocket () throws IOException {
		ServerSocket whiteSock = new ServerSocket(6969);
		Socket dirtySock = whiteSock.accept();
		out = new PrintWriter(dirtySock.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(dirtySock.getInputStream()));
		Runnable runRead = new Runnable () {
			@Override
			public void run() {
				try {
					readSock();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		};
		Thread t = new Thread(runRead);
		t.start();
	}
	
	public void readSock () throws IOException {
		while (true) {
			String input = in.readLine();
			System.out.println(input);
			callback.getAction(input);
		}
	}
	public void writeSock (String output) {
		out.write(output);
	}
}
