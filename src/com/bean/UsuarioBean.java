package com.bean;

import java.io.Serializable;

public class UsuarioBean implements Serializable{
	
	private String codigo;
	private String contraseña;
	private String tipo;
	
	public UsuarioBean(){}
	
	public UsuarioBean(String codigo, String contraseña, String tipo) {

		this.codigo = codigo;
		this.contraseña = contraseña;
		this.tipo = tipo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
