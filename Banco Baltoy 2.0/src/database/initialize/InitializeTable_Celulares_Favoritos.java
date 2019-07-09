package database.initialize;

import java.sql.Statement;

import models.Database;

public class InitializeTable_Celulares_Favoritos {
	
	private String tableName = "celulares_favoritos";
	
	public InitializeTable_Celulares_Favoritos(Database database) {
		Statement stmt = null;
		
		try {
			stmt = database.getConn().createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + database.getDatabaseName() + "." + tableName + " (" +
					"	`id` INT AUTO_INCREMENT," + 
					"   `apelido` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL," +
					"	`ddd` INT NOT NULL," + 
					"	`numero` INT NOT NULL," + 
					"	`operadora` ENUM('Oi', 'Tim', 'Vivo', 'Claro') NOT NULL," + 
					"	`fk_cpf` VARCHAR(255) NOT NULL," + 
					"    CONSTRAINT PK_Celulares_Favoritos PRIMARY KEY(`id`)," + 
					"    CONSTRAINT FK_Clientes FOREIGN KEY (`fk_cpf`) REFERENCES bd_banco_baltoy.clientes (`cpf`)" + 
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
