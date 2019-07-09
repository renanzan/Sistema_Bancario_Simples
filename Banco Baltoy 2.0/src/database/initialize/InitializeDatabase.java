package database.initialize;

import models.Database;

public class InitializeDatabase {
	
	public InitializeDatabase(Database database) {
		new InitializeTable_Clientes(database);
		new InitializeTable_Contas_poupanca(database);
		new InitializeTable_Contas_corrente(database);
		new InitializeTable_Extratos(database);
		new InitializeTable_Celulares_Favoritos(database);
		new InitializeTable_Emprestimo(database);
	}
	
}
