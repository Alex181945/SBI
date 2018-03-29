package com.senado.sbi.rest.seg.login;

import com.senado.sbi.modelo.seg.login.ULogin;

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
	
	public void validaUsuario(ULogin objUsuario);
	public boolean islResultado();
	public String getMensaje();
	public ULogin getUsuario();

}
