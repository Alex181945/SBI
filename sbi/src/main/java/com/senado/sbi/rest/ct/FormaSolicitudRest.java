package com.senado.sbi.rest.ct;

import com.senado.sbi.modelo.ct.FormaSolicitud;

public interface FormaSolicitudRest {
	
	public FormaSolicitud[] consultaFormaSolicitudes(Integer iTipoConsulta, String cToken);
	public boolean islResultado();
	public String getMensaje();

}
