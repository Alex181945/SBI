package com.senado.sbi.modelo.op.ServAdmon;

public class ServAdmonM {
	private Integer iIDServAdministrados;
	private Integer iIDEdificio;
	private String  cPiso;
	private String  cOficina;
	private Integer iIDArea;
	private Integer iIDSubArea;
	private String  cResguardante;
	private String  cResponsable;
	private String  cFactura;
	private String  cObs;
	private String  cTipoRecibo; // Este campo tiene como id el iIDTipoServicio
	private String  dtCreado;
	private String  dtModificado;
	private String  lActivo;
	private String  cUsuario;
	
	public Integer getiIDServAdministrados() {
		return iIDServAdministrados;
	}
	public void setiIDServAdministrados(Integer iIDServAdministrados) {
		this.iIDServAdministrados = iIDServAdministrados;
	}
	public Integer getiIDEdificio() {
		return iIDEdificio;
	}
	public void setiIDEdificio(Integer iIDEdificio) {
		this.iIDEdificio = iIDEdificio;
	}
	public String getcPiso() {
		return cPiso;
	}
	public void setcPiso(String cPiso) {
		this.cPiso = cPiso;
	}
	public String getcOficina() {
		return cOficina;
	}
	public void setcOficina(String cOficina) {
		this.cOficina = cOficina;
	}
	public Integer getiIDArea() {
		return iIDArea;
	}
	public void setiIDArea(Integer iIDArea) {
		this.iIDArea = iIDArea;
	}
	public Integer getiIDSubArea() {
		return iIDSubArea;
	}
	public void setiIDSubArea(Integer iIDSubArea) {
		this.iIDSubArea = iIDSubArea;
	}
	public String getcResguardante() {
		return cResguardante;
	}
	public void setcResguardante(String cResguardante) {
		this.cResguardante = cResguardante;
	}
	public String getcResponsable() {
		return cResponsable;
	}
	public void setcResponsable(String cResponsable) {
		this.cResponsable = cResponsable;
	}
	public String getcFactura() {
		return cFactura;
	}
	public void setcFactura(String cFactura) {
		this.cFactura = cFactura;
	}
	public String getcObs() {
		return cObs;
	}
	public void setcObs(String cObs) {
		this.cObs = cObs;
	}
	public String getcTipoRecibo() {
		return cTipoRecibo;
	}
	public void setcTipoRecibo(String cTipoRecibo) {
		this.cTipoRecibo = cTipoRecibo;
	}
	public String getDtCreado() {
		return dtCreado;
	}
	public void setDtCreado(String dtCreado) {
		this.dtCreado = dtCreado;
	}
	public String getlActivo() {
		return lActivo;
	}
	public void setlActivo(String lActivo) {
		this.lActivo = lActivo;
	}
	
	public String getdtModificado() {
		return dtModificado;
	}
	public void setdtModificado(String dtModificado) {
		this.dtModificado = dtModificado;
	}
	
	public String getcUsuario() {
		return cUsuario;
	}
	public void setcUsuario(String cUsuario) {
		this.cUsuario = cUsuario;
	}
	
	@Override
	public String toString() {
		return "ServAdmonoM [iIDServAdministrados=" + iIDServAdministrados + ","
	+ " iIDEdificio=" + iIDEdificio + "," 
	+ " cPiso="+ cPiso + ", cOficina=" + cOficina + "" 
	+ ", iIDArea=" + iIDArea + ", " + "iIDSubArea=" + iIDSubArea
	+ "," + " cResguardante=" + cResguardante + ", " + "cResponsable=" + cResponsable 
	+ ", " + "cFactura=" + cFactura + ", cObs=" + cObs + "" 
	+ ", " + "dtCreado=" + dtCreado + ", dtModificado=" + dtModificado + ""
	+ " cUsuario=" + cUsuario + "]";
	}

	public String toJson() {
		return "{" + "iIDServAdministrados:" + iIDServAdministrados + "," + "iIDEdificio:" + iIDEdificio + "," + "cPiso:" + cPiso + ","
				+ "cOficina:" + cOficina + "," + "iIDArea:" + iIDArea + "," + "iIDSubArea:" + iIDSubArea + ","
				+ "cResguardante:" + cResguardante + "," + "cResponsable:" + cResponsable + "," + "cFactura:" + cFactura
				+ "," + "cObs:" + cObs + "," + "dtCreado:" + dtCreado + "," + "dtModificado: "+ dtModificado + "cUsuario:" + cUsuario + "}";
	}
	
}