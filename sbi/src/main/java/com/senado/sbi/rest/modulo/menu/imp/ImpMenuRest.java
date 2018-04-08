package com.senado.sbi.rest.modulo.menu.imp;

import org.springframework.stereotype.Component;

import com.senado.sbi.modelo.modulo.Menu;
import com.senado.sbi.rest.modulo.menu.MenuRest;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 07/04/2018
 * Descripcion: Implementacion de la interfaz MenuRest
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 *
 * Nota: 0 es falso, 1 es verdadero
 * 
 */

@Component
public class ImpMenuRest implements MenuRest {

	@Override
	public Menu cargaMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean islResultado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMensaje() {
		// TODO Auto-generated method stub
		return null;
	}

}
