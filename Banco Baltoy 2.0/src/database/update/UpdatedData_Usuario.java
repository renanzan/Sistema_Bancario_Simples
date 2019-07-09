package database.update;

import database.dao.DAO_Celulares_Favoritos;
import database.dao.DAO_Clientes;
import database.dao.DAO_Contas_corrente;
import database.dao.DAO_Contas_poupanca;
import database.dao.DAO_Extratos;
import models.Database;
import models.Usuario;

public class UpdatedData_Usuario {

	public UpdatedData_Usuario(Database database, Usuario usuario) {
		new DAO_Clientes(database).selectLogin(usuario.getCliente().getCpf(), usuario.getCliente().getSenha(), usuario);
		new DAO_Contas_corrente(database).selectLogin(usuario);
		new DAO_Contas_poupanca(database).selectLogin(usuario);
		new DAO_Extratos(database).getAllExtratos(usuario);
	}
	
}
