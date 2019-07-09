package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Database {
	
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String IP = "127.0.0.2";
	
	private String usernameSQL;
	private String passwordSQL;
	private String databaseName;
	
	private String url;
	
	private Connection conn;
	private PreparedStatement prpStmt;
	
	public Database(String usernameSQL, String passwordSQL, String databaseName) {
		this.usernameSQL = usernameSQL;
		this.passwordSQL = passwordSQL;
		this.databaseName = databaseName;
	}
	
	public void initializeConnection() {
		if(conn==null) {
			try {
				Class.forName(DRIVER);
				url = "jdbc:mysql://" + IP + "/?user=" + usernameSQL + "&password=" + passwordSQL;
				conn = DriverManager.getConnection(url);
				
				try {
					Statement stmt = conn.createStatement();
					stmt.execute("CREATE DATABASE IF NOT EXISTS " + databaseName);
					stmt.close();
				} catch(Exception ex) {
					System.err.println("Não foi possível criar o banco de dados " + databaseName + "\n" + ex.getMessage());
				}
				
			} catch(Exception ex) {
				System.err.println("Não foi possível conectar ao banco de dados.\n" + ex.getMessage());
			}
		} else {
			System.err.println("Aviso: 'Connection conn' já foi inicializado e ainda não foi encerrado.");
		}
	}
	
	public void closeConn() {
		try {
			conn.close();
		} catch(Exception ex) {
			System.err.println("Não foi possível encerrar 'Connection conn'.\n" + ex.getMessage());
		}
	}

// ENCAPSULAMENTO
	public String getDRIVER() {
		return DRIVER;
	}
	
	public String getIP() {
		return IP;
	}
	
	public String getUsernameSQL() {
		return usernameSQL;
	}
	
	public String getPasswordSQL() {
		return passwordSQL;
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
	
	public Connection getConn() {
		return conn;
	}
	
	public PreparedStatement getPrpStmt() {
		return prpStmt;
	}
	public void setPrpStmt(PreparedStatement prpStmt) {
		this.prpStmt = prpStmt;
	}
	
	public String getUrl() {
		return url;
	}
}
