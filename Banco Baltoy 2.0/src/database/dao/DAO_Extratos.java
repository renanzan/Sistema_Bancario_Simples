package database.dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Database;
import models.Extrato;
import models.Usuario;

public class DAO_Extratos {
	
	private static Database database;
	
	private static String tableName = "extratos";
	
	public DAO_Extratos (Database database) {
		this.database = database;
	}
	
	public static void getAllExtratos(Usuario usuario) {
		ResultSet rs = null;
		
		try {
			String codeSQL = "SELECT * FROM " + database.getDatabaseName() + "." + tableName + " WHERE fk_num_conta=?";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().setString(1, usuario.getContaCorrente().getNum_conta());
			rs = database.getPrpStmt().executeQuery();
			
			while(rs.next()) {
				Extrato extrato = new Extrato();
				extrato.setId(rs.getInt(1));
				extrato.setTipo(rs.getString(2));
				extrato.setDescricao(rs.getString(3));
				extrato.setValor(rs.getFloat(4));
				extrato.setFormaDePagamento(rs.getString(5));
				
				extrato.getData().setDateSQL(rs.getString(6));
				extrato.getData().setTimeSQL(rs.getString(7));
				
				extrato.setFk_num_conta(rs.getString(7));
				
				usuario.getExtratos().add(extrato);
			}
		} catch(Exception ex) {
			System.err.println("Não foi possível efetuar a busca.\n" + ex.getMessage());
		} finally {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.err.println("Não foi possível fechar o 'ResultSet rs'.\n" + ex.getMessage());
			}
		}
	}
	
	public static Blob selectImageUser(String cpf) {
		String codeSQL = "SELECT foto FROM " + database.getDatabaseName() + "." + tableName + " WHERE cpf='" + cpf + "'";
		ResultSet rs = null;
		Blob image = null;
		
		try {
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			rs = database.getPrpStmt().executeQuery();
			
			while(rs.next()) {
				image = rs.getBlob("foto");
			}
		} catch(Exception ex) {
			System.err.println("Não foi possível efetuar a busca.\n" + ex.getMessage());
		} finally {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.err.println("Não foi possível fechar o 'ResultSet rs'.\n" + ex.getMessage());
			}
		}
		
		return image;
	}

}
