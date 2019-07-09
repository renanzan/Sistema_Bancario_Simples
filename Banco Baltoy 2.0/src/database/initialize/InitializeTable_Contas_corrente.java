package database.initialize;

import models.Database;

public class InitializeTable_Contas_corrente {
	
	private String tableName = "contas_corrente";
	private static Database database;
	
	public InitializeTable_Contas_corrente(Database database) {
		this.database = database;
		
		try {
			String codeSQL = "CREATE TABLE IF NOT EXISTS " + database.getDatabaseName() + "." + tableName + " (" + 
					"	`num_conta_corrente` CHAR(19) CHARACTER SET utf8 COLLATE utf8_general_ci UNIQUE NOT NULL," + 
					"	`pin` CHAR(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL," + 
					"    `saldo` FLOAT DEFAULT 0 NOT NULL,\r\n" + 
					"    `fk_cpf` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci UNIQUE NOT NULL," + 
					"    CONSTRAINT PK_Contas_corrente PRIMARY KEY(`num_conta_corrente`)," + 
					"    CONSTRAINT FK_Clientes FOREIGN KEY (`fk_cpf`) REFERENCES bd_banco_baltoy.clientes (`cpf`)" + 
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
