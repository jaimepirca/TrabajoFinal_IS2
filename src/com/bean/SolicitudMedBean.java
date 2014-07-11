package com.bean;

import java.io.Serializable;

public class SolicitudMedBean implements Serializable{
	
	private int cod_registro;
	private String cod_secretaria;
	private String cod_paciente;
	private int cod_medicamento;
	private int cantidad;
	private String codigo_medico;
	private String hora;
	private String fecha;
	private String estado;
	
	public SolicitudMedBean(){}
	
	public SolicitudMedBean(int cod_registro, String cod_secretaria,
			String cod_paciente, int cod_medicamento, int cantidad,
			String codigo_medico, String hora, String fecha, String estado) {
		this.cod_registro = cod_registro;
		this.cod_secretaria = cod_secretaria;
		this.cod_paciente = cod_paciente;
		this.cod_medicamento = cod_medicamento;
		this.cantidad = cantidad;
		this.codigo_medico = codigo_medico;
		this.hora = hora;
		this.fecha = fecha;
		this.estado = estado;
	}

	public int getCod_registro() {
		return cod_registro;
	}

	public void setCod_registro(int cod_registro) {
		this.cod_registro = cod_registro;
	}

	public String getCod_secretaria() {
		return cod_secretaria;
	}

	public void setCod_secretaria(String cod_secretaria) {
		this.cod_secretaria = cod_secretaria;
	}

	public String getCod_paciente() {
		return cod_paciente;
	}

	public void setCod_paciente(String cod_paciente) {
		this.cod_paciente = cod_paciente;
	}

	public int getCod_medicamento() {
		return cod_medicamento;
	}

	public void setCod_medicamento(int cod_medicamento) {
		this.cod_medicamento = cod_medicamento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getCodigo_medico() {
		return codigo_medico;
	}

	public void setCodigo_medico(String codigo_medico) {
		this.codigo_medico = codigo_medico;
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
