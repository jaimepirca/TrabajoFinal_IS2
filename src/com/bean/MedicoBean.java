package com.bean;

import java.io.Serializable;

public class MedicoBean implements Serializable{
	
	private String codigo;
	private String apellido;
	private String nombre;
	private String ruc;
	private String especialista;
	private String cargo;
	private String telefono;
	private String direccion;
	private String calle;
	private String distrito;
	private String interior;
	private String correo;
	private String fecha_nac;
	private String sexo;
	private String contrasena;
	
	public MedicoBean() {}
	
	
	public MedicoBean(String codigo, String apellido, String nombre, String ruc,
			String especialista, String cargo, String telefono,
			String direccion, String calle, String distrito, String interior,
			String correo, String fecha_nac, String sexo, String contrasena) {
		this.codigo = codigo;
		this.apellido = apellido;
		this.nombre = nombre;
		this.ruc = ruc;
		this.especialista = especialista;
		this.cargo = cargo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.calle = calle;
		this.distrito = distrito;
		this.interior = interior;
		this.correo = correo;
		this.fecha_nac = fecha_nac;
		this.sexo = sexo;
		this.contrasena = contrasena;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getEspecialista() {
		return especialista;
	}
	public void setEspecialista(String especialista) {
		this.especialista = especialista;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
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
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
	

}
