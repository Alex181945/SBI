package com.senado.sbi.modelo.ct;

public class TipoServicio {
	
	private Integer iIDTipoServicio;
	private String cTipoServicio;
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
	public String getcTipoServicio() {
		return cTipoServicio;
	}
	public void setcTipoServicio(String cTipoServicio) {
		this.cTipoServicio = cTipoServicio;
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
		return "TipoServicio [iIDTipoServicio=" + iIDTipoServicio + ", cTipoServicio=" + cTipoServicio + ", lActivo=" + lActivo
				+ ", dtCreado=" + dtCreado + ", dtModificado=" + dtModificado + ", cUsuario=" + cUsuario + "]";
	}
	
	public String toJson() {
		return "{"
				+ "iIDTipoServicio:"   	+ iIDTipoServicio  	+ ","
				+ "cTipoServicio:"     	+ cTipoServicio    	+ ","
				+ "lActivo:" 	 		+ lActivo 			+ ","
				+ "dtCreado:"        	+ dtCreado       	+ ","
				+ "dtModificado:"      	+ dtModificado     	+ ","
				+ "cUsuario:"      		+ cUsuario 
				+ "}";
	}
	
	public static TipoServicio[] tiposervicioDefault() {
		
		TipoServicio tiposervicio = new TipoServicio();
		
		tiposervicio.setiIDTipoServicio(0);
		tiposervicio.setcTipoServicio("Tipo Servicio Default");
		tiposervicio.setlActivo(0);
		tiposervicio.setDtCreado("N/A");
		tiposervicio.setDtModificado("N/A");
		tiposervicio.setcUsuario("N/A");
		
		TipoServicio[] tiposervicioDefault = {tiposervicio};
		
		return tiposervicioDefault;
		
	}
	
	

}
