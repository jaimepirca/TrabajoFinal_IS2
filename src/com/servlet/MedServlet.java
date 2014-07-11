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
import com.bean.MedicamentoBean;
import com.jdbc.MedicamentoDAO;
import com.jdbc.MedicamentoIF;

/**
 * Servlet implementation class MedServlet
 */
public class MedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		String cod = request.getParameter("codMalestar");
		
		MedicamentoIF dao = new MedicamentoDAO();
		
		List<MedicamentoBean> l2 = new ArrayList<MedicamentoBean>();
		
		l2 = dao.filtraMedicamento(cod);
		
		String s1 = dao.getMalestar2(cod);
		sesion.setAttribute("MALESTAR", s1);
		sesion.setAttribute("LISTAMEDIC", l2);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/enfermeraSolicitudPastillaManual2.jsp");
		rd.forward(request, response);
		
		
	}

}
