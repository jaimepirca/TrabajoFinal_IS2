package com.jdbc;

import java.util.List;

import com.bean.MedicoBean;

public interface DoctorIF {
	
	public List<MedicoBean> getAllDoctor();
	
	public MedicoBean getDoctor(String codigo);
	
}
