package com.senado.sbi.rest.ct;

import com.senado.sbi.modelo.ct.EdificioM;

public interface EdificioRest {

	
	public EdificioM[] consultaEdificios(Integer iTipoConsulta, String cToken);
	public EdificioM consultaEdificio(Integer iIDEdificio, String cToken);
	public void actualizaEdificio(EdificioM objEdificio, String cToken);
	public void insertaEdificio(EdificioM objEdificio, String cToken);
	public void borraEdificio(Integer iIDEdificio, String cUsuario, String cToken);

	public boolean islResultado();
	public String getMensaje();
	
}
