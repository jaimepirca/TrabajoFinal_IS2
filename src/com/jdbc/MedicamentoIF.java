package com.jdbc;

import java.util.List;

import com.bean.MalestarBean;
import com.bean.MedicamentoBean;

public interface MedicamentoIF {
	public List<MedicamentoBean> filtraMedicamento(String malestar);
	
	public List<MalestarBean> getMalestar();
	
	public String getMalestar2(String malestar);

}
