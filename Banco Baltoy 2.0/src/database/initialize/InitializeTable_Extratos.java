package database.initialize;

import java.sql.Statement;

import models.Database;

public class InitializeTable_Extratos {
	
	private String tableName = "extratos";
	
	public InitializeTable_Extratos(Database database) {
		Statement stmt = null;
		
		try {
			stmt = database.getConn().createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + database.getDatabaseName() + "." + tableName + " (" +
					"	`id` INT AUTO_INCREMENT NOT NULL UNIQUE," + 
					"   `tipo` ENUM('debito', 'credito') NOT NULL," + 
					"   `descricao` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL," + 
					"   `valor` FLOAT NOT NULL," + 
					"   `forma_de_pagamento` ENUM('corrente', 'poupanca')," + 
					"   `data` DATE NOT NULL," + 
					"   `hora` TIME NOT NULL," + 
					"   `fk_num_conta` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL," + 
					"   CONSTRAINT PK_Extratos PRIMARY KEY(`id`)" + 
					");");
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
