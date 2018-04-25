package com.senado.sbi.configuracion;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 28/03/2018
 * Descripcion: Contiene las vistas de la aplicacion
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 *
 * Nota: 0 es falso, 1 es verdadero
 * 
 */

public class Vistas {
	
	
	/*************************************************************************/
	/***                          Rutas de la plantilla                    ***/
	/*************************************************************************/
	private static final String DEFAULT_LAYOUT = "plantilla/base";
	private static final String DEFAULT_VIEW_ATTRIBUTE_NAME = "view";
	/********************************* Fin ***********************************/
	
	/*************************************************************************/
	/***                          Vistas del sistema                       ***/
	/*************************************************************************/
	private static final String LOGIN = "index";
	private static final String TICKET = "ticket/incidencia";
	private static final String MENU = "menu/menu";
	private static final String CONSULTAR = "bieninformatico/Consultar";
	private static final String EDITAR = "bieninformatico/Editar";
	private static final String INSERTAR = "bieninformatico/Nuevo";
	private static final String DESHABILITAR = "bieninformatico/Deshabilitar";
	/********************************* Fin ***********************************/
	
	/*************************************************************************/
	/***                         Redireccionamientos                       ***/
	/*************************************************************************/
	private static final String REDIRECT_LOGIN = "redirect:/login";
	private static final String REDIRECT_MENUPRINCIPAL = "redirect:/menu/inicio";
	private static final String REDIRECT_MODULO = "redirect:/carga/modulo";
	private static final String REDIRECT_TICKET = "redirect:/ticket";
	private static final String REDIRECT_BIENESI = "redirect:/bienesinformaticos";
	/********************************* Fin ***********************************/
	
	public static String getDefaultLayout() {
		return DEFAULT_LAYOUT;
	}
	public static String getDefaultViewAttributeName() {
		return DEFAULT_VIEW_ATTRIBUTE_NAME;
	}
	public static String getLogin() {
		return LOGIN;
	}
	public static String getTicket() {
		return TICKET;
	}
	public static String getMenu() {
		return MENU;
	}
	public static String getRedirectConsulta() {
		return CONSULTAR;
	}
	public static String getRedirectLogin() {
		return REDIRECT_LOGIN;
	}
	public static String getRedirectMenuprincipal() {
		return REDIRECT_MENUPRINCIPAL;
	}
	public static String getRedirectModulo() {
		return REDIRECT_MODULO;
	}
	public static String getRedirectTicket() {
		return REDIRECT_TICKET;
	}
	public static String getRedirectConsultar() {
		return REDIRECT_BIENESI;
	}
	
	public static String getRedirectEditar() {	
		return EDITAR;
	}
	public static String getRedirectInserta() {
		return INSERTAR;
	}
	public static String getRedirectDeshabilitar() {
		return DESHABILITAR;
	}

}
