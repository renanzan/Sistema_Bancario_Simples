package database.dai;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Types;

import models.Cliente;
import models.Database;

public class DAI_Clientes {

	private String tableName = "clientes";
	
	public DAI_Clientes(Database database, Cliente account) {
		try {
			String codeSQL = "INSERT INTO " + database.getDatabaseName() + "." + tableName + " VALUES (?, ?, ?, ?, ?);";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().setString(1, account.getNome());
			database.getPrpStmt().setString(2, account.getCpf());
			database.getPrpStmt().setString(3, account.getSenha());
			
			if(!(account.getEmail().equals("")))
				database.getPrpStmt().setString(4, account.getEmail());
			else
				database.getPrpStmt().setNull(4, Types.VARCHAR);

			if(account.getDiretorioImagem()!=null) {
				File file = new File(account.getDiretorioImagem());
                FileInputStream fileInputStream = new FileInputStream(file);
                int fileLength = (int)file.length();
                
                database.getPrpStmt().setBinaryStream(5, fileInputStream, fileLength);
			} else {
				database.getPrpStmt().setNull(5, Types.BLOB);
			}
			
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
