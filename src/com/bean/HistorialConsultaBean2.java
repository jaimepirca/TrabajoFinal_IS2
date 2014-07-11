package com.bean;

import java.io.Serializable;

public class HistorialConsultaBean2 implements Serializable{
	
	
	private String nombre;
	private String apellido;
	private String fecha;
	private String fecha2;
	private String estado;
	
	public HistorialConsultaBean2(){}

	public HistorialConsultaBean2(String nombre, String apellido, String fecha,
			String fecha2, String estado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha = fecha;
		this.fecha2 = fecha2;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFecha2() {
		return fecha2;
	}

	public void setFecha2(String fecha2) {
		this.fecha2 = fecha2;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

}
