package com.bean;

public class SecretariaBean {
	
	private String Cod_secretaria;
	private String nombre;
	private String turno;
	private String telefono;
	private String direccion;
	private String calle;
	private String distrito;
	private String interior;
	private String correo;
	private String contraseña;
	
	public SecretariaBean() {
			}

	public SecretariaBean(String cod_secretaria, String nombre, String turno,
			String telefono, String direccion, String calle, String distrito,
			String interior, String correo, String contraseña) {
		
		this.Cod_secretaria = cod_secretaria;
		this.nombre = nombre;
		this.turno = turno;
		this.telefono = telefono;
		this.direccion = direccion;
		this.calle = calle;
		this.distrito = distrito;
		this.interior = interior;
		this.correo = correo;
		this.contraseña = contraseña;
	}

	public String getCod_secretaria() {
		return Cod_secretaria;
	}

	public void setCod_secretaria(String cod_secretaria) {
		Cod_secretaria = cod_secretaria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getInterior() {
		return interior;
	}

	public void setInterior(String interior) {
		this.interior = interior;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	
	
	

}
