package com.bean;

public class AlmacenBean {

	private int cod_Stock;
	private int cod_medicamento;
	private int cantidad;
	
	public AlmacenBean(){}
	
	public AlmacenBean(int cod_Stock, int cod_medicamento, int cantidad) {
		
		this.cod_Stock = cod_Stock;
		this.cod_medicamento = cod_medicamento;
		this.cantidad = cantidad;
	}



	public int getCod_Stock() {
		return cod_Stock;
	}



	public void setCod_Stock(int cod_Stock) {
		this.cod_Stock = cod_Stock;
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
	
}
