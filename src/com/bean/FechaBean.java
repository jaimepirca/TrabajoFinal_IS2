package com.bean;

import java.beans.*;
import java.io.Serializable;
import java.util.*;

public class FechaBean implements Serializable{
	
	private Calendar fechaHoraActual;
	private int formato; //12-24 horas
	private int hora;
	private int minutos;
	private int segundos;
	
	public FechaBean(){
		formato=24;
		fechaHoraActual = new GregorianCalendar();
	}
	
	public int getFormato(){
		return formato;
	}
	
	public void setFormato(int f){
		formato = f;
	}
	
	public String getHora(){
		String hora2="";
		if (formato ==24){
			hora = fechaHoraActual.get(Calendar.HOUR_OF_DAY);
			hora2 = hora2+hora;
			if (hora2.length() == 1){
				hora2 = "0" + hora2;
			}
		}else {
			hora = fechaHoraActual.get(Calendar.HOUR);
			hora2 = hora2+hora;
			if (hora2.length() == 1){
				hora2 = "0" + hora2;
			}
		}
		return hora2;
	}
	
	public String getMinutos(){
		String minutos2="";
		minutos = fechaHoraActual.get(Calendar.MINUTE);
		minutos2 = minutos2+minutos;
		if (minutos2.length() == 1){
			minutos2 = "0" + minutos2;
		}
		return minutos2;
	}
	
	public String getSegundos(){
		String segundos2="";
		segundos = fechaHoraActual.get(Calendar.SECOND);
		segundos2 = segundos2+segundos;
		if (segundos2.length() == 1){
			segundos2 = "0" + segundos2;
		}
		return segundos2;
	}
	
	public String getFecha(){
		
		return (fechaHoraActual.get(Calendar.YEAR) + "-"+ 
				(fechaHoraActual.get(Calendar.MONTH) + 1) + "-" +
				fechaHoraActual.get(Calendar.DAY_OF_MONTH));
	}

}
