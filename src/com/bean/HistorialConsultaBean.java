package com.bean;

import java.io.Serializable;

public class HistorialConsultaBean implements Serializable{
	
	private int codigo;
	private String nombre_medico;
	private String nombre_paciente;
	private String nombre_secretaria;
	private String fecha_registro;
	private String fecha_solicitada;
	
	public HistorialConsultaBean(){}
	
	public HistorialConsultaBean(int codigo, String nombre_medico,
			String nombre_paciente, String nombre_secretaria,
			String fecha_registro, String fecha_solicitada) {

		this.codigo = codigo;
		this.nombre_medico = nombre_medico;
		this.nombre_paciente = nombre_paciente;
		this.nombre_secretaria = nombre_secretaria;
		this.fecha_registro = fecha_registro;
		this.fecha_solicitada = fecha_solicitada;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre_medico() {
		return nombre_medico;
	}

	public void setNombre_medico(String nombre_medico) {
		this.nombre_medico = nombre_medico;
	}

	public String getNombre_paciente() {
		return nombre_paciente;
	}

	public void setNombre_paciente(String nombre_paciente) {
		this.nombre_paciente = nombre_paciente;
	}

	public String getNombre_secretaria() {
		return nombre_secretaria;
	}

	public void setNombre_secretaria(String nombre_secretaria) {
		this.nombre_secretaria = nombre_secretaria;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getFecha_solicitada() {
		return fecha_solicitada;
	}

	public void setFecha_solicitada(String fecha_solicitada) {
		this.fecha_solicitada = fecha_solicitada;
	}
	
	
	

}
