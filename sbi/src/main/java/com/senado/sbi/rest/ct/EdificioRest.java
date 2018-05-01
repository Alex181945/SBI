package com.senado.sbi.rest.ct;

import com.senado.sbi.modelo.ct.EdificioM;

public interface EdificioRest {

	public EdificioM[] consultaEdificios(Integer iTipoConsulta, String cToken);
	public boolean islResultado();
	public String getMensaje();
	
}
