package com.jdbc;

import java.util.List;

import com.bean.HistorialConsultaBean;
import com.bean.HistorialConsultaBean2;
import com.bean.HistorialPastillaBean;
import com.bean.HorarioMedico;
import com.bean.PacienteBean;
import com.bean.PacienteEsperaBean;
import com.bean.RegistrosAlumno;
import com.bean.ReporteBean;
import com.bean.SolicitudMedBean;

public interface RegistrosIF {
	
	public void insertaSolMedicamento(SolicitudMedBean s);
	public List<ReporteBean> getSolicitudesPendientes();
	public List<HistorialPastillaBean> getHistorialPastilla();
	public List<HistorialConsultaBean> getHistorialConsulta();
	public boolean buscaPeticionEspera(String cod);
	public void confirmaEntregaMedicamento(String cod, int cod_registro_med);
	public void confirmaAtencionMedica(int cod_cita);
	public List<RegistrosAlumno> getRegistrosAlumno(String codigo);

	public float minutosPasados(int cod_reporte);
	
	public void cancelaMedAuto(int cod_reporte);
	
	public List<ReporteBean> getMedicamentoEnEspera(String Cod_paciente);
	
	public void eliminaEntregaMedicamento(String Cod_paciente, int cod_reg_med);
	
	public List<HistorialPastillaBean> getHistorialPastillaAlumnoEspecifico(
			String Cod_paciente);
	public List<HistorialConsultaBean2> getHistorialConsultaAlumnoEspecifico(
			String Cod_paciente);
	//al hacer cambios en los beans (hay cosas que no son necesarias)
	//otros metodos se vieron afectados, y los elimine, pues ya no se usan.
	
	
	public void registraReceta(String Cod_paciente, String [] receta);
	
	
	//Parte nueva
	public void registraConsulta(String cod_paciente, String cod_secretario,String hora, String dia, int cod_horario);
	public void cambiaEstadoHorario(int cod_horario);
	public List<PacienteEsperaBean> getPacientesEnEspera(String codigo_medico);
	public PacienteBean buscaAlumnoConfirmadoConsulta(int cod_cita);
	
	public List<HorarioMedico> getHorarioMedico(String cod_medico);
	
	public boolean puedePedir(String cod_paciente);
	

}
