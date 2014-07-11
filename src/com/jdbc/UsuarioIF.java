package com.jdbc;

import com.bean.MedicoBean;
import com.bean.PacienteBean;
import com.bean.SecretariaBean;

public interface UsuarioIF {
	
	public boolean validaUsuario(String codigo, String contra);
	public PacienteBean getPaciente(String codigo);
	
	public boolean validaUsuarioDoctor(String codigo, String contra);
	public boolean validaUsuarioEnfermera(String codigo, String contra);
	public boolean validaUsuarioSecretaria(String codigo, String contra);
	
	public boolean validaUsuarioParaRegistroManual(String codigo);
	public SecretariaBean getSecretaria(String codigo);

	
}
