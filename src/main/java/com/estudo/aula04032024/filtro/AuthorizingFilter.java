package com.estudo.aula04032024.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estudo.aula04032024.entities.Login;

@WebFilter(urlPatterns = {
"mvc"		
})
public class AuthorizingFilter implements Filter {

	Login login = new Login();
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		
		
		if (login.getUsuario() == null && !request.getRequestURI().endsWith("/login.html")
				&& !request.getRequestURI().contains("/javax.faces.resource/")) {
			response.sendRedirect(request.getContextPath() + "/login.html");
		} else {
			chain.doFilter(req, res);
		}
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
