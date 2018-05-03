package com.senado.sbi.modelo.ct;

public class Criticidad {
	
	private Integer iIDCriticidad;
	private String cCriticidad;
	private Integer lActivo;
	private String dtCreado;
	private String dtModificado;
	private String cUsuario;
	
	public Integer getiIDCriticidad() {
		return iIDCriticidad;
	}
	public void setiIDCriticidad(Integer iIDCriticidad) {
		this.iIDCriticidad = iIDCriticidad;
	}
	public String getcCriticidad() {
		return cCriticidad;
	}
	public void setcCriticidad(String cCriticidad) {
		this.cCriticidad = cCriticidad;
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
		return "Criticidad [iIDCriticidad=" + iIDCriticidad + ", cCriticidad=" + cCriticidad + 
				", lActivo=" + lActivo + ", dtCreado=" + dtCreado + ", dtModificado=" + dtModificado + ", cUsuario="
				+ cUsuario + "]";
	}
	
	public String toJson() {
		return "{"
				+ "iIDCriticidad:" + iIDCriticidad  + ","
				+ "cCriticidad:"   + cCriticidad  + ","
				+ "lActivo:"       + lActivo      + ","
				+ "dtCreado:"      + dtCreado     + ","
				+ "dtModificado:"  + dtModificado + ","
				+ "cUsuario:"      + cUsuario 
				+ "}";
	}
	
	public static Criticidad[] criticidadDefault() {
		
		Criticidad criticidad = new Criticidad();
		
		criticidad.setiIDCriticidad(0);
		criticidad.setcCriticidad("Criticidad Default");
		criticidad.setlActivo(0);
		criticidad.setDtCreado("N/A");
		criticidad.setDtModificado("N/A");
		criticidad.setcUsuario("N/A");
		
		Criticidad[] criticidadDefault = {criticidad};
		
		return criticidadDefault;
		
	}
	
	
}
