package com.senado.sbi.configuracion;

public class VariablesEntorno {
	
	private static String URLWSD = "http://localhost:3000/";
	private static String URLWSP = "https://restmysql.herokuapp.com/";
	
	public static String getURLWSD() {
		return URLWSD;
	}
	public static void setURLWSD(String uRLWSD) {
		URLWSD = uRLWSD;
	}
	public static String getURLWSP() {
		return URLWSP;
	}
	public static void setURLWSP(String uRLWSP) {
		URLWSP = uRLWSP;
	}
	
}
