package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.PacienteBean;
import com.jdbc.AlmacenDAO;
import com.jdbc.AlmacenIF;
import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;

/**
 * Servlet implementation class EliminarEntrega
 */
public class EliminarEntrega extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		
		RegistrosIF dao = new RegistrosDAO();
		AlmacenIF dao1 = new AlmacenDAO();
		
		String cod_reporte = request.getParameter("cod_Reporte");
		
		System.out.println(request.getParameter("cod_Reporte"));
		int cod = Integer.parseInt(cod_reporte);
		
		String cantidad = request.getParameter("cantidad");
		System.out.println(request.getParameter("cantidad"));
		int cant = Integer.parseInt(cantidad);
		
		String nombreMed = request.getParameter("nombreMedicamento");
		
		
		
		
		
		PacienteBean p = (PacienteBean)sesion.getAttribute("PACIENTE");
		
		dao.eliminaEntregaMedicamento(p.getCodigo(), cod);
		
		dao1.sumaMedicamentoCanceladoAlmacen(nombreMed,cant );
		
		
		sesion.setAttribute("RPTACONF", "Se cancelo la entrega del medicamento");
		
		RequestDispatcher rd = request.getRequestDispatcher("/respuestaEliminacion.jsp");
		rd.forward(request, response);
	}

}
