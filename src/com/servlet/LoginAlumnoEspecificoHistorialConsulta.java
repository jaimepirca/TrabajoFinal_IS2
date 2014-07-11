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
import com.bean.HistorialConsultaBean2;
import com.bean.HistorialPastillaBean;
import com.bean.PacienteBean;
import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;
import com.jdbc.UsuarioDAO;
import com.jdbc.UsuarioIF;

/**
 * Servlet implementation class LoginAlumnoEspecificoHistorialConsulta
 */
public class LoginAlumnoEspecificoHistorialConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String cod = (String)sesion.getAttribute("codigopaciente");
		
		/*NO VA
		UsuarioIF dao = new UsuarioDAO();
		*/
		
		RegistrosIF dao1 = new RegistrosDAO();
		
		
		RequestDispatcher rd;
		
		
		
		List<HistorialConsultaBean2> l = new ArrayList<HistorialConsultaBean2>();
		
		l = dao1.getHistorialConsultaAlumnoEspecifico(cod);
		sesion.setAttribute("lHistorialConsultaAlumno", l);
		
		rd = request.getRequestDispatcher("/generalListaHistorialConsultaDelAlumno.jsp");
		rd.forward(request, response);
		
		/*
		if (!cod.equals("")){
			if (dao.validaUsuarioParaRegistroManual(cod)){
				p = dao.getPaciente(cod);
				
				//YA NO DEBERIA PEDIR EL CODIGO
				//PODEMOS HACER QUE NUEVAMENTE CUANDO SE PRESIONE EL BOTON SE PIDA NUEVAMENTE EL CODIGO 
				//FUNCIONARIA PERO NO SERIA ADECUADO...
				l=dao1.getHistorialConsultaAlumnoEspecifico(p.getCodigo());
				
				
				sesion.setAttribute("lHistorialGeneralConsultaDelAlumno", l);
				sesion.setAttribute("PACIENTE", p);
				
				
				rd = request.getRequestDispatcher("/ListaHistorialConsultaDelAlumno.jsp");
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

