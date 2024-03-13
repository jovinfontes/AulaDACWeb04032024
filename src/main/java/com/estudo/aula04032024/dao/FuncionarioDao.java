package com.estudo.aula04032024.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.estudo.aula04032024.conexao.FabricaDeConexao;
import com.estudo.aula04032024.entities.Departamento;
import com.estudo.aula04032024.entities.Funcionario;

public class FuncionarioDao {
	
	// a conexão com o banco de dados
		private Connection connection;

		public FuncionarioDao() throws ClassNotFoundException {
			this.connection = new FabricaDeConexao().getConnection();
		}
		
		public void insereFUncionario(Funcionario funcionario) {
			String sql = "insert into funcionarios (nome_completo, matricula, id_departamento) values (?,?,?)";
			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);
				// seta os valores
				stmt.setString(1, funcionario.getNomeCompleto());
				stmt.setString(2, funcionario.getMatricula());
				stmt.setLong(3, funcionario.getDepartamento().getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
		
		public Funcionario byId(Long id) {
			String sql = "select * from funcionarios where id=?";
			try {
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				stmt.setLong(1, id);
				ResultSet rs = stmt.executeQuery();
				Funcionario funcionario = new Funcionario();
				while (rs.next()) {
					// criando o objeto Contato
					funcionario.setId(rs.getLong("id"));
					funcionario.setNomeCompleto(rs.getString("nome_completo"));
					funcionario.setMatricula(rs.getString("matricula"));
				}
				return funcionario;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

		}
		
		public Funcionario buscarFuncComDepartamento(Long id) {
			String sql = "SELECT f.nome_completo, f.matricula, d.nome_departamento\n"
					+ "FROM funcionarios f\n"
					+ "INNER JOIN departamentos d ON f.id_departamento = d.id\n"
					+ "WHERE f.id=?";
			try {
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				stmt.setLong(1, id);
				ResultSet rs = stmt.executeQuery();
				Funcionario funcionario = new Funcionario();
				while (rs.next()) {
					// criando o objeto Contato
					funcionario.setNomeCompleto(rs.getString("nome_completo"));
					funcionario.setMatricula(rs.getString("matricula"));
					funcionario.getDepartamento().setNomeDepartamento(rs.getString("nome_departamento"));
				}
				return funcionario;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

		}
		
		public List<Funcionario> all(){
			try {
				List<Funcionario> funcionarios = new ArrayList<Funcionario>();
				PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					// criando o objeto Contato
					Funcionario funcionario = new Funcionario();
					funcionario.setId(rs.getLong("id"));
					funcionario.setNomeCompleto(rs.getString("nome_completo"));
					funcionario.setMatricula(rs.getString("matricula"));
					
					funcionarios.add(funcionario);
				}
				rs.close();
				stmt.close();
				return funcionarios;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
		
		public void altera(Funcionario funcionario) {
			String sql = "update contatos set nome_completo=?, matricula=? where id=?";

			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, funcionario.getNomeCompleto());
				stmt.setString(2, funcionario.getMatricula());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void remove(Funcionario funcionario) {
			try {
				PreparedStatement stmt = connection.prepareStatement("delete from funcionarios where id=?");
				stmt.setLong(1, funcionario.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

}
