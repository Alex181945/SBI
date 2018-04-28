package com.senado.sbi.modelo.ct;

public class FormaSolicitud {
	
	private Integer iIDCreaTicket;
	private String 	cCreaTicket;
	private Integer lActivo;
	private String 	dtCreado;
	private String 	dtModificado;
	private String 	cUsuario;
	
	
	public Integer getiIDCreaTicket() {
		return iIDCreaTicket;
	}
	public void setiIDCreaTicket(Integer iIDCreaTicket) {
		this.iIDCreaTicket = iIDCreaTicket;
	}
	public String getcCreaTicket() {
		return cCreaTicket;
	}
	public void setcCreaTicket(String cCreaTicket) {
		this.cCreaTicket = cCreaTicket;
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
		return "FormaSolicitud [iIDCreaTicket=" + iIDCreaTicket + ", cCreaTicket=" + cCreaTicket + ", lActivo=" + lActivo
				+ ", dtCreado=" + dtCreado + ", dtModificado=" + dtModificado + ", cUsuario="
				+ cUsuario + "]";
	}
	
	public String toJson() {
		return "{"
				+ "iIDCreaTicket:"   + iIDCreaTicket  + ","
				+ "cCreaTicket:"     + cCreaTicket    + ","
				+ "lActivo:"       + lActivo      + ","
				+ "dtCreado:"      + dtCreado     + ","
				+ "dtModificado:"  + dtModificado + ","
				+ "cUsuario:"      + cUsuario 
				+ "}";
	}
	
	public static FormaSolicitud[] formasolicitudDefault() {
		
		FormaSolicitud formasolicitud = new FormaSolicitud();
		
		formasolicitud.setiIDCreaTicket(0);
		formasolicitud.setlActivo(0);
		formasolicitud.setDtCreado("N/A");
		formasolicitud.setDtModificado("N/A");
		formasolicitud.setcUsuario("N/A");
		
		FormaSolicitud[] formasolicitudDefault = {formasolicitud};
		
		return formasolicitudDefault;
		
	}

}
