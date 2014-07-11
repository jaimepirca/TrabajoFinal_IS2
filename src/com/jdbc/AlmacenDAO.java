package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Salida_AlBean;

public class AlmacenDAO implements AlmacenIF {
	
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
	
	

	public void pedirMedicamento(int cod_medicamento,
			int cantidad, String cod_paciente, String fecha, String hora) {
		String sql1 = "SELECT CANTIDAD FROM ALMACEN WHERE COD_MEDICAMENTO = ?";
		String sql2 = "UPDATE ALMACEN SET CANTIDAD = ? WHERE COD_MEDICAMENTO = ?";
		
		
		
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2= null;
		ResultSet rs= null;
		
		
		
		
		int cant_almacen = 0;
		
		try {
			pstmt2= con.prepareStatement(sql2);
			pstmt = con.prepareStatement(sql1);
			
			pstmt.setInt(1, cod_medicamento);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
			 	
				cant_almacen = rs.getInt(1);
				
			   	
			}
			
			int cant2 = cant_almacen - cantidad;
			
			//ACTUALIZO LOS VALORES DE LA TABLA ALMANCEN
			pstmt2.setInt(1, cant2);
			pstmt2.setInt(2, cod_medicamento);
			
			
			
			pstmt2.executeUpdate();
			
			
			
	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				con.close();
				pstmt2.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}



	@Override
	public List<Salida_AlBean> muestraSalida() {
		
		Connection con = getConnection();
		String sql = "SELECT * FROM SALIDA_ALMACEN";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Salida_AlBean> l = new ArrayList<Salida_AlBean>();
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Salida_AlBean sa = new Salida_AlBean();
				
				sa.setCod_salida(rs.getInt(1));
				sa.setCod_paciente(rs.getString(2));
				sa.setCantidad(rs.getInt(3));
				sa.setFecha(rs.getString(4));
				
				l.add(sa);
				
			}
			
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				con.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return l;
	}
	
	@Override
	public boolean validaMedicamento(int cod_medicamento, int cantidad) {
		
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
         String sql = "SELECT CANTIDAD FROM ALMACEN WHERE COD_MEDICAMENTO=?";
         
         
		
		boolean  esValido = false;
		
		con = getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setInt(1, cod_medicamento);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				if(rs.getInt(1) > cantidad){
					esValido = true;
				}
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
		
		return esValido;
	}
	
	public void sumaMedicamentoCanceladoAlmacen(String nombreMed,
			int cantidad) {
		String sql1 = "SELECT A.CANTIDAD, A.COD_MEDICAMENTO FROM ALMACEN A INNER JOIN MEDICAMENTO M ON A.COD_MEDICAMENTO = M.COD_MEDICAMENTO WHERE M.NOMBRE = ?";
		String sql2 = "UPDATE ALMACEN SET CANTIDAD = ? WHERE COD_MEDICAMENTO = ?";
		
		
		
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2= null;
		ResultSet rs= null;
		
		
		
		
		int cant_almacen = 0;
		int cod_medicamento = 0;
		
		try {
			pstmt2= con.prepareStatement(sql2);
			pstmt = con.prepareStatement(sql1);
			
			pstmt.setString(1, nombreMed);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
			 	
				cant_almacen = rs.getInt(1);
				cod_medicamento = rs.getInt(2);
			   	
			}
			
			int cant2 = cant_almacen + cantidad;
			
			//ACTUALIZO LOS VALORES DE LA TABLA ALMANCEN
			pstmt2.setInt(1, cant2);
			pstmt2.setInt(2, cod_medicamento);
			
			
			
			pstmt2.executeUpdate();
			
			
			
	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				con.close();
				pstmt2.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	

}