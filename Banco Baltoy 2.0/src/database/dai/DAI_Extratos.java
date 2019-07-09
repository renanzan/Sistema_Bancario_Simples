package database.dai;

import models.Database;
import models.Extrato;

public class DAI_Extratos {

	private static String tableName = "extratos";
	public static Database database;
	
	public DAI_Extratos(Database database) {
		this.database = database;
	}
	
	public static void insert(Extrato extrato) {
		try {
			String codeSQL = "INSERT INTO " + database.getDatabaseName() + "." + tableName + " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));

			database.getPrpStmt().setInt(1, extrato.getId());
			database.getPrpStmt().setString(2, extrato.getTipo());
			database.getPrpStmt().setString(3, extrato.getDescricao());
			database.getPrpStmt().setFloat(4, extrato.getValor());
			database.getPrpStmt().setString(5, extrato.getFormaDePagamento());
			
			String dataSQL = extrato.getData().getAno() + "-" + extrato.getData().getMes() + "-" + extrato.getData().getDia();
			database.getPrpStmt().setString(6, dataSQL);
			
			String horaSQL = extrato.getData().getHora() + ":" + extrato.getData().getMinuto() + ":" + extrato.getData().getSegundos();
			database.getPrpStmt().setString(7, horaSQL);
			
			database.getPrpStmt().setString(8, extrato.getFk_num_conta());
			database.getPrpStmt().executeUpdate();
		}catch (Exception ex) {
			System.err.println("Não foi possível inserir os dados na tabela.\n" + ex.getMessage());
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
