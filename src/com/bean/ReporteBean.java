package com.bean;

import java.io.Serializable;

public class ReporteBean implements Serializable {

	private int cod_reporte;
	private String nombrePaciente;
	private String nombrePastilla;
	private String cantidad;
	private String hora;
	
	
	public ReporteBean(){}
	
	public ReporteBean(int cod_reporte, String nombrePaciente, String nombrePastilla,
			String cantidad, String hora) {
		this.cod_reporte = cod_reporte;
		this.nombrePaciente = nombrePaciente;
		this.nombrePastilla = nombrePastilla;
		this.cantidad = cantidad;
		this.hora = hora;
	}


	public String getNombrePaciente() {
		return nombrePaciente;
	}


	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}


	public String getNombrePastilla() {
		return nombrePastilla;
	}


	public void setNombrePastilla(String nombrePastilla) {
		this.nombrePastilla = nombrePastilla;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getCod_reporte() {
		return cod_reporte;
	}

	public void setCod_reporte(int cod_reporte) {
		this.cod_reporte = cod_reporte;
	}
	
	
	
	
}
