package com.senado.sbi.rest.ct;

import com.senado.sbi.modelo.ct.Edificio;

public interface EdificioRest {

	public Edificio[] consultaEdificios(Integer iTipoConsulta, String cToken);
	public boolean islResultado();
	public String getMensaje();
	
}
