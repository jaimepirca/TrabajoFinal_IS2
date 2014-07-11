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

import com.bean.HistorialConsultaBean;

import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;

/**
 * Servlet implementation class ListaHistorialGeneralConsulta
 */
public class ListaHistorialGeneralConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		List<HistorialConsultaBean> l = new ArrayList<HistorialConsultaBean>();
		
		RegistrosIF dao = new RegistrosDAO();
		
		l=dao.getHistorialConsulta();
		
		sesion.setAttribute("lHistorialGeneralConsultas", l);
		
		RequestDispatcher rd = request.getRequestDispatcher("/secretariaListaPacientesEspera.jsp");
		rd.forward(request,response);
	}

}
