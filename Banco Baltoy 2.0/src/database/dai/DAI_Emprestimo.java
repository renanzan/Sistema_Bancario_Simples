package database.dai;

import models.Database;
import models.Emprestimo;

public class DAI_Emprestimo {

	private static String tableName = "emprestimo";
	private static Database database;
	
	public DAI_Emprestimo(Database database) {
		this.database = database;
	}
	
	public static void insert(Emprestimo emprestimo) {
		try {
			String codeSQL = "INSERT INTO " + database.getDatabaseName() + "." + tableName + " VALUES (?, ?, ?, ?);";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().setInt(1, emprestimo.getId());
			database.getPrpStmt().setFloat(2, emprestimo.getValor_emprestimo());

			String dataSQL = emprestimo.getData().getAno() + "-" + emprestimo.getData().getMes() + "-" + emprestimo.getData().getDia();
			database.getPrpStmt().setString(3, dataSQL);
			
			database.getPrpStmt().setString(4, emprestimo.getFk_cpf_cliente());
			database.getPrpStmt().executeUpdate();
		}catch (Exception ex) {
			System.err.println("Não foi possível inserir os dados na tabela " + tableName + ".\n" + ex.getMessage());
		}
	}
	
	public static void updateSaldo(String numeroDaConta, float valorParaSomar) {
		try {
			String codeSQL = "UPDATE " + database.getDatabaseName() + "." + tableName + " SET saldo=saldo+? WHERE num_conta_poupanca=?";
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
