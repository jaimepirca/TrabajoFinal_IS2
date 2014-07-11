package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MedicoBean;
import com.jdbc.DoctorDAO;
import com.jdbc.DoctorIF;
import com.jdbc.UsuarioDAO;
import com.jdbc.UsuarioIF;

/**
 * Servlet implementation class LoginEnfermeraServlet
 */
public class LoginEnfermeraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String cod = request.getParameter("usuario");
		String contra = request.getParameter("contrasena");
		
		UsuarioIF dao = new UsuarioDAO();
		DoctorIF dao2 = new DoctorDAO();
		
		
		RequestDispatcher rd;
		MedicoBean m = null;
		
		
		if (!cod.equals("") && !contra.equals("")){
			if (dao.validaUsuarioEnfermera(cod, contra)){
				m = dao2.getDoctor(cod);
				
				sesion.setAttribute("MEDICO", m);
				
				rd = request.getRequestDispatcher("/enfermeraPrincipal.jsp");
				rd.forward(request, response);
			}else {
				rd = request.getRequestDispatcher("/fallologin.jsp");
				rd.forward(request, response);
			}
		}
		if(cod.equals("") || contra.equals("")){
			rd = request.getRequestDispatcher("/enfermeraLogin.jsp");
			rd.forward(request, response);
		}
	}

}
