package com.senado.sbi.modelo.seg.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ULogin {

	private String cUsuario;
	private String cContrasena;
	private String cNombre;
	private String cPaterno;
	private String cMaterno;
	private String cPuesto;
	private String cExtension;
	private String cCorreo;
	private Boolean lHonorarios;
	private Integer iPerfil;
	private Boolean lActivo;
	private String dtCreado;
	private String dtModificado;
	private String cUsuarioR;
	
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
	public String getcNombre() {
		return cNombre;
	}
	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}
	public String getcPaterno() {
		return cPaterno;
	}
	public void setcPaterno(String cPaterno) {
		this.cPaterno = cPaterno;
	}
	public String getcMaterno() {
		return cMaterno;
	}
	public void setcMaterno(String cMaterno) {
		this.cMaterno = cMaterno;
	}
	public String getcPuesto() {
		return cPuesto;
	}
	public void setcPuesto(String cPuesto) {
		this.cPuesto = cPuesto;
	}
	public String getcExtension() {
		return cExtension;
	}
	public void setcExtension(String cExtension) {
		this.cExtension = cExtension;
	}
	public String getcCorreo() {
		return cCorreo;
	}
	public void setcCorreo(String cCorreo) {
		this.cCorreo = cCorreo;
	}
	public Boolean getlHonorarios() {
		return lHonorarios;
	}
	public void setlHonorarios(Boolean lHonorarios) {
		this.lHonorarios = lHonorarios;
	}
	public Integer getiPerfil() {
		return iPerfil;
	}
	public void setiPerfil(Integer iPerfil) {
		this.iPerfil = iPerfil;
	}
	public Boolean getlActivo() {
		return lActivo;
	}
	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
	}
	public String getDtCreado() {
		return dtCreado;
	}
	public void setDtCreado(String dtCreado) {
		this.dtCreado = dtCreado;
	}
	public String getDtModificado() {
		return dtModificado;
	}
	public void setDtModificado(String dtModificado) {
		this.dtModificado = dtModificado;
	}
	public String getcUsuarioR() {
		return cUsuarioR;
	}
	public void setcUsuarioR(String cUsuarioR) {
		this.cUsuarioR = cUsuarioR;
	}
	
	@Override
	public String toString() {
		return "Usuario [cUsuario=" + cUsuario + ", cContrasena=" + cContrasena + ", cNombre=" + cNombre + ", cPaterno="
				+ cPaterno + ", cMaterno=" + cMaterno + ", cPuesto=" + cPuesto + ", cExtension=" + cExtension
				+ ", cCorreo=" + cCorreo + ", lHonorarios=" + lHonorarios + ", iPerfil=" + iPerfil + ", lActivo="
				+ lActivo + ", dtCreado=" + dtCreado + ", dtModificado=" + dtModificado + ", cUsuarioR=" + cUsuarioR
				+ "]";
	}
	
	public String toJson() {
		return "";
	}

}
