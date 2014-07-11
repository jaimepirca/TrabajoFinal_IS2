package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.PacienteBean;

/**
 * Servlet implementation class Selecciontipohistorial
 */
public class Selecciontipohistorial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		PacienteBean p = null;
		
		RequestDispatcher rd;
		
		sesion.setAttribute("PACIENTE", p);
		
		rd = request.getRequestDispatcher("/Selecciontipohistorial.jsp");
		rd.forward(request, response);
	}

}
