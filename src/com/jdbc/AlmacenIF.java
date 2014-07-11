package com.jdbc;

import java.util.List;

import com.bean.Salida_AlBean;

public interface AlmacenIF {
	
	
	
	public void pedirMedicamento(int cod_medicamento, int cantidad, String cod_paciente, String fecha, String hora);
	
	public List<Salida_AlBean> muestraSalida();
	
	public boolean validaMedicamento(int cod_medicamento, int cantidad);
	
	public void sumaMedicamentoCanceladoAlmacen (String nombreMed, int cantidad);
}
