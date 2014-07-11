package com.bean;

import java.io.Serializable;

public class HorarioMedico implements Serializable{
	
	private int cod_horario;
	private String medico;
	private String dia;
	private String hora;
	private String estado;
	
	public HorarioMedico(int cod_horario, String medico, String dia,
			String hora, String estado) {
		super();
		this.cod_horario = cod_horario;
		this.medico = medico;
		this.dia = dia;
		this.hora = hora;
		this.estado = estado;
	}
	public int getCod_horario() {
		return cod_horario;
	}
	public void setCod_horario(int cod_horario) {
		this.cod_horario = cod_horario;
	}
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
