package main;

import database.initialize.InitializeDatabase;
import models.Database;
import view.before_login.Login;

public class Main {
	
	private static Database database;
	
	public static void main(String[] args) {
		database = new Database("root", "", "bd_banco_baltoy");
		database.initializeConnection();
		
		new InitializeDatabase(database);
		new Login(database).initialize();
	}
	
	public static void exit() {
		database.closeConn();
		System.exit(0);
	}
	
}
