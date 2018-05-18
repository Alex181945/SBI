package com.senado.sbi.rest.ct;

import com.senado.sbi.modelo.ct.EstatusTicketM;

public interface EstatusTicketRest {
	
	public EstatusTicketM[] consultaEdificios(Integer iTipoConsulta, String cToken);
	public EstatusTicketM consultaEdificio(Integer iIDEdificio, String cToken);
	public void actualizaEdificio(EstatusTicketM objEdificio, String cToken);
	public void insertaEdificio(EstatusTicketM objEdificio, String cToken);
	public void borraEdificio(Integer iIDEdificio, String cUsuario, String cToken);

	public boolean islResultado();
	public String getMensaje();

}
