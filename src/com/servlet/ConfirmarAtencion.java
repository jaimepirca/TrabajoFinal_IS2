package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MedicoBean;
import com.bean.PacienteBean;
import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;

/**
 * Servlet implementation class ConfirmarAtencion
 */
public class ConfirmarAtencion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		String cod_Espera = request.getParameter("cod_Espera");
		String cod_cita = request.getParameter("cod_cita");
		
		int cod = Integer.parseInt(cod_Espera);
		int cod2 = Integer.parseInt(cod_cita);
		//CREARE UN NUEVO METODO QUE CAMBIA EL ESTADO DE PENDIENTE A ATENDIDO
		RegistrosIF dao = new RegistrosDAO();
		PacienteBean p = new PacienteBean();
		//MedicoBean m = (MedicoBean)sesion.getAttribute("MEDICO");
		//no se necesita
		
		dao.confirmaAtencionMedica(cod);
		
		p = dao.buscaAlumnoConfirmadoConsulta(cod2);
		
		
		sesion.setAttribute("RPTACONF", "Se atendió al paciente " );
		sesion.setAttribute("PacienteConfirmado", p);
		RequestDispatcher rd = request.getRequestDispatcher("/medicoConfirmaAtencionMedica.jsp");
		rd.forward(request, response);
		
		
		
		
	}

}
