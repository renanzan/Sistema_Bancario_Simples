package database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Database;
import models.Usuario;

public class DAO_Contas_poupanca {
	
	private static Database database;
	
	private static String tableName = "Contas_poupanca";
	
	public DAO_Contas_poupanca (Database database) {
		this.database = database;
	}
	
	public static void selectLogin(Usuario usuario) {
		String codeSQL = "SELECT * FROM " + database.getDatabaseName() + "." + tableName + " WHERE fK_cpf='" + usuario.getCliente().getCpf() + "'";
		ResultSet rs = null;
		
		try {
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			rs = database.getPrpStmt().executeQuery();
			
			while(rs.next()) {
				usuario.getContaPoupanca().setNum_conta(rs.getString(1));
				usuario.getContaPoupanca().setPin(rs.getString(2));
				usuario.getContaPoupanca().setSaldo(rs.getFloat(3));
				usuario.getContaPoupanca().setFk_cpf(rs.getString(4));
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
	
	public String gerarNumeroRandomicoParaContaPoupanca() {
		String numero = null;
		
		try {
			ResultSet rs;
			
			String codeSQL = "SELECT num_conta_poupanca"
					+ " FROM ("
					+ " SELECT FLOOR(RAND() * 99999999999999999) AS num_conta_poupanca "
					+ " UNION"
					+ " SELECT FLOOR(RAND() * 99999999999999999) AS num_conta_poupanca"
					+ ") AS numbers_mst_plus_1"
					+ " WHERE `num_conta_poupanca` NOT IN (SELECT num_conta_poupanca FROM bd_banco_baltoy.contas_poupanca)"
					+ " LIMIT 1";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			rs = database.getPrpStmt().executeQuery();
			
			while(rs.next()) {
				numero = rs.getString(1);
			}
			if(numero.length()<17)
				for(int temp=numero.length(); temp<17; temp++)
					numero+="0";
			numero+="01";
		} catch(Exception ex) {
			System.err.println("Houve um erro ao gerar um número randomico para a conta corrente.\n" + ex.getMessage());
		}
		
		return numero;
	}

}
