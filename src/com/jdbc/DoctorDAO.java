package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.MedicoBean;

public class DoctorDAO implements DoctorIF {

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
	public List<MedicoBean> getAllDoctor() {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMPLEADO_MEDICO WHERE CARGO = ?";

		con = getConnection();

		List<MedicoBean> l = new ArrayList<MedicoBean>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"Doctor");
			rs = pstmt.executeQuery();

			while(rs.next()){
				MedicoBean ma = new MedicoBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), "");
				
				l.add(ma);
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	



	return l;
	}

	@Override
	public MedicoBean getDoctor(String codigo) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMPLEADO_MEDICO WHERE COD_DOCTOR = ?";
		int cod = Integer.parseInt(codigo);
		con = getConnection();

		MedicoBean m = new MedicoBean();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,cod);
			rs = pstmt.executeQuery();

			while(rs.next()){
				m = new MedicoBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), "");
				m.setCodigo(rs.getString(1));
				m.setApellido(rs.getString(2));
				m.setNombre(rs.getString(3));
				m.setRuc(rs.getString(4));
				m.setEspecialista(rs.getString(5));
				m.setCargo(rs.getString(6));
				m.setTelefono(rs.getString(7));
				m.setDireccion(rs.getString(8));
				m.setCalle(rs.getString(9));
				m.setDistrito(rs.getString(10));
				m.setInterior(rs.getString(11));
				m.setCorreo(rs.getString(12));
				m.setFecha_nac(rs.getString(13));
				m.setSexo(rs.getString(14));
				
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	



	return m;
	}

}
