package database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Cliente;
import models.Database;

public class DAO_Emprestimo {
	
	private static Database database;
	
	private static String tableName = "emprestimo";
	
	public DAO_Emprestimo (Database database) {
		this.database = database;
	}
	
	public static void select_fk_Cpf_cliente(Cliente cliente) {
		ResultSet rs = null;
		
		try {
			String codeSQL = "SELECT * FROM " + database.getDatabaseName() + "." + tableName + " WHERE fk_cpf_cliente=?";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().setString(1, cliente.getCpf());
			rs = database.getPrpStmt().executeQuery();
			
			while(rs.next()) {
				cliente.getEmprestimo().setId(rs.getInt(1));
				cliente.getEmprestimo().setValor_emprestimo(rs.getFloat(2));
				cliente.getEmprestimo().getData().setDateSQL(rs.getString(3));
				cliente.getEmprestimo().setFk_cpf_cliente(rs.getString(4));
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
	
	public static void delete_Emprestimo(String fk_cpf_cliente) {
		try {
			String codeSQL = "DELETE FROM " + database.getDatabaseName() + "." + tableName + " WHERE fk_cpf_cliente=?";
			database.setPrpStmt(database.getConn().prepareStatement(codeSQL));
			database.getPrpStmt().setString(1, fk_cpf_cliente);
			database.getPrpStmt().executeUpdate();
		} catch(Exception ex) {
			System.err.println("Não foi possível remover empréstimo.\n" + ex.getMessage());
		}
	}

}
