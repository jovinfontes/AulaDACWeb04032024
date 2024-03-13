package com.estudo.aula04032024.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	
	public Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste", "postgres", "123456");
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
