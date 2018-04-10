package com.senado.sbi.rest.op.ticket;

import com.senado.sbi.modelo.op.ticket.TicketM;

public interface TicketRest {

	public void insertaTicket(TicketM objTicket, String cToken);
	public boolean islResultado();
	public String getMensaje();
	
}
