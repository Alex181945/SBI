package com.senado.sbi.rest.seg.login;


/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 13/03/2018
 * Descripcion: Interfaz de Login Rest
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 *
 * Nota: 0 es falso, 1 es verdadero
 * 
 */

public interface LoginRest {
	
	public void validaUsuario(String cUsuario, String cContrasena);
	public Boolean getResult();
	public String getMessage();

}
