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

import com.bean.MedicoBean;
import com.bean.PacienteEsperaBean;
import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;

/**
 * Servlet implementation class MostrarAlumnosEnEspera
 */
public class MostrarAlumnosEnEspera extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		List<PacienteEsperaBean> l = new ArrayList<PacienteEsperaBean>();
		
		RegistrosIF dao = new RegistrosDAO();
		
		MedicoBean m = (MedicoBean)sesion.getAttribute("DOCTOR");
		
		l = dao.getPacientesEnEspera(m.getCodigo());
		
		sesion.setAttribute("lPacientesEnEspera", l);
		
		
		RequestDispatcher rd;
		
		rd = request.getRequestDispatcher("/medicoListaPacientesEspera.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
