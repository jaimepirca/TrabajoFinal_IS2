package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.HistorialConsultaBean;
import com.bean.HistorialConsultaBean2;
import com.bean.HistorialPastillaBean;
import com.bean.HorarioMedico;
import com.bean.PacienteBean;
import com.bean.PacienteEsperaBean;
import com.bean.RegistrosAlumno;
import com.bean.ReporteBean;
import com.bean.SolicitudMedBean;

public class RegistrosDAO implements RegistrosIF {

	String url = "jdbc:mysql://localhost:3306/proyectofis?user=root&password=root";
	
	private Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	@Override
	public void insertaSolMedicamento(SolicitudMedBean s) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PETICION_PASTILLA VALUES(?,?,?,?,?,?,?,?,?)";
		
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,s.getCod_registro());
			pstmt.setString(2,s.getCod_secretaria());
			pstmt.setString(3,s.getCod_paciente());
			pstmt.setInt(4,s.getCod_medicamento());
			pstmt.setInt(5,s.getCantidad());
			pstmt.setString(6,s.getCodigo_medico());
			pstmt.setString(7,s.getHora());
			pstmt.setString(8,s.getFecha());
			pstmt.setString(9, s.getEstado());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		

	}

	@Override
	public List<ReporteBean> getSolicitudesPendientes() {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT PP.COD_REGISTRO_MED ,CONCAT(P.NOMBRE, ' ', P.APELLIDO), M.NOMBRE, PP.CANTIDAD, PP.HORA FROM PETICION_PASTILLA PP INNER JOIN PACIENTE P ON" +
				" PP.COD_PACIENTE = P.COD_PACIENTE INNER JOIN MEDICAMENTO M ON PP.COD_MEDICAMENTO = M.COD_MEDICAMENTO   " +
				"  WHERE PP.ESTADO=?";
		ResultSet rs = null;
		List<ReporteBean> l = new ArrayList<ReporteBean>();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Pendiente");
			
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				ReporteBean s = new ReporteBean();
				
				s.setCod_reporte(rs.getInt(1));
				s.setNombrePaciente(rs.getString(2));
				s.setNombrePastilla(rs.getString(3));
				s.setCantidad(rs.getString(4));
				s.setHora(rs.getString(5));
				

				
				l.add(s);
				
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return l;
	}

	@Override
	public void confirmaEntregaMedicamento(String cod,int cod_registro_med) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE PETICION_PASTILLA SET CODIGO_MEDICO=?, ESTADO=? WHERE COD_REGISTRO_MED=?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,cod);
			pstmt.setString(2, "Entregado");
			pstmt.setInt(3, cod_registro_med);
			pstmt.executeUpdate();
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	


	}
	
	@Override
	public void confirmaAtencionMedica(int cod_cita) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE HORARIODISPMEDICO SET ESTADO=? WHERE COD_HORARIO=?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Atendido");
			pstmt.setInt(2, cod_cita);
			pstmt.executeUpdate();
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	


	}


	@Override
	public List<RegistrosAlumno> getRegistrosAlumno(String codigo) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT M.NOMBRE, PP.CANTIDAD, PP.HORA, PP.FECHA, PP.ESTADO FROM PETICION_PASTILLA PP INNER JOIN PACIENTE P ON" +
				" PP.COD_PACIENTE = P.COD_PACIENTE INNER JOIN MEDICAMENTO M ON PP.COD_MEDICAMENTO = M.COD_MEDICAMENTO   " +
				"  WHERE PP.COD_PACIENTE=? ORDER BY PP.FECHA DESC, PP.HORA DESC";
		ResultSet rs = null;
		List<RegistrosAlumno> l = new ArrayList<RegistrosAlumno>();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, codigo);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				RegistrosAlumno r = new RegistrosAlumno();
				
				r.setMedicamento(rs.getString(1));
				r.setCantidad(rs.getInt(2));
				r.setHora(rs.getString(3));
				r.setFecha(rs.getString(4));
				r.setEstado(rs.getString(5));
				
				l.add(r);
				
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return l;
	}

	
	@Override
	public List<HistorialPastillaBean> getHistorialPastilla() {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT PETICION_PASTILLA.FECHA, PETICION_PASTILLA.COD_REGISTRO_MED, PACIENTE.NOMBRE, PACIENTE.APELLIDO, MEDICAMENTO.NOMBRE , PETICION_PASTILLA.CANTIDAD, PETICION_PASTILLA.HORA, PETICION_PASTILLA.ESTADO FROM PETICION_PASTILLA" +
				" INNER JOIN PACIENTE ON PACIENTE.COD_PACIENTE = PETICION_PASTILLA.COD_PACIENTE " +
				" INNER JOIN MEDICAMENTO ON MEDICAMENTO.COD_MEDICAMENTO = PETICION_PASTILLA.COD_MEDICAMENTO WHERE PETICION_PASTILLA.ESTADO = ? ";
		
		ResultSet rs = null;
		List<HistorialPastillaBean> l = new ArrayList<HistorialPastillaBean>();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Entregado");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				HistorialPastillaBean hpb = new HistorialPastillaBean();
				/*
				hpb.setFecha(rs.getString(1));
				hpb.setCod_reg_med(rs.getInt(2));
				hpb.setCod_paciente(rs.getString(3));
				hpb.setApellido(rs.getString(4));
				hpb.setCod_medic(rs.getString(5));
				hpb.setCantidad(rs.getInt(6));
				hpb.setHora(rs.getString(7));
				hpb.setEstado(rs.getString(8));
				*/
				l.add(hpb);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return l;
	}


	

	@Override
	public boolean buscaPeticionEspera(String cod) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM PETICION_PASTILLA WHERE COD_PACIENTE=? AND ESTADO=?";
		ResultSet rs = null;
		boolean rpta=false;
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,cod);
			pstmt.setString(2, "Pendiente");
			rs = pstmt.executeQuery();
			
			if (rs.next()){
				rpta=true;
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return rpta;
	}


	
	public void validaMinutos() {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT HORA FROM PETICION_PASTILLA WHERE ESTADO='Pendiente'";
		ResultSet rs = null;
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date hr = new Date();
		
		try {
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				hr = rs.getDate(1);
				
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("hh:mm:ss");
				
				String strFecha = getHoraActual();
				Date hora = null;
				try {

					hora = formatoDelTexto.parse(strFecha);

				} catch (ParseException ex) {

				ex.printStackTrace();

				}
				
				
				
				
				
				
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		
	}

	private static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }


	
	public void registraReceta(String Cod_paciente, String [] receta) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		
		String receta2= "";
		
		for(int i = 0; i<receta.length; i++){

			receta2 += receta[i] ;

		}
		
		String sql = "INSERT INTO TRATAMIENTO VALUES(?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
		  	pstmt.setInt(1, 0);
		  	pstmt.setString(2, Cod_paciente);
		  	pstmt.setString(3, receta2);
		  	
		  	
		  	pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}


	public List<HistorialPastillaBean> getHistorialPastillaAlumnoEspecifico(
			String Cod_paciente) {
		  Connection con= getConnection();
		  PreparedStatement pstmt = null;
		  /*String sql = "SELECT PETICION_PASTILLA.FECHA, PETICION_PASTILLA.COD_REGISTRO_MED, PACIENTE.NOMBRE, PACIENTE.APELLIDO, MEDICAMENTO.NOMBRE , PETICION_PASTILLA.CANTIDAD, PETICION_PASTILLA.HORA, PETICION_PASTILLA.ESTADO FROM PETICION_PASTILLA" +
				" INNER JOIN PACIENTE ON PACIENTE.COD_PACIENTE = PETICION_PASTILLA.COD_PACIENTE " +
		         " INNER JOIN MEDICAMENTO ON MEDICAMENTO.COD_MEDICAMENTO = PETICION_PASTILLA.COD_MEDICAMENTO WHERE PETICION_PASTILLA.ESTADO = ? AND PETICION_PASTILLA.COD_PACIENTE = ? ";
		*/
		  String sql1 = "SELECT PP.COD_REGISTRO_MED, M.NOMBRE, PP.CANTIDAD, EM.NOMBRE, EM.APELLIDO, CONCAT(PP.HORA, ' ', PP.FECHA) AS FECHA, PP.ESTADO"+
				 " FROM PETICION_PASTILLA PP INNER JOIN MEDICAMENTO M ON PP.COD_MEDICAMENTO = M.COD_MEDICAMENTO"+
				 " INNER JOIN EMPLEADO_MEDICO EM ON PP.CODIGO_MEDICO = EM.COD_DOCTOR"+
				 " WHERE PP.COD_PACIENTE = ?";
		  ResultSet rs = null;
			List<HistorialPastillaBean> l = new ArrayList<HistorialPastillaBean>();
			
			try {
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, Cod_paciente);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					
					HistorialPastillaBean hpb = new HistorialPastillaBean();
					
					hpb.setCod_reg_med(rs.getInt(1));
					hpb.setCod_medic(rs.getString(2));
					hpb.setCantidad(rs.getInt(3));
					hpb.setMedico(rs.getString(4));
					hpb.setApMedico(rs.getString(5));
					hpb.setFecha(rs.getString(6));
					hpb.setEstado(rs.getString(7));
					
					l.add(hpb);
					
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			return l;
		}


	
	public List<HistorialConsultaBean2> getHistorialConsultaAlumnoEspecifico(
			String Cod_paciente) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		/*
		String sql = "SELECT PC.FECHA, PC.COD_CITA, P.NOMBRE, P.APELLIDO, EM.NOMBRE, EM.APELLIDO, C.DESCRIPCION, S.NOMBRE, PC.HORA, PC.ESTADO " +
				" FROM PETICION_CONSULTA PC INNER JOIN EMPLEADO_MEDICO EM ON" +
				" PC.EMPLEADO_MEDICO_COD_DOCTOR = EM.COD_DOCTOR" +
				" INNER JOIN PACIENTE P ON PC.PACIENTE_COD_PACIENTE = P.COD_PACIENTE" +
				" LEFT OUTER JOIN SECRETARIO S ON PC.SECRETARIO_COD_SECRETARIO = S.COD_SECRETARIO" +
				" INNER JOIN CONSULTORIO C ON PC.CONSULTORIO_ID_CONSULTORIO = C.ID_CONSULTORIO WHERE PC.ESTADO = ? AND PC.PACIENTE_COD_PACIENTE= ?" ;
		*/
		
		String sql1 = "SELECT EM.NOMBRE, EM.APELLIDO, CONCAT(H.HORA, ' ', D.DIA) AS FECHA, CONCAT(PC.HORA_REGISTRO, ' ', PC.DIA_REGISTRO) AS FECHA2, HDM.ESTADO"+
				" FROM PETICION_CONSULTA PC "+
				" INNER JOIN PACIENTE P ON PC.COD_PACIENTE = P.COD_PACIENTE"+
				" INNER JOIN HORARIODISPMEDICO HDM ON PC.COD_HORARIO = HDM.COD_HORARIO"+
				" INNER JOIN EMPLEADO_MEDICO EM ON HDM.COD_MEDICO = EM.COD_DOCTOR"+
				" INNER JOIN HORA H ON HDM.COD_HORA = H.COD_HORA"+
				" INNER JOIN DIA D ON HDM.COD_DIA=D.COD_DIA"+
				" WHERE PC.COD_PACIENTE=?";
		ResultSet rs = null;
		List<HistorialConsultaBean2> l = new ArrayList<HistorialConsultaBean2>();
		
		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, Cod_paciente);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				
				HistorialConsultaBean2 hc = new HistorialConsultaBean2();
				
				hc.setNombre(rs.getString(1));
				hc.setApellido(rs.getString(2));
				hc.setFecha(rs.getString(3));
				hc.setFecha2(rs.getString(4));
				hc.setEstado(rs.getString(5));
				
				l.add(hc);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		return l;
	}


	@Override
	public float minutosPasados(int cod_reporte) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		float minutos=0;
		String sql = "select (curtime() - hora)/100 from peticion_pastilla where cod_registro_med=?";
		ResultSet rs = null;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cod_reporte);
			rs = pstmt.executeQuery();
			
			if (rs.next()){
				minutos=rs.getInt(1);
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return minutos;
	}


	@Override
	public void cancelaMedAuto(int cod_reporte) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE PETICION_PASTILLA SET ESTADO=? WHERE COD_REGISTRO_MED=?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Cancelado");
			pstmt.setInt(2,cod_reporte);
			pstmt.executeUpdate();
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
	}


	@Override
	public List<ReporteBean> getMedicamentoEnEspera(String Cod_paciente) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "SELECT PP.COD_REGISTRO_MED ,CONCAT(P.NOMBRE, ' ', P.APELLIDO), M.NOMBRE, PP.CANTIDAD, PP.HORA FROM PETICION_PASTILLA PP INNER JOIN PACIENTE P ON" +
				" PP.COD_PACIENTE = P.COD_PACIENTE INNER JOIN MEDICAMENTO M ON PP.COD_MEDICAMENTO = M.COD_MEDICAMENTO   " +
				"  WHERE PP.ESTADO=? AND PP.COD_PACIENTE=?";
		
		List<ReporteBean> l = new ArrayList<ReporteBean>();
		
		ResultSet rs = null;
		
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Pendiente");
			pstmt.setString(2, Cod_paciente);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				ReporteBean s = new ReporteBean();
				
				s.setCod_reporte(rs.getInt(1));
				s.setNombrePaciente(rs.getString(2));
				s.setNombrePastilla(rs.getString(3));
				s.setCantidad(rs.getString(4));
				s.setHora(rs.getString(5));
			l.add(s);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return l;
	}


	@Override
	public void eliminaEntregaMedicamento(String Cod_paciente, int cod_reg_med) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE PETICION_PASTILLA SET COD_PACIENTE=?, ESTADO=? WHERE COD_REGISTRO_MED=?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,Cod_paciente);
			pstmt.setString(2, "Cancelado");
			pstmt.setInt(3, cod_reg_med);
			pstmt.executeUpdate();
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

//----------------------------------------------------------------------------------------
	@Override
	public void registraConsulta(String cod_paciente, String cod_secretario,String hora, String dia, int cod_horario) {
		// TODO Auto-generated method stub
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PETICION_CONSULTA VALUES(?,?,?,?,?,?)";
		
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,0);
			pstmt.setInt(2,cod_horario);
			pstmt.setString(3, cod_paciente);
			pstmt.setString(4,cod_secretario);
			//hora de registro
			pstmt.setString(5, hora);
			pstmt.setString(6,dia);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}


	@Override
	public List<HistorialConsultaBean> getHistorialConsulta() {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
	  
		String sql1 = "SELECT PC.COD_CITA, "+
				"CONCAT(EM.NOMBRE, ' ',EM.APELLIDO) AS NMED, "+
				"CONCAT(P.NOMBRE, ' ', P.APELLIDO) AS NPAC, "+
				"S.NOMBRE, "+
				"CONCAT(PC.HORA_REGISTRO, ' ', PC.DIA_REGISTRO) AS FECHA, "+
				"CONCAT(H.HORA, ' ', D.DIA) AS FECHA_SOL "+
				"FROM PETICION_CONSULTA PC INNER JOIN PACIENTE P ON PC.COD_PACIENTE = P.COD_PACIENTE "+
				"INNER JOIN HORARIODISPMEDICO HDM ON PC.COD_HORARIO = HDM.COD_HORARIO "+
				"INNER JOIN EMPLEADO_MEDICO EM ON HDM.COD_MEDICO = EM.COD_DOCTOR "+
				"INNER JOIN SECRETARIO S ON PC.COD_SECRETARIA = S.COD_SECRETARIO "+
				"INNER JOIN HORA H ON HDM.COD_HORA = H.COD_HORA "+
				"INNER JOIN DIA D ON HDM.COD_DIA=D.COD_DIA "+
				"WHERE HDM.ESTADO = ? "+
				"ORDER BY PC.COD_HORARIO ASC";
		ResultSet rs = null;
		List<HistorialConsultaBean> l = new ArrayList<HistorialConsultaBean>();
		
		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, "Pendiente");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				HistorialConsultaBean hcb = new HistorialConsultaBean();
				hcb.setCodigo(rs.getInt(1));
				hcb.setNombre_medico(rs.getString(2));
				hcb.setNombre_paciente(rs.getString(3));
				hcb.setNombre_secretaria(rs.getString(4));
				hcb.setFecha_registro(rs.getString(5));
				hcb.setFecha_solicitada(rs.getString(6));
				
				l.add(hcb);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return l;
	}


	@Override
	public List<PacienteEsperaBean> getPacientesEnEspera(String codigo_medico) {
			Connection con= getConnection();
			PreparedStatement pstmt = null;
		  
			String sql1 = "SELECT PC.COD_CITA,PC.COD_HORARIO, PC.COD_PACIENTE, P.NOMBRE, P.APELLIDO, CONCAT(H.HORA, ' ', D.DIA) AS FECHA"+
					" FROM PETICION_CONSULTA PC "+
					" INNER JOIN HORARIODISPMEDICO HDM ON PC.COD_HORARIO = HDM.COD_HORARIO"+
					" INNER JOIN PACIENTE P ON PC.COD_PACIENTE = P.COD_PACIENTE"+
					" INNER JOIN HORA H ON HDM.COD_HORA = H.COD_HORA"+
					" INNER JOIN DIA D ON HDM.COD_DIA=D.COD_DIA"+
					" WHERE HDM.COD_MEDICO = ? AND HDM.ESTADO = ?"+
					" ORDER BY PC.COD_HORARIO";
			ResultSet rs = null;
			List<PacienteEsperaBean> l = new ArrayList<PacienteEsperaBean>();
			
			try {
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, codigo_medico);
				pstmt.setString(2, "Pendiente");
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					
					PacienteEsperaBean peb = new PacienteEsperaBean();
					peb.setCod_cita(rs.getInt(1));
					peb.setCod_horario(rs.getInt(2));
					peb.setCodigo(rs.getString(3));
					peb.setNombre(rs.getString(4));
					peb.setApellido(rs.getString(5));
					peb.setFecha_pedida(rs.getString(6));
					
					l.add(peb);
					
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			return l;
	}


	@Override
	public PacienteBean buscaAlumnoConfirmadoConsulta(int cod_cita) {
		// TODO Auto-generated method stub
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "SELECT P.COD_PACIENTE, P.NOMBRE, P.APELLIDO"+
				" FROM PETICION_CONSULTA PC INNER JOIN PACIENTE P ON PC.COD_PACIENTE = P.COD_PACIENTE" +
				" WHERE PC.COD_CITA = ?";
		
		PacienteBean p = new PacienteBean();
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cod_cita);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				
				p.setCodigo(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setApellido(rs.getString(3));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return p;
	}


	@Override
	public List<HorarioMedico> getHorarioMedico(String cod_medico) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT  HDM.COD_HORARIO, CONCAT(EM.NOMBRE, ' ', EM.APELLIDO) AS MEDICO,CONCAT(D.DIA) AS DIA, H.HORA, HDM.ESTADO"+
				" FROM horariodispmedico hdm INNER JOIN DIA D ON HDM.COD_DIA = D.COD_DIA"+
				" INNER JOIN HORA H ON HDM.COD_HORA = H.COD_HORA"+
				" INNER JOIN EMPLEADO_MEDICO EM ON HDM.COD_MEDICO = EM.COD_DOCTOR"+
				" where cod_medico =?"+
				" LIMIT 25";
		List<HorarioMedico> l = new ArrayList<HorarioMedico>();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cod_medico);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				HorarioMedico hm = new HorarioMedico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				
				l.add(hm);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return l;
	}


	@Override
	public void cambiaEstadoHorario(int cod_horario) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE HORARIODISPMEDICO SET ESTADO=? WHERE COD_HORARIO=?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Pendiente");
			pstmt.setInt(2, cod_horario);
			pstmt.executeUpdate();
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



	@Override
	public boolean puedePedir(String cod_paciente) {
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		String sql = "select sum(cantidad) from peticion_pastilla pp where fecha=curdate() and cod_paciente = ?";
		ResultSet rs = null;
		boolean rpta=false;
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,cod_paciente);
			rs = pstmt.executeQuery();
			
			if (rs.next()){
				if(rs.getInt(1)<5){
					rpta=true;
				}	
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return rpta;
	}

}
