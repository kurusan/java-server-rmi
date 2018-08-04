package com.bank.server;

import java.util.ArrayList;
import java.util.Iterator;

import com.bank.dao.CommonDAO;
import com.bank.logic.auth.User;

public class Local {
	
	private static CommonDAO cdao = new CommonDAO();;
	
	/* Retrieve user Authenticate*/
	public static ArrayList <User> authRequest(String login, String password) {
		return cdao.select(User.class, "User", null);
	}
	
	public static ArrayList <User> getUsers()  {
		return cdao.select(User.class, "User", null);
	}
	
	public static boolean auth( String login, String password) {
		ArrayList<User> admin = Local.authRequest(login, password);
		if( admin.size() != 0) {
			Iterator<User> it = admin.iterator();
			User user;
			while(it.hasNext()) {
				user = it.next();
				if(user.getLogin().equals(login) && user.getPassword().equals(password) && !user.isAdmin()) {
					/*new Log(admin.get(0).getLogin(), false);*/
					return true;
				}
			}
		}
		return true;
	}
	
	public static void createUser(User user) {
		cdao.insert(user, "User");
	}

}
