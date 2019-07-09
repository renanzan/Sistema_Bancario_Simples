package database.dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Database;
import models.Usuario;

public class DAO_Contas_corrente {
	
	private static Database database;
	
	private static String tableName = "Contas_corrente";
	
	public DAO_Contas_corrente (Database database) {
		this.database = database;
	}
	
	public static void selectLogin(Usuario usuario) {
		String codeSQL = "SELECT * FROM " + database.getDatabaseName() + "." + tableName + " WHERE fK_cpf='" + usuario.getCliente().getCpf() + "'";
		ResultSet rs = null;
		
		try {
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			rs = database.getPrpStmt().executeQuery();
			
			while(rs.next()) {
				usuario.getContaCorrente().setNum_conta(rs.getString(1));
				usuario.getContaCorrente().setPin(rs.getString(2));
				usuario.getContaCorrente().setSaldo(rs.getFloat(3));
				usuario.getContaCorrente().setFk_cpf(rs.getString(4));
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
	
	public String gerarNumeroRandomicoParaContaCorrente() {
		String numero = null;
		
		try {
			ResultSet rs;
			
			String codeSQL = "SELECT num_conta_corrente"
					+ " FROM ("
					+ " SELECT FLOOR(RAND() * 99999999999999999) AS num_conta_corrente "
					+ " UNION"
					+ " SELECT FLOOR(RAND() * 99999999999999999) AS num_conta_corrente"
					+ ") AS numbers_mst_plus_1"
					+ " WHERE `num_conta_corrente` NOT IN (SELECT num_conta_corrente FROM bd_banco_baltoy.contas_corrente)"
					+ " LIMIT 1";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			rs = database.getPrpStmt().executeQuery();
			
			while(rs.next()) {
				numero = rs.getString(1);
			}
			if(numero.length()<17)
				for(int temp=numero.length(); temp<17; temp++)
					numero+="0";
			numero+="10";
		} catch(Exception ex) {
			System.err.println("Houve um erro ao gerar um número randomico para a conta corrente.\n" + ex.getMessage());
		}
		
		return numero;
	}

}
