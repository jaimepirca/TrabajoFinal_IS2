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
 * Servlet implementation class LoginPacienteManualRegistroServ
 */
public class LoginPacienteManualRegistroServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String cod = request.getParameter("usuario");
		
		UsuarioIF dao = new UsuarioDAO();
		
		RequestDispatcher rd;
		PacienteBean p = null;
		MedicamentoIF dao2 = new MedicamentoDAO();
		
		List<MalestarBean> l = new ArrayList<MalestarBean>();
		
		l = dao2.getMalestar();
		
		sesion.setAttribute("LISTAMALESTAR", l);
		
		if (!cod.equals("")){
			if (dao.validaUsuarioParaRegistroManual(cod)){
				p = dao.getPaciente(cod);
				
				sesion.setAttribute("PACIENTE", p);
				
				rd = request.getRequestDispatcher("/enfermeraSolicitudPastillaManual.jsp");
				rd.forward(request, response);

			}else{
				sesion.setAttribute("FALLOLOGIN", "Paciente no registrado");
				rd = request.getRequestDispatcher("/enfermeraLoginPacienteParaRegistroManual.jsp");
				rd.forward(request, response);
			}
		}else{
			sesion.setAttribute("FALLOLOGIN", "Ingrese codigo de Paciente");

			rd = request.getRequestDispatcher("/enfermeraLoginPacienteParaRegistroManual.jsp");
			rd.forward(request, response);
		}

	}

}
