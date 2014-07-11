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

import com.bean.MedicamentoBean;
import com.bean.MedicoBean;
import com.bean.PacienteBean;
import com.bean.SolicitudMedBean;
import com.jdbc.*;

public class RegMedicamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession(true);
		
		String cod = request.getParameter("codMedicamento");
		String cant = request.getParameter("cantMedicamento");
		String fecha = request.getParameter("fecha");
		String hora = request.getParameter("hora");
		int cod2 = Integer.parseInt(cod);

		int cant2=0;

		
		PacienteBean p = (PacienteBean)sesion.getAttribute("PACIENTE");
		MedicoBean m = (MedicoBean)sesion.getAttribute("MEDICO");

		RegistrosIF dao = new RegistrosDAO();
		AlmacenIF dao2 = new AlmacenDAO();

		if (!cant.equals("")){
			cant2 = Integer.parseInt(cant);
			if(dao.puedePedir(p.getCodigo())){

				if(dao2.validaMedicamento(cod2, cant2)){
					SolicitudMedBean smb = new SolicitudMedBean();
					smb.setCod_paciente(p.getCodigo());
					smb.setCod_medicamento(cod2);
					smb.setCantidad(cant2);
					smb.setCodigo_medico(m.getCodigo());
					smb.setHora(hora);
					smb.setFecha(fecha);
					smb.setEstado("Entregado");

					dao.insertaSolMedicamento(smb);
					sesion.setAttribute("RESPUESTA", "La(s) pastilla(s) del alumn@ han sido entregada(s)");
					dao2.pedirMedicamento(cod2, cant2, p.getCodigo(), fecha, hora);

					RequestDispatcher rd = request.getRequestDispatcher("/enfermeraSolicitudPastillaManual3.jsp");
					rd.forward(request, response);
				}else{

					sesion.setAttribute("FALLOPETICION", "No hay medicamentos suficientes");

					RequestDispatcher rd1 = request.getRequestDispatcher("/enfermeraSolicitudPastillaManual2.jsp");
					rd1.forward(request, response);

				}
				
			} else {

				System.out.println("no deberia estar aca");
				sesion.setAttribute("FALLOPETICION", "No puede pedir más de 5 medicamentos");

				RequestDispatcher rd1 = request.getRequestDispatcher("/enfermeraSolicitudPastillaManual2.jsp");
				rd1.forward(request, response);
			}
		} else {

			System.out.println("debe estar aca");
			sesion.setAttribute("FALLOPETICION", "No ingresó una cantidad");
			RequestDispatcher rd1 = request.getRequestDispatcher("/enfermeraSolicitudPastillaManual2.jsp");
			rd1.forward(request, response);
			

		}
		
		
		
	}

}
