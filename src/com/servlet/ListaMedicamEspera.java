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

import com.bean.ReporteBean;
import com.bean.SolicitudMedBean;
import com.jdbc.RegistrosDAO;
import com.jdbc.RegistrosIF;

/**
 * Servlet implementation class ListaMedicamEspera
 */
public class ListaMedicamEspera extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListaMedicamEspera() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession(true);
		
		List<ReporteBean> l = new ArrayList<ReporteBean>();
		
		RegistrosIF dao = new RegistrosDAO();
		
	    l = dao.getSolicitudesPendientes();
	    
	    sesion.setAttribute("lSolicPendientes", l);
	    
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/MuestraListaSolicPastPendientes.jsp");
		rd.forward(request,response);
	}

}
