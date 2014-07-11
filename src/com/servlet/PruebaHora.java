package com.servlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PruebaHora {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PruebaHora ph = new PruebaHora();
		String horaactual = ph.getHoraActual();
		System.out.println(horaactual);
		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("hh:mm:ss");
		String strFecha = ph.getHoraActual();
		Date hora = null;
		try {

			hora = formatoDelTexto.parse(strFecha);

		} catch (ParseException ex) {

		ex.printStackTrace();

		}
		
		
		
	}
	
	public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }

}
