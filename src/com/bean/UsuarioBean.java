package com.bean;

import java.io.Serializable;

public class UsuarioBean implements Serializable{
	
	private String codigo;
	private String contrase�a;
	private String tipo;
	
	public UsuarioBean(){}
	
	public UsuarioBean(String codigo, String contrase�a, String tipo) {

		this.codigo = codigo;
		this.contrase�a = contrase�a;
		this.tipo = tipo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
