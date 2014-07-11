package com.bean;

import java.io.Serializable;

public class MedicamentoBean implements Serializable{
	private int codigo;
	private String nombre;
	private String unidxcaja;
	private String desc;
	private String tipo;
	private int cod_malestar;
	
	public MedicamentoBean(){}
	
	public MedicamentoBean(int codigo, String nombre, String unidxcaja,
			String desc, String tipo, int cod_malestar) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.unidxcaja = unidxcaja;
		this.desc = desc;
		this.tipo = tipo;
		this.cod_malestar = cod_malestar;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidxcaja() {
		return unidxcaja;
	}

	public void setUnidxcaja(String unidxcaja) {
		this.unidxcaja = unidxcaja;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCod_malestar() {
		return cod_malestar;
	}

	public void setCod_malestar(int cod_malestar) {
		this.cod_malestar = cod_malestar;
	}
	
	
	
	
}
