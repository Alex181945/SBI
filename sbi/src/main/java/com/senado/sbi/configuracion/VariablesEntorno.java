package com.senado.sbi.configuracion;

public class VariablesEntorno {
	
	private static final String URLWSD = "http://localhost:3000/";
	private static final String URLWSP = "https://restmysql.herokuapp.com/";
	
	public static String getURLWSD() {
		return URLWSD;
	}
	public static String getURLWSP() {
		return URLWSP;
	}
	
}
