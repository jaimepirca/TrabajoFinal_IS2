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
import com.bean.PacienteBean;
import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;
import com.jdbc.UsuarioDAO;
import com.jdbc.UsuarioIF;

/**
 * Servlet implementation class LoginAlumnoEspecificoHistorialPastilla
 */
public class LoginAlumnoEspecificoHistorialPastilla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String cod = (String)sesion.getAttribute("codigopaciente");
		
		//UsuarioIF dao = new UsuarioDAO();
		
		RegistrosIF dao1 = new RegistrosDAO();
		
		
		RequestDispatcher rd;
		//PacienteBean p = null;
		
		List<HistorialPastillaBean> l = new ArrayList<HistorialPastillaBean>();
		
		l=dao1.getHistorialPastillaAlumnoEspecifico(cod);
		sesion.setAttribute("lHistorialPastillaAlumno", l);
		
		rd = request.getRequestDispatcher("/generalListaHistorialPastillaDelAlumno.jsp");
		rd.forward(request, response);
		
		/*
		if (!cod.equals("")){
			if (dao.validaUsuarioParaRegistroManual(cod)){
				p = dao.getPaciente(cod);
				
				//YA NO DEBERIA PEDIR EL CODIGO
				//PODEMOS HACER QUE NUEVAMENTE CUANDO SE PRESIONE EL BOTON SE PIDA NUEVAMENTE EL CODIGO 
				//FUNCIONARIA PERO NO SERIA ADECUADO...
				l=dao1.getHistorialPastillaAlumnoEspecifico(p.getCodigo());
				
				sesion.setAttribute("lHistorialGeneralPastillasDelAlumno", l);
				sesion.setAttribute("PACIENTE", p);
				
				rd = request.getRequestDispatcher("/ListaHistorialPastillaDelAlumno.jsp");
				rd.forward(request, response);
			
			}
		}
		if(cod.equals("")){
			rd = request.getRequestDispatcher("/LoginPacienteParaRegistroManual.jsp");
			rd.forward(request, response);
		}
		*/
	}

}
