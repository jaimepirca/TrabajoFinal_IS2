package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.MedicoBean;
import com.bean.PacienteBean;
import com.bean.SecretariaBean;

public class UsuarioDAO implements UsuarioIF {

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
	
	
	
	public boolean validaUsuario(String codigo, String contra) {
		
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COD_PACIENTE, CONTRASENA FROM PACIENTE WHERE COD_PACIENTE=? AND CONTRASENA=?";
		
		boolean  esValido = false;
		
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, codigo);
			pstmt.setString(2, contra);
			rs = pstmt.executeQuery();

			if ( rs.next() ) {
				esValido = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			rs.close();
			pstmt.close();
			con.close();
			} catch ( Exception e) {} 
		}

		return esValido;
		
	}



	@SuppressWarnings("null")

	public PacienteBean getPaciente(String codigo) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PACIENTE WHERE COD_PACIENTE=?";
		PacienteBean p = new PacienteBean();
		
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, codigo);
			rs = pstmt.executeQuery();

			if ( rs.next() ) {
				
				p.setCodigo(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setApellido(rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			rs.close();
			pstmt.close();
			con.close();
			} catch ( Exception e) {} 
		}

		
		
		return p;
	}



	@Override
	public boolean validaUsuarioDoctor(String codigo, String contra) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COD_DOCTOR, CONTRASENA FROM EMPLEADO_MEDICO WHERE CARGO=? AND COD_DOCTOR=? AND CONTRASENA=?";
		
		boolean  esValido = false;
		
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Doctor");
			pstmt.setString(2, codigo);
			pstmt.setString(3, contra);
			rs = pstmt.executeQuery();

			if ( rs.next() ) {
				esValido = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			rs.close();
			pstmt.close();
			con.close();
			} catch ( Exception e) {} 
		}

		return esValido;
	}



	@Override
	public boolean validaUsuarioEnfermera(String codigo, String contra) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COD_DOCTOR, CONTRASENA FROM EMPLEADO_MEDICO WHERE CARGO=? AND COD_DOCTOR=? AND CONTRASENA=?";
		
		boolean  esValido = false;
		
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Enfermera");
			pstmt.setString(2, codigo);
			pstmt.setString(3, contra);
			rs = pstmt.executeQuery();

			if ( rs.next() ) {
				esValido = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			rs.close();
			pstmt.close();
			con.close();
			} catch ( Exception e) {} 
		}

		return esValido;
	}

	
	@Override
	public boolean validaUsuarioSecretaria(String codigo, String contra) {

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COD_SECRETARIO, CONTRASENA FROM SECRETARIO WHERE COD_SECRETARIO=? AND CONTRASENA=?";
		
		boolean  esValido = false;
		
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, codigo);
			pstmt.setString(2, contra);
			rs = pstmt.executeQuery();

			if ( rs.next() ) {
				esValido = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			rs.close();
			pstmt.close();
			con.close();
			} catch ( Exception e) {} 
		}

		return esValido;
	
	}

	@Override
	public boolean validaUsuarioParaRegistroManual(String codigo) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COD_PACIENTE FROM PACIENTE WHERE COD_PACIENTE=?";
		
		boolean  esValido = false;
		
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, codigo);
			
			rs = pstmt.executeQuery();

			if ( rs.next() ) {
				esValido = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			rs.close();
			pstmt.close();
			con.close();
			} catch ( Exception e) {} 
		}

		return esValido;
	}

	@Override
	public SecretariaBean getSecretaria(String codigo) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM SECRETARIO WHERE COD_SECRETARIO = ?";
		int cod = Integer.parseInt(codigo);
		con = getConnection();

		SecretariaBean s = new SecretariaBean();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,cod);
			rs = pstmt.executeQuery();

			while(rs.next()){
				s = new SecretariaBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				s.setCod_secretaria(rs.getString(1));
				s.setNombre(rs.getString(2));
				s.setTurno(rs.getString(3));
				s.setTelefono(rs.getString(4));			
				s.setDireccion(rs.getString(5));
				s.setCalle(rs.getString(6));
				s.setDistrito(rs.getString(7));
				s.setInterior(rs.getString(8));
				s.setCorreo(rs.getString(9));
				s.setContraseña(rs.getString(10));
				
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
