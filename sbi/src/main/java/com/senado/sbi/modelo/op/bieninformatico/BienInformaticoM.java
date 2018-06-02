package com.senado.sbi.modelo.op.bieninformatico;

public class BienInformaticoM {
	private Integer iIDResguardo;
	private Integer iIDEdificio;
	private String 	cPiso;
	private String 	cOficina;
	private Integer iIDArea;
	private Integer iIDSubArea;
	private String cResguardante;
	private String cResponsable;
	private String cFactura;
	private String cObs;
	private String dtCreado;
	private String cUsuarioR;


	public Integer getiIDResguardo() {
		return iIDResguardo;
	}

	public void setiIDResguardo(Integer iIDResguardo) {
		this.iIDResguardo = iIDResguardo;
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

	public String getcUsuarioR() {
		return cUsuarioR;
	}

	public void setcUsuarioR(String cUsuarioR) {
		this.cUsuarioR = cUsuarioR;
	}

	public String getdtCreado() {
		return dtCreado;
	}

	public void setdtCreado(String dtCreado) {
		this.dtCreado = dtCreado;
	}

	@Override
	public String toString() {
		return "BienInformaticoM [iIDResguardo=" + iIDResguardo + ","
	+ " iIDEdificio=" + iIDEdificio + "," 
				+ " cPiso="
				+ cPiso + ", cOficina=" + cOficina + "" + ", iIDArea=" + iIDArea + ", " + "iIDSubArea=" + iIDSubArea
				+ "," + " cResguardante=" + cResguardante + ", " + "cResponsable=" + cResponsable + ", " + "cFactura="
				+ cFactura + ", cObs=" + cObs + "" + ", dtCreado=" + dtCreado + "," + " cUsuarioR=" + cUsuarioR + "]";
	}

	public String toJson() {
		return "{" + "iIDResguardo:" + iIDResguardo + "," + "iIDEdificio:" + iIDEdificio + "," + "cPiso:" + cPiso + ","
				+ "cOficina:" + cOficina + "," + "iIDArea:" + iIDArea + "," + "iIDSubArea:" + iIDSubArea + ","
				+ "cResguardante:" + cResguardante + "," + "cResponsable:" + cResponsable + "," + "cFactura:" + cFactura
				+ "," + "cObs:" + cObs + "," + "dtCreado:" + dtCreado + "," + "cUsuarioR:" + cUsuarioR + "}";
	}
}
