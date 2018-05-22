package com.senado.sbi.configuracion;

public class VariablesEntorno {
	
	private static final String  URLWSD = "http://localhost:3000/";
	private static final String  URLWSP = "https://restmysql.herokuapp.com/";
	private static final String  TOKEN_PREFIX = "Bearer ";
    private static final String  HEADER_STRING = "Authorization";
    private static final String  TIPOASIGNACIONTECNICO = "1";
    private static final Integer MEDIOSOLICITUD = 1;
    private static final Integer MEDIOSOLICITUDAUTOSERVICIO = 2;
	
	public static String getUrlwsd() {
		return URLWSD;
	}
	public static String getUrlwsp() {
		return URLWSP;
	}
	public static String getTokenPrefix() {
		return TOKEN_PREFIX;
	}
	public static String getHeaderString() {
		return HEADER_STRING;
	}
	public static String getTipoasignaciontecnico() {
		return TIPOASIGNACIONTECNICO;
	}
	public static Integer getMediosolicitud() {
		return MEDIOSOLICITUD;
	}
	public static Integer getMediosolicitudautoservicio() {
		return MEDIOSOLICITUDAUTOSERVICIO;
	}	
	
}
