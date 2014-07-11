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
 * Servlet implementation class SolicitudMedicamento
 */
public class SolicitudMedicamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		
		MedicamentoIF dao = new MedicamentoDAO();
		
		List<MalestarBean> l = new ArrayList<MalestarBean>();
		
		l = dao.getMalestar();
		
		
		sesion.setAttribute("LISTAMALESTAR", l);
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/solpastilla.jsp");
		rd.forward(request, response);
		
	}


}
