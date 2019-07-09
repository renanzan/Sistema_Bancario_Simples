package database.dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Database;
import models.Usuario;

public class DAO_Clientes {
	
	private static Database database;
	
	private static String tableName = "clientes";
	
	public DAO_Clientes (Database database) {
		this.database = database;
	}
	
	public static void selectLogin(String cpf, String password, Usuario usuario) {
		String codeSQL = "SELECT * FROM " + database.getDatabaseName() + "." + tableName + " WHERE cpf='" + cpf + "' AND senha='" + password + "'";
		ResultSet rs = null;
		
		try {
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			rs = database.getPrpStmt().executeQuery();
			
			while(rs.next()) {
				usuario.getCliente().setNome(rs.getString(1));
				usuario.getCliente().setCpf(rs.getString(2));
				usuario.getCliente().setSenha(rs.getString(3));
				usuario.getCliente().setEmail(rs.getString(4));
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
	
	public static String selectContaCorrente(String num_conta_corrente) {
		String codeSQL = "SELECT * FROM bd_banco_baltoy.clientes, bd_banco_baltoy.contas_corrente WHERE num_conta_corrente=?";
		ResultSet rs = null;
		
		try {
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().setString(1, num_conta_corrente);
			rs = database.getPrpStmt().executeQuery();
			
			while(rs.next()) {
				return rs.getString("nome");
			}
		} catch(Exception ex) {
			System.err.println("Não foi possível efetuar a busca.\n" + ex.getMessage());
		}
		
		return null;
	}
	
	public static String selectContaPoupanca(String num_conta_poupanca) {
		String codeSQL = "SELECT * FROM bd_banco_baltoy.clientes, bd_banco_baltoy.contas_poupanca WHERE num_conta_poupanca=?";
		ResultSet rs = null;
		
		try {
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().setString(1, num_conta_poupanca);
			rs = database.getPrpStmt().executeQuery();
			
			while(rs.next()) {
				return rs.getString("nome");
			}
		} catch(Exception ex) {
			System.err.println("Não foi possível efetuar a busca.\n" + ex.getMessage());
		}
		
		return null;
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
