package com.senado.sbi.rest.ct;

import com.senado.sbi.modelo.ct.Criticidad;

public interface CriticidadRest {

	public boolean islResultado();
	public String getMensaje();
	public Criticidad[] consultaCriticidad(Integer iTipoConsulta, String cToken);

}
