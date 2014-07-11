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

import com.bean.HistorialPastillaBean;

import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;

/**
 * Servlet implementation class ListaHistorialGeneralPastilla
 */
public class ListaHistorialGeneralPastilla extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		List<HistorialPastillaBean> l = new ArrayList<HistorialPastillaBean>();
		
		RegistrosIF dao = new RegistrosDAO();
		
		l=dao.getHistorialPastilla();
		
		sesion.setAttribute("lHistorialGeneralPastillas", l);
		
		RequestDispatcher rd = request.getRequestDispatcher("/historialGeneralPastillas.jsp");
		rd.forward(request,response);
		
		
	}

}
