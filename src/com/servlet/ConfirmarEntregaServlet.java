package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MedicoBean;
import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;

/**
 * Servlet implementation class ConfirmarEntregaServlet
 */
public class ConfirmarEntregaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession(true);
		
		String cod_reporte = request.getParameter("cod_Reporte");
		int cod = Integer.parseInt(cod_reporte);
		
		RegistrosIF dao = new RegistrosDAO();
		
		MedicoBean m = (MedicoBean)sesion.getAttribute("MEDICO");
		
		
		dao.confirmaEntregaMedicamento(m.getCodigo(), cod);
		
		sesion.setAttribute("RPTACONF", "Se confirmó la entrega de medicamento");
		
		RequestDispatcher rd = request.getRequestDispatcher("/respuestaConfirmacion.jsp");
		rd.forward(request, response);
		
		
	}

}
