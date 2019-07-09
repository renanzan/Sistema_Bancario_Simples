package database.dai;

import models.CelularFavorito;
import models.Database;

public class DAI_Celulares_Favoritos {

	private String tableName = "celulares_favoritos";
	
	public DAI_Celulares_Favoritos(Database database, CelularFavorito celularFavorito) {
		try {
			String codeSQL = "INSERT INTO " + database.getDatabaseName() + "." + tableName + " VALUES (?, ?, ?, ?, ?, ?);";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().setInt(1, celularFavorito.getId());
			database.getPrpStmt().setString(2, celularFavorito.getApelido());
			database.getPrpStmt().setString(3, celularFavorito.getDdd());
			database.getPrpStmt().setString(4, celularFavorito.getNumero());
			database.getPrpStmt().setString(5, celularFavorito.getOperadora());
			database.getPrpStmt().setString(6, celularFavorito.getFk_cpf());
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
