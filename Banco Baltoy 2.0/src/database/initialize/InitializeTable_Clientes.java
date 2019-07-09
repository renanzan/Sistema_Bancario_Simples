package database.initialize;

import java.sql.Statement;

import models.Database;

public class InitializeTable_Clientes {
	
	private String tableName = "clientes";
	
	public InitializeTable_Clientes(Database database) {
		Statement stmt = null;
		
		try {
			stmt = database.getConn().createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + database.getDatabaseName() + "." + tableName + " (" + 
					"	`nome` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL," + 
					"    `cpf` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci UNIQUE NOT NULL," + 
					"    `senha` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL," + 
					"    `email` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci UNIQUE DEFAULT NULL," + 
					"    `foto` LONGBLOB DEFAULT NULL," + 
					"    CONSTRAINT PK_Clientes PRIMARY KEY(`cpf`)" + 
					");");
			try {
				stmt.executeUpdate("INSERT INTO " + database.getDatabaseName() + "." + tableName + " VALUES ('admin', 'admin', 'admin', NULL, '0', NULL);");
			} catch(Exception ex) {
				System.err.println();
			}
		} catch(Exception ex) {
			System.err.println("Não foi possível criar tabela " + tableName + ".");
		} finally {
			try {
				stmt.close();
			} catch(Exception ex) {
				System.err.println("Não foi possível encerrar Statement.\n" + ex.getMessage());
			}
		}
	}
	
// ENCAPSULAMENTO
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
