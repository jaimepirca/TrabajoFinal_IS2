package com.bean;

import java.io.Serializable;

public class Salida_AlBean implements Serializable {
	
	private int cod_salida;
	private int cod_medicamento;
	private String cod_paciente;
	private int cantidad;
	private String fecha;
	
	public Salida_AlBean(){}
	
	public Salida_AlBean(int cod_salida,int cod_medicamento, String cod_paciente, int cantidad,
			String fecha) {
		
		this.cod_salida = cod_salida;
		this.cod_medicamento = cod_medicamento;
		this.cod_paciente = cod_paciente;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public int getCod_salida() {
		return cod_salida;
	}

	public void setCod_salida(int cod_salida) {
		this.cod_salida = cod_salida;
	}

	public String getCod_paciente() {
		return cod_paciente;
	}

	public void setCod_paciente(String cod_paciente) {
		this.cod_paciente = cod_paciente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCod_medicamento() {
		return cod_medicamento;
	}

	public void setCod_medicamento(int cod_medicamento) {
		this.cod_medicamento = cod_medicamento;
	}
	
	
	
	
	
	

}
