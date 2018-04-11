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
	private static final String bienesInformaticos = "bieninformatico/menu";
	private static final String consultaSABI = "consultaSabi/sabi";
	private static final String editarSABI = "editarSabi/SABI";
	private static final String deshabilitaSABI = "deshabilitarSABI/deshsa";
	private static final String nuevoSABI = "insertaSABI/nuevosa";
	/*Explica en donde esta el archivo que se va a ver*/
	/********************************* Fin ***********************************/
	
	/*************************************************************************/
	/***                         Redireccionamientos                       ***/
	/*************************************************************************/
	private static final String REDIRECT_LOGIN = "redirect:/login";
	private static final String REDIRECT_MENUPRINCIPAL = "redirect:/menu/inicio";
	private static final String REDIRECT_SABI = "redirect:/bienesInformaticos"; /*carpeta creada en controller*/
	private static final String REDIRECT_CONSULTA = "redirect:/consultaSABI"; /*carpeta creada en controller*/
	private static final String REDIRECT_EDITAR = "redirect:/editarSABI"; /*carpeta creada en controller*/
	private static final String REDIRECT_DESHABILITA = "redirect:/deshabilitarSABI"; /*carpeta creada en controller*/
	private static final String REDIRECT_NUEVO = "redirect:/insertarSABI"; /*carpeta creada en controller*/
	private static final String REDIRECT_MODULO = "redirect:/carga/modulo";
	private static final String REDIRECT_TICKET = "redirect:/ticket";

	/********************************* Fin ***********************************/
	
	public static String getRedirectLogin() {
		return REDIRECT_LOGIN;
	}
	public static String getRedirectTicket() {
		return REDIRECT_TICKET;
	}
	public static String getDefaultLayout() {
		return DEFAULT_LAYOUT;
	}
	public static String getDefaultViewAttributeName() {
		return DEFAULT_VIEW_ATTRIBUTE_NAME;
	}
	public static String getLogin() {
		return LOGIN;
	}
	public static String getRedirectConsulta() { /*Redirecciona lo de arriba*/
		return REDIRECT_CONSULTA;
	}
	public static String getRedirectEditar() { /*Redirecciona lo de arriba*/
		return REDIRECT_EDITAR;
	}
	public static String getRedirectSabi() { /*Redirecciona lo de arriba*/
		return REDIRECT_SABI;
	}
	public static String getRedirectDeshabilita() { /*Redirecciona lo de arriba*/
		return REDIRECT_DESHABILITA;
	}
	public static String getRedirectNuevo() { /*Redirecciona lo de arriba*/
		return REDIRECT_NUEVO;
	}
	public static String getMenu() {
		return MENU;
	}
	public static String getTicket() {
		return TICKET;
	}
	public static String getRedirectMenuprincipal() {
		return REDIRECT_MENUPRINCIPAL;
	}
	public static String getRedirectModulo() {
		return REDIRECT_MODULO;
	}
	public static String getbieninformatico() {
		return bienesInformaticos;
	}
	public static String getconsultaSabi() {
		return consultaSABI;
	}
	public static String geteditarSabi() {
		return editarSABI;
	}
	public static String getdeshabilitaSabi() {
		return deshabilitaSABI;
	}
	public static String getinsertarSabi() {
		return nuevoSABI;
	}

}
