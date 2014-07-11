package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.PacienteBean;
import com.jdbc.UsuarioDAO;
import com.jdbc.UsuarioIF;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String cod = request.getParameter("usuario");
		String contra = request.getParameter("contrasena");
		
		UsuarioIF dao = new UsuarioDAO();
		
		
		RequestDispatcher rd;
		PacienteBean p = null;
		
		
		if (!cod.equals("") && !contra.equals("")){
			if (dao.validaUsuario(cod, contra)){
				p = dao.getPaciente(cod);
				
				sesion.setAttribute("PACIENTE", p);
				
				rd = request.getRequestDispatcher("/principal.jsp");
				rd.forward(request, response);
			}else {
				rd = request.getRequestDispatcher("/fallologin.jsp");
				rd.forward(request, response);
			}
		}
		if(cod.equals("") || contra.equals("")){
			rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
