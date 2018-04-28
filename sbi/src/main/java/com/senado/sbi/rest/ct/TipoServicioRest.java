package com.senado.sbi.rest.ct;

import com.senado.sbi.modelo.ct.TipoServicio;

public interface TipoServicioRest {

	public TipoServicio[] consultaTipoServicios1(Integer iTipoConsulta, String cToken);
	public boolean islResultado();
	public String getMensaje();
	
	
}
