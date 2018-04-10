package com.senado.sbi.modelo.datos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 29/03/2018
 * Descripcion: Clase para la obtencion del menu principal
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 *
 * Nota: 0 es falso, 1 es verdadero
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgramasPerfil {

	private Integer iTipoConsulta;
	private Integer iIDPerfil;
	
	public Integer getiTipoConsulta() {
		return iTipoConsulta;
	}
	public void setiTipoConsulta(Integer iTipoConsulta) {
		this.iTipoConsulta = iTipoConsulta;
	}
	public Integer getiIDPerfil() {
		return iIDPerfil;
	}
	public void setiIDPerfil(Integer iIDPerfil) {
		this.iIDPerfil = iIDPerfil;
	}
	
}
