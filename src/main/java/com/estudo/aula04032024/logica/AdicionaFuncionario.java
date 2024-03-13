package com.estudo.aula04032024.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estudo.aula04032024.dao.FuncionarioDao;
import com.estudo.aula04032024.entities.Funcionario;

public class AdicionaFuncionario implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Executando a logica e redirecionando...");
        
		// buscando os parâmetros no request
		String nomeCompleto = req.getParameter("nome");
		String matricula = req.getParameter("matricula");
		Long codDepartamento = Long.parseLong(req.getParameter("id_departamento"));

		// monta um objeto funcionario
		Funcionario funcionario = new Funcionario();
		funcionario.setNomeCompleto(nomeCompleto);
		funcionario.setMatricula(matricula);
		funcionario.getDepartamento().setId(codDepartamento);

		// salva o Funcionário
		FuncionarioDao dao;
		try {
			dao = new FuncionarioDao();
			dao.insereFUncionario(funcionario);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("/funcionario-adicionado.jsp");
		rd.forward(req, res);
		
	}
}
