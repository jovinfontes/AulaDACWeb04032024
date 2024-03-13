package com.estudo.aula04032024.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Executando a logica e redirecionando...");
		
		RequestDispatcher rd = req.getRequestDispatcher("/primeira-logica.jsp");
		rd.forward(req, res);
		
	}

}
