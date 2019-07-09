package database.update;

import models.Database;
import models.Usuario;

public class UPDATE_TABLE_Contas_corrente {

	private String tableName = "contas_corrente";
	
	public UPDATE_TABLE_Contas_corrente(Database database, Usuario usuario) {
		try {
			String codeSQL = "UPDATE " + database.getDatabaseName() + "." + tableName + " SET pin = ?, saldo = ? WHERE " + database.getDatabaseName() + "." + tableName + ".fk_cpf = ?";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().setString(1, usuario.getContaCorrente().getPin());
			database.getPrpStmt().setFloat(2, usuario.getContaCorrente().getSaldo());
			database.getPrpStmt().setString(3, usuario.getCliente().getCpf());
			database.getPrpStmt().executeUpdate();
		}catch (Exception ex) {
			System.err.println("Não foi possível atualizar os dados na tabela.\n" + ex.getMessage());
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
