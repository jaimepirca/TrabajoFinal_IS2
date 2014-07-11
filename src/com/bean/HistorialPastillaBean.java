package com.bean;

import java.io.Serializable;

public class HistorialPastillaBean implements Serializable{
	
	//EL CODIGO DEL PACIENTE Y EL CODIGO DE MEDICAMENTO = A SUS NOMBRES, SE VA MOSTRAR SU NOMBRES
	
	private int cod_reg_med;
	private String cod_medic;
	private int cantidad;
	private String medico;
	private String apMedico;
	private String fecha;
	private String estado;
	
	public HistorialPastillaBean() {
		
	}
	
	




	public HistorialPastillaBean(int cod_reg_med,
			String cod_medic, int cantidad, String medico, String apMedico,
			String fecha, String estado) {
		
		this.cod_reg_med = cod_reg_med;
		
		this.cod_medic = cod_medic;
		this.cantidad = cantidad;
		this.medico = medico;
		this.apMedico = apMedico;
		this.fecha = fecha;
		this.estado = estado;
	}












	public int getCod_reg_med() {
		return cod_reg_med;
	}

	public void setCod_reg_med(int cod_reg_med) {
		this.cod_reg_med = cod_reg_med;
	}

	
	public String getCod_medic() {
		return cod_medic;
	}

	public void setCod_medic(String cod_medic) {
		this.cod_medic = cod_medic;
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




	public String getEstado() {
		return estado;
	}




	public void setEstado(String estado) {
		this.estado = estado;
	}






	public String getMedico() {
		return medico;
	}






	public void setMedico(String medico) {
		this.medico = medico;
	}






	public String getApMedico() {
		return apMedico;
	}






	public void setApMedico(String apMedico) {
		this.apMedico = apMedico;
	}




    

	
	
	
	

}
