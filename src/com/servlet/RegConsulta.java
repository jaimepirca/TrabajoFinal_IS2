package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.PacienteBean;
import com.bean.SecretariaBean;
import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;

/**
 * Servlet implementation class RegConsulta
 */
public class RegConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		String cod_horario = request.getParameter("fechahora");
		int cod_horario2 = Integer.parseInt(cod_horario);
		
		String fecha = request.getParameter("fecha");
		String hora = request.getParameter("hora");
		PacienteBean p = new PacienteBean();
		p = (PacienteBean)sesion.getAttribute("PACIENTE");
		
		SecretariaBean s = new SecretariaBean();
		s = (SecretariaBean)sesion.getAttribute("SECRETARIA");
		
		
		RegistrosIF dao = new RegistrosDAO();
		dao.registraConsulta(p.getCodigo(), s.getCod_secretaria(), hora, fecha, cod_horario2);
		
		dao.cambiaEstadoHorario(cod_horario2);
		
		RequestDispatcher rd = request.getRequestDispatcher("/secretariarptaconsulta.jsp");
		rd.forward(request, response);
	}

}
