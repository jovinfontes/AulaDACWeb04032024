package com.estudo.aula04032024.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estudo.aula04032024.dao.FuncionarioDao;
import com.estudo.aula04032024.entities.Funcionario;

/**
 * Servlet implementation class AdicionaFuncionarioServlet
 */
@SuppressWarnings("serial")
public class AdicionaFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// busca o writer
		PrintWriter out = response.getWriter();

		// buscando os parâmetros no request
		String nomeCompleto = request.getParameter("nome");
		String matricula = request.getParameter("matricula");
		Long codDepartamento = Long.parseLong(request.getParameter("id_departamento"));
		

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

		RequestDispatcher rd = request.getRequestDispatcher("/funcionario-adicionado.jsp");
		rd.forward(request,response);
	}

}
