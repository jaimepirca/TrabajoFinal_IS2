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

import com.bean.MalestarBean;
import com.bean.PacienteBean;
import com.jdbc.MedicamentoDAO;
import com.jdbc.MedicamentoIF;
import com.jdbc.UsuarioDAO;
import com.jdbc.UsuarioIF;

/**
 * Servlet implementation class LoginAlumnoRecetar
 */
public class LoginAlumnoRecetar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
         
		String cod = request.getParameter("usuario");
		
		UsuarioIF dao = new UsuarioDAO();
		
		
		RequestDispatcher rd;
		PacienteBean p = null;
		
		
		if (!cod.equals("")){
			if (dao.validaUsuarioParaRegistroManual(cod)){
				p = dao.getPaciente(cod);
				
				sesion.setAttribute("PACIENTE", p);
				
				rd = request.getRequestDispatcher("/medicoRecetario.jsp");
				rd.forward(request, response);
			}else {
				rd = request.getRequestDispatcher("/fallologin.jsp");
				rd.forward(request, response);
			}
		}
		if(cod.equals("")){
			rd = request.getRequestDispatcher("/LoginPacienteParaRegistroManual.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
