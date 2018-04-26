package com.senado.sbi.rest.ct;

import com.senado.sbi.modelo.ct.SrvSolicitado;

public interface SrvSolicitadoRest {

	public SrvSolicitado[] consultaSrvSolicitados(Integer iTipoConsulta, String cToken);
	public boolean islResultado();
	public String getMensaje();

}
