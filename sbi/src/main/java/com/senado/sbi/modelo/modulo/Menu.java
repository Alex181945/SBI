package com.senado.sbi.modelo.modulo;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 07/04/2018
 * Descripcion: Clase para la carga del menu
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 *
 * Nota: 0 es falso, 1 es verdadero
 * 
 */

public class Menu {

	private Integer iIDModulo;
	private String  cModulo;
	private Integer iPartida;
	private String  cPrograma;
	private String  cRuta;
	private Integer lActivo;
	
	public Integer getiIDModulo() {
		return iIDModulo;
	}
	public void setiIDModulo(Integer iIDModulo) {
		this.iIDModulo = iIDModulo;
	}
	public String getcModulo() {
		return cModulo;
	}
	public void setcModulo(String cModulo) {
		this.cModulo = cModulo;
	}
	public Integer getiPartida() {
		return iPartida;
	}
	public void setiPartida(Integer iPartida) {
		this.iPartida = iPartida;
	}
	public String getcPrograma() {
		return cPrograma;
	}
	public void setcPrograma(String cPrograma) {
		this.cPrograma = cPrograma;
	}
	public String getcRuta() {
		return cRuta;
	}
	public void setcRuta(String cRuta) {
		this.cRuta = cRuta;
	}
	public Integer getlActivo() {
		return lActivo;
	}
	public void setlActivo(Integer lActivo) {
		this.lActivo = lActivo;
	}
	
	@Override
	public String toString() {
		return "Menu [iIDModulo=" + iIDModulo + ", cModulo=" + cModulo + ", iPartida=" + iPartida + ", cPrograma="
				+ cPrograma + ", cRuta=" + cRuta + ", lActivo=" + lActivo + "]";
	}
	
	public String toJson() {
		return "{"
				+ "iIDModulo:" + iIDModulo + ","
				+ "cModulo:"   + cModulo   + ","
				+ "iPartida:"  + iPartida  + ","
				+ "cRuta:"     + cRuta     + ","
				+ "lActivo:"   + lActivo     
				+ "}";
	} 
}
