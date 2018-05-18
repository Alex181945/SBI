package com.senado.sbi.rest.ct;

import com.senado.sbi.modelo.ct.EstatusTicketM;

public interface EstatusTicketRest {
	
	public EstatusTicketM[] consultaEstatusTicketes(Integer iTipoConsulta, String cToken);
	public EstatusTicketM consultaEstatusTicket(Integer iIDEstado, String cToken);
	public void actualizaEstatusTicket(EstatusTicketM objEstatusTicket, String cToken);
	public void insertaEstatusTicket(EstatusTicketM objEstatusTicket, String cToken);
	public void borraEstatusTicket(Integer iIDEstado, String cUsuario, String cToken);

	public boolean islResultado();
	public String getMensaje();

}
