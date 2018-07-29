package com.bank.test;

import com.bank.server.Server;

public class TestServer {

	public static void main(String[] args) {
		new Server();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
