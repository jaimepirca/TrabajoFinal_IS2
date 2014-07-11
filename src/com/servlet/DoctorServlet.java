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

import com.bean.HorarioMedico;
import com.bean.MedicoBean;
import com.bean.PacienteBean;
import com.jdbc.DoctorDAO;
import com.jdbc.DoctorIF;
import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;
import com.jdbc.UsuarioDAO;
import com.jdbc.UsuarioIF;

/**
 * Servlet implementation class DoctorServlet
 */
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession(true);
		
		RequestDispatcher rd1;
		
		//int codigomedico = Integer.parseInt(request.getParameter("codMedico"));
		
		DoctorIF dao = new DoctorDAO();
		
		MedicoBean m = dao.getDoctor(request.getParameter("codMedico"));
		
		sesion.setAttribute("MEDICO", m);
		
		RegistrosIF dao2 = new RegistrosDAO();
		
		List<HorarioMedico> l = new ArrayList<HorarioMedico>();
		
		l = dao2.getHorarioMedico(m.getCodigo());
		
		sesion.setAttribute("HorarioMedico", l);
		
		
			
								
				
				
				
		rd1 = request.getRequestDispatcher("/secretariaSolConsulta2.jsp");
		rd1.forward(request, response);
		
	}
		
		
		
		
		/**
		 *  En la base de datos saco los codigos correspondientes al horario del medico y me da un arreglo de strings, para fines
		 *  experimentales, usaremos el siguiente arreglo
		 */
		
		
		
}


