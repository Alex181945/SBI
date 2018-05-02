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
 * Nota: 0 esx falso, 1 es verdadero
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
	private static final String LOGIN             = "index";
	private static final String MENU              = "menu/menu";
	private static final String TICKET_INCIDENCIA = "ticket/incidencia";
	private static final String TICKET_ASIGNACION = "ticket/asigancionTecnico";
	private static final String BI_CONSULTAR      = "bieninformatico/Consultar";
	private static final String BI_EDITAR         = "bieninformatico/Editar";
	private static final String BI_INSERTAR       = "bieninformatico/Nuevo";
	private static final String BI_DESHABILITAR   = "bieninformatico/Deshabilitar";
	private static final String CT_TODOS               = "catalogo/catalogos";
	private static final String CT_EDIFICIO_CONSULTA   = "catalogo/edificio/consulta";
	private static final String CT_EDIFICIO_FORMULARIO = "catalogo/edificio/formulario";
	/********************************* Fin ***********************************/
	
	/*************************************************************************/
	/***                          Rutas del sistema                        ***/
	/*************************************************************************/
	public static final String RAIZ        = "/";
	public static final String LOGIN_R     = "/login";
	public static final String VALIDAUSU_R = "/validausuario";
	public static final String LOGOUT_R    = "/logout";
	public static final String TICKET_R    = "/ticket";
	public static final String TICKET_ASIGNACION_R      = "/ticket/asignacion";
	public static final String TICKET_INSERTA_R         = "/ticket/inserta";
	public static final String BI_R                     = "/bienesinformaticos";
	public static final String CT_TODOS_R               = "/config/catalogos";
	public static final String CT_EDIFICIO_CONSULTA_R   = "/config/catalogos/edificio/consulta";
	public static final String CT_EDIFICIO_CONSULTA_UNO_R   = "/config/catalogos/edificio/consulta/uno";
	public static final String CT_EDIFICIO_FORMULARIO_R     = "/config/catalogos/edificio/form";
	public static final String CT_EDIFICIO_INSERTA_R        = "/config/catalogos/edificio/inserta";
	public static final String CT_EDIFICIO_EDITA_R          = "/config/catalogos/edificio/actualiza";
	public static final String CT_EDIFICIO_BORRA_R          = "/config/catalogos/edificio/elimina";
	/********************************* Fin ***********************************/
	
	/*************************************************************************/
	/***                         Redireccionamientos                       ***/
	/*************************************************************************/
	private static final String REDIRECT_LOGIN             = "redirect:/login";
	private static final String REDIRECT_MENU              = "redirect:/menu/inicio";
	private static final String REDIRECT_MODULO            = "redirect:/carga/modulo";
	private static final String REDIRECT_MENUPRINCIPAL     = "redirect:/menu/inicio";
	private static final String REDIRECT_TICKET            = "redirect:/ticket";
	private static final String REDIRECT_TICKET_ASIGNACION = "redirect:/ticket/asignacion";
	private static final String REDIRECT_BI                = "redirect:/bienesinformaticos";
	private static final String REDIRECT_CT                = "redirect:/config/catalogos";
	private static final String REDIRECT_CT_EDIFICIO       = "redirect:/config/catalogos/edificio/consulta";
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
	public static String getMenu() {
		return MENU;
	}
	public static String getTicketIncidencia() {
		return TICKET_INCIDENCIA;
	}
	public static String getTicketAsignacion() {
		return TICKET_ASIGNACION;
	}
	public static String getBiConsultar() {
		return BI_CONSULTAR;
	}
	public static String getBiEditar() {
		return BI_EDITAR;
	}
	public static String getBiInsertar() {
		return BI_INSERTAR;
	}
	public static String getBiDeshabilitar() {
		return BI_DESHABILITAR;
	}
	public static String getRaiz() {
		return RAIZ;
	}
	public static String getLoginR() {
		return LOGIN_R;
	}
	public static String getValidausuR() {
		return VALIDAUSU_R;
	}
	public static String getLogoutR() {
		return LOGOUT_R;
	}
	public static String getTicketR() {
		return TICKET_R;
	}
	public static String getTicketAsignacionR() {
		return TICKET_ASIGNACION_R;
	}
	public static String getTicketInsertaR() {
		return TICKET_INSERTA_R;
	}
	public static String getBiR() {
		return BI_R;
	}
	public static String getRedirectLogin() {
		return REDIRECT_LOGIN;
	}
	public static String getRedirectMenu() {
		return REDIRECT_MENU;
	}
	public static String getRedirectModulo() {
		return REDIRECT_MODULO;
	}
	public static String getRedirectMenuprincipal() {
		return REDIRECT_MENUPRINCIPAL;
	}
	public static String getRedirectTicket() {
		return REDIRECT_TICKET;
	}
	public static String getRedirectTicketAsignacion() {
		return REDIRECT_TICKET_ASIGNACION;
	}
	public static String getRedirectBi() {
		return REDIRECT_BI;
	}
	public static String getCtEdificioConsulta() {
		return CT_EDIFICIO_CONSULTA;
	}
	public static String getCtEdificioConsultaR() {
		return CT_EDIFICIO_CONSULTA_R;
	}
	public static String getRedirectCtEdificio() {
		return REDIRECT_CT_EDIFICIO;
	}
	public static String getCtTodos() {
		return CT_TODOS;
	}
	public static String getCtTodosR() {
		return CT_TODOS_R;
	}
	public static String getRedirectCt() {
		return REDIRECT_CT;
	}
	public static String getCtEdificioFormulario() {
		return CT_EDIFICIO_FORMULARIO;
	}
	public static String getCtEdificioFormularioR() {
		return CT_EDIFICIO_FORMULARIO_R;
	}
	public static String getCtEdificioInsertaR() {
		return CT_EDIFICIO_INSERTA_R;
	}
	public static String getCtEdificioEditaR() {
		return CT_EDIFICIO_EDITA_R;
	}
	public static String getCtEdificioBorraR() {
		return CT_EDIFICIO_BORRA_R;
	}	

}
