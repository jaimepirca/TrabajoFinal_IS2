package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.MalestarBean;
import com.bean.MedicamentoBean;

public class MedicamentoDAO implements MedicamentoIF {

	
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
	
	
	

	public List<MedicamentoBean> filtraMedicamento(String malestar) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEDICAMENTO WHERE COD_MALESTAR = ?";
		int cod = Integer.parseInt(malestar);
		con = getConnection();

		List<MedicamentoBean> l = new ArrayList<MedicamentoBean>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cod);
			rs = pstmt.executeQuery();

			while(rs.next()){
				MedicamentoBean ma = new MedicamentoBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
				
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

	
	public List<MalestarBean> getMalestar() {

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MALESTAR";

		con = getConnection();

		List<MalestarBean> l = new ArrayList<MalestarBean>();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				MalestarBean ma = new MalestarBean(rs.getInt(1), rs.getString(2));
				
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
	public String getMalestar2(String malestar) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT NOMBRE FROM MALESTAR WHERE COD_MALESTAR = ?";
		int cod = Integer.parseInt(malestar);
		con = getConnection();

		String s = "";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cod);
			rs = pstmt.executeQuery();

			while(rs.next()){
				s = rs.getString(1);
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



	return s;
	}

}
