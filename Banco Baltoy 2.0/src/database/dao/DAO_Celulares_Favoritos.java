package database.dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.CelularFavorito;
import models.Database;
import models.Usuario;

public class DAO_Celulares_Favoritos {
	
	private static Database database;
	
	private static String tableName = "celulares_favoritos";
	
	public DAO_Celulares_Favoritos (Database database) {
		this.database = database;
	}
	
	public static void getAllCelularesFavoritos(Usuario usuario) {
		ResultSet rs = null;
		
		try {
			String codeSQL = "SELECT * FROM " + database.getDatabaseName() + "." + tableName + " WHERE fk_cpf=?";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().setString(1, usuario.getCliente().getCpf());
			rs = database.getPrpStmt().executeQuery();
			
			while(rs.next()) {
				CelularFavorito celularFavorito = new CelularFavorito();
				celularFavorito.setId(rs.getInt(1));
				celularFavorito.setApelido(rs.getString(2));
				celularFavorito.setDdd(rs.getString(3));
				celularFavorito.setNumero(rs.getString(4));
				celularFavorito.setOperadora(rs.getString(5));
				celularFavorito.setFk_cpf(rs.getString(6));
				usuario.getCelularesFavoritos().add(celularFavorito);
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
