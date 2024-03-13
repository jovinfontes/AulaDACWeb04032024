package com.estudo.aula04032024.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.estudo.aula04032024.conexao.FabricaDeConexao;
import com.estudo.aula04032024.entities.Departamento;

public class DepartamentoDao {
	
	// a conexão com o banco de dados
	private Connection connection;

	public DepartamentoDao() throws ClassNotFoundException {
		this.connection = new FabricaDeConexao().getConnection();
	}
	
	public void insereDepartamento(Departamento departamento) {
		String sql = "insert into departamentos (nome_departamento) values (?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, departamento.getNomeDepartamento());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public Departamento byId(Long id) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from departamentos where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			Departamento departamento = new Departamento();
			while (rs.next()) {
				// criando o objeto Contato
				departamento.setId(rs.getLong("id"));
                departamento.setNomeDepartamento(rs.getString("nome_departamento"));
			}
			return departamento;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
