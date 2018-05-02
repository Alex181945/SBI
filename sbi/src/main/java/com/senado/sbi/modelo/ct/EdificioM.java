package com.senado.sbi.modelo.ct;

public class EdificioM {
	
	private Integer iIDEdificio;
	private String cEdificio;
	private String cAbreviatura;
	private Integer iPisos;
	private String cPisoEsp;
	private String cCalle;
	private String cNumExt;
	private String cColonia;
	private String cMunicipio;
	private String cEstado;
	private String cCP;
	private Integer lActivo;
	private String dtCreado;
	private String dtModificado;
	private String cUsuario;
	
	public Integer getiIDEdificio() {
		return iIDEdificio;
	}
	public void setiIDEdificio(Integer iIDEdificio) {
		this.iIDEdificio = iIDEdificio;
	}
	public String getcEdificio() {
		return cEdificio;
	}
	public void setcEdificio(String cEdificio) {
		this.cEdificio = cEdificio;
	}
	public String getcAbreviatura() {
		return cAbreviatura;
	}
	public void setcAbreviatura(String cAbreviatura) {
		this.cAbreviatura = cAbreviatura;
	}
	public Integer getiPisos() {
		return iPisos;
	}
	public void setiPisos(Integer iPisos) {
		this.iPisos = iPisos;
	}
	public String getcPisoEsp() {
		return cPisoEsp;
	}
	public void setcPisoEsp(String cPisoEsp) {
		this.cPisoEsp = cPisoEsp;
	}
	public String getcCalle() {
		return cCalle;
	}
	public void setcCalle(String cCalle) {
		this.cCalle = cCalle;
	}
	public String getcNumExt() {
		return cNumExt;
	}
	public void setcNumExt(String cNumExt) {
		this.cNumExt = cNumExt;
	}
	public String getcColonia() {
		return cColonia;
	}
	public void setcColonia(String cColonia) {
		this.cColonia = cColonia;
	}
	public String getcMunicipio() {
		return cMunicipio;
	}
	public void setcMunicipio(String cMunicipio) {
		this.cMunicipio = cMunicipio;
	}
	public String getcEstado() {
		return cEstado;
	}
	public void setcEstado(String cEstado) {
		this.cEstado = cEstado;
	}
	public String getcCP() {
		return cCP;
	}
	public void setcCP(String cCP) {
		this.cCP = cCP;
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
		return "Edificio [iIDEdificio=" + iIDEdificio + ", cEdificio=" + cEdificio + ", cAbreviatura=" + cAbreviatura
				+ ", iPisos=" + iPisos + ", cPisoEsp=" + cPisoEsp + ", cCalle=" + cCalle + ", cNumExt=" + cNumExt
				+ ", cColonia=" + cColonia + ", cMunicipio=" + cMunicipio + ", cEstado=" + cEstado + ", cCP=" + cCP
				+ ", lActivo=" + lActivo + ", dtCreado=" + dtCreado + ", dtModificado=" + dtModificado + ", cUsuario="
				+ cUsuario + "]";
	}
	
	public String toJson() {
		return "{"
				+ "\"iIDEdificio\":"          + iIDEdificio  + ","
				+ "\"cEdificio\":"     + "\"" + cEdificio    + "\"" + ","
				+ "\"cAbreviatura\":"  + "\"" + cAbreviatura + "\"" + ","
				+ "\"iPisos\":"               + iPisos              + ","
				+ "\"cPisoEsp\":"      + "\"" + cPisoEsp     + "\"" + ","
				+ "\"cCalle\":"        + "\"" + cCalle       + "\"" + ","
				+ "\"cNumExt\":"       + "\"" + cNumExt      + "\"" + ","
				+ "\"cColonia\":"      + "\"" + cColonia     + "\"" + ","
				+ "\"cMunicipio\":"    + "\"" + cMunicipio   + "\"" + ","
				+ "\"cEstado\":"       + "\"" + cEstado      + "\"" + ","
				+ "\"cCP\":"           + "\"" + cCP          + "\"" + ","
				+ "\"lActivo\":"              + lActivo      + ","
				+ "\"dtCreado\":"      + "\"" + dtCreado     + "\"" + ","
				+ "\"dtModificado\":"  + "\"" + dtModificado + "\"" + ","
				+ "\"cUsuario\":"      + "\"" + cUsuario     + "\"" 
				+ "}";
	}
	
	public static EdificioM[] edificioDefault() {
		
		EdificioM edificio = new EdificioM();
		
		edificio.setiIDEdificio(0);
		edificio.setcAbreviatura("ED");
		edificio.setcEdificio("Edificio Default");
		edificio.setiPisos(0);
		edificio.setcPisoEsp("");
		edificio.setcCalle("N/A");
		edificio.setcNumExt("N/A");
		edificio.setcColonia("N/A");
		edificio.setcMunicipio("N/A");
		edificio.setcEstado("N/A");
		edificio.setcCP("N/A");
		edificio.setlActivo(0);
		edificio.setDtCreado("N/A");
		edificio.setDtModificado("N/A");
		edificio.setcUsuario("N/A");
		
		EdificioM[] edificioDefault = {edificio};
		
		return edificioDefault;
		
	}

}
