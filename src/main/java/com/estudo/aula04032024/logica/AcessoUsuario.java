package com.estudo.aula04032024.logica;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estudo.aula04032024.entities.Login;

public class AcessoUsuario implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Executando a logica e redirecionando...");
        
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
		Login login = new Login();
		
		login.setUsuario(usuario);
		login.setSenha(senha);
		
		//HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if ("admin".equals(login.getUsuario()) && "123".equals(login.getSenha())) {
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.forward(req, res);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/login.html");
			rd.forward(req, res);
		}
		
		
		
	}
}
