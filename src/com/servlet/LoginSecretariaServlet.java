package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MedicoBean;
import com.bean.SecretariaBean;
import com.jdbc.DoctorDAO;
import com.jdbc.DoctorIF;
import com.jdbc.UsuarioDAO;
import com.jdbc.UsuarioIF;

/**
 * Servlet implementation class LoginEnfermeraServlet
 */
public class LoginSecretariaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String cod = request.getParameter("usuario");
		String contra = request.getParameter("contrasena");
		
		UsuarioIF dao = new UsuarioDAO();
		
		
		RequestDispatcher rd;
		SecretariaBean s = null;
		
		
		if (!cod.equals("") && !contra.equals("")){
			if (dao.validaUsuarioSecretaria(cod, contra)){
				s = dao.getSecretaria(cod);
				
				sesion.setAttribute("SECRETARIA", s);
				
				rd = request.getRequestDispatcher("/secretariaPrincipal.jsp");
				rd.forward(request, response);
			}else {
				rd = request.getRequestDispatcher("/fallologin.jsp");
				rd.forward(request, response);
			}
		}
		if(cod.equals("") || contra.equals("")){
			rd = request.getRequestDispatcher("/secretariaLogin.jsp");
			rd.forward(request, response);
		}
	}

}
