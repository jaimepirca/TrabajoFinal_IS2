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
import com.bean.PacienteBean;
import com.jdbc.DoctorDAO;
import com.jdbc.DoctorIF;
import com.jdbc.UsuarioDAO;
import com.jdbc.UsuarioIF;


/**
 * Servlet implementation class SolicitudConsulta
 */
public class SolicitudConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession(true);
		String cod = request.getParameter("usuario");
		
		UsuarioIF dao1 = new UsuarioDAO();
		PacienteBean p = null;
		
		
		DoctorIF dao = new DoctorDAO();
		
		List<MedicoBean> l = new ArrayList<MedicoBean>();
		
		l = dao.getAllDoctor();
		
		
		
		
		if (!cod.equals("")){
			if (dao1.validaUsuarioParaRegistroManual(cod)){
				p = dao1.getPaciente(cod);
				
				sesion.setAttribute("PACIENTE", p);
				sesion.setAttribute("LISTAMEDICOS", l);
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/secretariaSolConsulta.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
		
		
		
		
	}

	

}
