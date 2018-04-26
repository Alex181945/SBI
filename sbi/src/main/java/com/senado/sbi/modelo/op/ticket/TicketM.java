package com.senado.sbi.modelo.op.ticket;

public class TicketM {

	private Integer iIDTicket;
	private Integer iIDEstado;
	private String  cNumInventario;
	private String  cResguardante;
	private String  cUsuarioEquipo;
	private String  cExtension;
	private Integer iIDEdificio;
	private String  cPiso;
	private String  cOficina;
	private Integer iIDTipoServicio;
	private String  cUsuReporta;
	private String  cObs;
	private Integer iIDCreaTicket;
	private Integer iIDCriticidad;
	private String  cTecnico;
	private Integer lTecnicoAcepta;
	private Integer lNotificacion;
	private Integer lArrendado;
	private String  cUsuarioR;
	private String  dtFecha;
	
	public Integer getiIDTicket() {
		return iIDTicket;
	}
	public void setiIDTicket(Integer iIDTicket) {
		this.iIDTicket = iIDTicket;
	}
	public Integer getiIDEstado() {
		return iIDEstado;
	}
	public void setiIDEstado(Integer iIDEstado) {
		this.iIDEstado = iIDEstado;
	}
	public String getcNumInventario() {
		return cNumInventario;
	}
	public void setcNumInventario(String cNumInventario) {
		this.cNumInventario = cNumInventario;
	}
	public String getcResguardante() {
		return cResguardante;
	}
	public void setcResguardante(String cResguardante) {
		this.cResguardante = cResguardante;
	}
	public String getcUsuarioEquipo() {
		return cUsuarioEquipo;
	}
	public void setcUsuarioEquipo(String cUsuarioEquipo) {
		this.cUsuarioEquipo = cUsuarioEquipo;
	}
	public String getcExtension() {
		return cExtension;
	}
	public void setcExtension(String cExtension) {
		this.cExtension = cExtension;
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
	public Integer getiIDTipoServicio() {
		return iIDTipoServicio;
	}
	public void setiIDTipoServicio(Integer iIDTipoServicio) {
		this.iIDTipoServicio = iIDTipoServicio;
	}
	public String getcUsuReporta() {
		return cUsuReporta;
	}
	public void setcUsuReporta(String cUsuReporta) {
		this.cUsuReporta = cUsuReporta;
	}
	public String getcObs() {
		return cObs;
	}
	public void setcObs(String cObs) {
		this.cObs = cObs;
	}
	public Integer getiIDCreaTicket() {
		return iIDCreaTicket;
	}
	public void setiIDCreaTicket(Integer iIDCreaTicket) {
		this.iIDCreaTicket = iIDCreaTicket;
	}
	public Integer getiIDCriticidad() {
		return iIDCriticidad;
	}
	public void setiIDCriticidad(Integer iIDCriticidad) {
		this.iIDCriticidad = iIDCriticidad;
	}
	public String getcTecnico() {
		return cTecnico;
	}
	public void setcTecnico(String cTecnico) {
		this.cTecnico = cTecnico;
	}
	public Integer getlTecnicoAcepta() {
		return lTecnicoAcepta;
	}
	public void setlTecnicoAcepta(Integer lTecnicoAcepta) {
		this.lTecnicoAcepta = lTecnicoAcepta;
	}
	public Integer getlNotificacion() {
		return lNotificacion;
	}
	public void setlNotificacion(Integer lNotificacion) {
		this.lNotificacion = lNotificacion;
	}
	public Integer getlArrendado() {
		return lArrendado;
	}
	public void setlArrendado(Integer lArrendado) {
		this.lArrendado = lArrendado;
	}
	public String getcUsuarioR() {
		return cUsuarioR;
	}
	public void setcUsuarioR(String cUsuarioR) {
		this.cUsuarioR = cUsuarioR;
	}
	public String getDtFecha() {
		return dtFecha;
	}
	public void setDtFecha(String dtFecha) {
		this.dtFecha = dtFecha;
	}
	
	@Override
	public String toString() {
		return "TicketM [iIDTicket=" + iIDTicket + ", iIDEstado=" + iIDEstado + ", cNumInventario=" + cNumInventario
				+ ", cResguardante=" + cResguardante + ", cUsuarioEquipo=" + cUsuarioEquipo + ", cExtension="
				+ cExtension + ", iIDEdificio=" + iIDEdificio + ", cPiso=" + cPiso + ", cOficina=" + cOficina
				+ ", iIDTipoServicio=" + iIDTipoServicio + ", cUsuReporta=" + cUsuReporta + ", cObs=" + cObs
				+ ", iIDCreaTicket=" + iIDCreaTicket + ", iIDCriticidad=" + iIDCriticidad + ", cTecnico=" + cTecnico
				+ ", lTecnicoAcepta=" + lTecnicoAcepta + ", lNotificacion=" + lNotificacion + ", lArrendado="
				+ lArrendado + ", cUsuarioR=" + cUsuarioR + ", dtFecha=" + dtFecha + "]";
	}
	
	public String toJson() {
		return "{"
				+ "iIDTicket:"       + iIDTicket         + ","
				+ "iIDEstado:"       + iIDEstado         + ","
				+ "cNumInventario:"  + cNumInventario    + ","
				+ "cResguardante:"   + cResguardante     + ","
				+ "cUsuarioEquipo:"  + cUsuarioEquipo    + ","
				+ "cExtension:"      + cExtension        + ","
				+ "iIDEdificio:"     + iIDEdificio       + ","
				+ "cExtension:"      + cExtension        + ","
				+ "cPiso:"           + cPiso             + ","
				+ "cOficina:"        + cOficina          + ","
				+ "iIDTipoServicio:" + iIDTipoServicio   + ","
				+ "cUsuReporta:"     + cUsuReporta       + ","
				+ "cObs:"            + cObs              + ","
				+ "lTecnicoAcepta:"  + lTecnicoAcepta    + ","
				+ "lNotificacion:"   + lNotificacion     + ","
				+ "lArrendado:"      + lArrendado        + ","
				+ "cUsuarioR:"       + cUsuarioR         + ","
				+ "dtFecha:"         + dtFecha    
				+ "}";
	}
	
}
