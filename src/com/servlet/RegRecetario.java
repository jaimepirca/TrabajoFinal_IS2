package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.PacienteBean;
import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;

/**
 * Servlet implementation class RegRecetario
 */
public class RegRecetario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		String[] recetario = request.getParameterValues("recetario");
		
		
		PacienteBean p = (PacienteBean)sesion.getAttribute("PACIENTE");
		
		RegistrosIF dao = new RegistrosDAO();
		
		
		dao.registraReceta(p.getCodigo(), recetario);
		
		sesion.setAttribute("RPTACONF", "Recetario del alumno guardado en el sistema");
		
		RequestDispatcher rd = request.getRequestDispatcher("/medicoConfirmaRegistroReceta.jsp");
		rd.forward(request, response);
		
		
		
	}

}
