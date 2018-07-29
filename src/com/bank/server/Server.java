package com.bank.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
	ServiceRMI service;
	
	public Server() {
		try {
			service = new ServiceRMI();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost/BK",service);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
