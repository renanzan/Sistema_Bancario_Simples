package database.dai;

import models.Conta;
import models.Database;

public class DAI_Contas_corrente {

	private static String tableName = "contas_corrente";
	private static Database database;
	
	public DAI_Contas_corrente(Database database) {
		this.database = database;
	}
	
	public static void insert(String cpfCliente, Conta contaCorrente) {
		try {
			String codeSQL = "INSERT INTO " + database.getDatabaseName() + "." + tableName + " VALUES (?, ?, ?, ?);";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().setString(1, contaCorrente.getNum_conta());
			database.getPrpStmt().setString(2, contaCorrente.getPin());
			database.getPrpStmt().setFloat(3, contaCorrente.getSaldo());
			database.getPrpStmt().setString(4, cpfCliente);
			database.getPrpStmt().executeUpdate();
		}catch (Exception ex) {
			System.err.println("Não foi possível inserir os dados na tabela.\n" + ex.getMessage());
		}
	}
	
	public static void updateSaldo(String numeroDaConta, float valorParaSomar) {
		try {
			String codeSQL = "UPDATE " + database.getDatabaseName() + "." + tableName + " SET saldo=saldo+? WHERE num_conta_corrente=?";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().setFloat(1, valorParaSomar);
			database.getPrpStmt().setString(2, numeroDaConta);
			database.getPrpStmt().executeUpdate();
		}catch (Exception ex) {
			System.err.println("Não foi atualizar os dados da tabela " + tableName + ".\n" + ex.getMessage());
		}
	}
	
// HEADER
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
