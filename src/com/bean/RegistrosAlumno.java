package com.bean;

import java.io.Serializable;

public class RegistrosAlumno implements Serializable{
	
	private String medicamento;
	private int cantidad;
	private String hora;
	private String fecha;
	private String estado;
	
	public RegistrosAlumno(){}
	public RegistrosAlumno(String medicamento, int cantidad, String hora,
			String fecha, String estado) {
		super();
		this.medicamento = medicamento;
		this.cantidad = cantidad;
		this.hora = hora;
		this.fecha = fecha;
		this.estado = estado;
	}
	
	public String getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	

}
