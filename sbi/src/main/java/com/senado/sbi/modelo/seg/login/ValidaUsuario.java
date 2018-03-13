package com.senado.sbi.modelo.seg.login;

public class ValidaUsuario {

	private String cUsuario;
	private String cContrasena;
	
	public String getcUsuario() {
		return cUsuario;
	}
	public void setcUsuario(String cUsuario) {
		this.cUsuario = cUsuario;
	}
	public String getcContrasena() {
		return cContrasena;
	}
	public void setcContrasena(String cContrasena) {
		this.cContrasena = cContrasena;
	}
	
	public String toString() {
		return "cUsuario=" + getcUsuario() + "&cContrasena=" + getcContrasena() + "";
	}
	
}
