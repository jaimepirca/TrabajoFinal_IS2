package com.bean;

import java.io.Serializable;

public class PacienteEsperaBean implements Serializable{
	
	private int cod_cita;
	private int cod_horario;
	private String codigo;
	private String nombre;
	private String apellido;
	private String fecha_pedida;
	
	public PacienteEsperaBean(){};
	
	public PacienteEsperaBean(int cod_cita,int cod_horario,String codigo, String nombre, String apellido,
			String fecha_pedida) {
		this.cod_cita = cod_cita;
		this.cod_horario = cod_horario;
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_pedida = fecha_pedida;
	}

	
	
	public int getCod_horario() {
		return cod_horario;
	}

	public void setCod_horario(int cod_horario) {
		this.cod_horario = cod_horario;
	}

	public int getCod_cita() {
		return cod_cita;
	}

	public void setCod_cita(int cod_cita) {
		this.cod_cita = cod_cita;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getFecha_pedida() {
		return fecha_pedida;
	}

	public void setFecha_pedida(String fecha_pedida) {
		this.fecha_pedida = fecha_pedida;
	}
	
	

}
