package com.estudo.aula04032024.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estudo.aula04032024.dao.FuncionarioDao;
import com.estudo.aula04032024.entities.Funcionario;

public class LogicaListaFuncionarios implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Executando a logica e redirecionando...");
        
		RequestDispatcher rd = req.getRequestDispatcher("/lista-funcionarios.jsp");
		rd.forward(req, res);

	}
}
