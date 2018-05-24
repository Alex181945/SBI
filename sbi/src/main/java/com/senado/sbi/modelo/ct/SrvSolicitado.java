package com.senado.sbi.modelo.ct;

public class SrvSolicitado{
	
	private Integer iIDTipoServicio;
	private Integer iPartida;
	private String cServicioSolicitado; 
	private Integer lActivo;
	private String dtCreado; 
	private String dtModificado; 
	private String cUsuario;
	
	public Integer getiIDTipoServicio() {
		return iIDTipoServicio;
	}
	public void setiIDTipoServicio(Integer iIDTipoServicio) {
		this.iIDTipoServicio = iIDTipoServicio;
	}	
	public Integer getiPartida() {
		return iPartida;
	}
	public void setiPartida(Integer iPartida) {
		this.iPartida = iPartida;
	}
	public String getcServicioSolicitado() {
		return cServicioSolicitado;
	}
	public void setcServicioSolicitado(String cServicioSolicitado) {
		this.cServicioSolicitado = cServicioSolicitado;
	}
	public Integer getlActivo() {
		return lActivo;
	}
	public void setlActivo(Integer lActivo) {
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
	public String getcUsuario() {
		return cUsuario;
	}
	public void setcUsuario(String cUsuario) {
		this.cUsuario = cUsuario;
	}
	
	@Override
	public String toString() {
		return "SrvSolicitado [iIDTipoServicio=" + iIDTipoServicio + ", iPartida=" + iPartida + ", cServicioSolicitado =" + cServicioSolicitado
				+ ", lActivo=" + lActivo + ", dtCreado=" + dtCreado + ", dtModificado=" + dtModificado + ", cUsuario="
				+ cUsuario + "]";
	}
	
	public String toJson() {
		return "{"
				+ "iIDTipoServicio:"   + iIDTipoServicio	  	+ ","
				+ "iPartida:"     		+ iPartida    			+ ","
				+ "cServicioSolicitado" + cServicioSolicitado 	+ ","
				+ "lActivo:"       		+ lActivo      			+ ","
				+ "dtCreado:"      		+ dtCreado     			+ ","
				+ "dtModificado:"  		+ dtModificado 			+ ","
				+ "cUsuario:"      		+ cUsuario 
				+ "}";
	}
	
	public static SrvSolicitado[] srvsolicitadoDefault() {
		
		SrvSolicitado srvsolicitado = new SrvSolicitado();
		
		srvsolicitado.setiIDTipoServicio(0);
		srvsolicitado.setiPartida(0);
		srvsolicitado.setcServicioSolicitado("N/A");
		srvsolicitado.setlActivo(0);
		srvsolicitado.setDtCreado("N/A");
		srvsolicitado.setDtModificado("N/A");
		srvsolicitado.setcUsuario("N/A");
		
		SrvSolicitado[] srvsolicitadoDefault = {srvsolicitado};
		
		return srvsolicitadoDefault;
		
	}
	
}