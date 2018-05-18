package com.senado.sbi.modelo.ct;

public class EstatusTicketM {

	private Integer iIDEstado;
	private String  cEstado;
	private Integer lActivo;
	private String  dtCreado;
	private String  dtModificado;
	private String  cUsuario;
	
	public Integer getiIDEstado() {
		return iIDEstado;
	}
	public void setiIDEstado(Integer iIDEstado) {
		this.iIDEstado = iIDEstado;
	}
	public String getcEstado() {
		return cEstado;
	}
	public void setcEstado(String cEstado) {
		this.cEstado = cEstado;
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
		return "EstatusTicketM [iIDEstado=" + iIDEstado + ", cEstado=" + cEstado + ", lActivo=" + lActivo
				+ ", dtCreado=" + dtCreado + ", dtModificado=" + dtModificado + ", cUsuario=" + cUsuario + "]";
	}	
	
}
