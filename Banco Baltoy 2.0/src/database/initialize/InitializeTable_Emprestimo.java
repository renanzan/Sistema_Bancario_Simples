package database.initialize;

import models.Database;

public class InitializeTable_Emprestimo {
	
	private String tableName = "emprestimo";
	private static Database database;
	
	public InitializeTable_Emprestimo(Database database) {
		this.database = database;
		
		try {
			String codeSQL = "CREATE TABLE IF NOT EXISTS " + database.getDatabaseName() + "." + tableName + " (" + 
					"	`id` INT AUTO_INCREMENT NOT NULL UNIQUE," + 
					"    `valor_emprestimo` FLOAT NOT NULL," + 
					"    `data_do_emprestimo` DATE NOT NULL," + 
					"    `fk_cpf_cliente` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci UNIQUE NOT NULL," + 
					"    PRIMARY KEY(`id`)" + 
					");";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().executeUpdate();
		} catch(Exception ex) {
			System.err.println("Não foi possível criar tabela " + tableName + ".");
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
