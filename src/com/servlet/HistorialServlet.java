package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.PacienteBean;
import com.bean.RegistrosAlumno;
import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;



public class HistorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		List<RegistrosAlumno> l = new ArrayList<RegistrosAlumno>();
		
		RegistrosIF dao = new RegistrosDAO();
		PacienteBean p = (PacienteBean)sesion.getAttribute("PACIENTE");
		l= dao.getRegistrosAlumno(p.getCodigo());
		sesion.setAttribute("LISTAREGISTROALUMNO", l);
		RequestDispatcher rd = request.getRequestDispatcher("/historial.jsp");
		rd.forward(request, response);
	}

}
