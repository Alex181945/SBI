package com.senado.sbi.rest.ct.imp;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senado.sbi.configuracion.MensajeError;
import com.senado.sbi.configuracion.VariablesEntorno;
import com.senado.sbi.modelo.ct.SrvSolicitado;
import com.senado.sbi.modelo.datos.Validacion;
import com.senado.sbi.rest.ct.SrvSolicitadoRest;
import com.senado.sbi.rest.modulo.menu.imp.ImpMenuRest;

@Component
public class ImpSrvSolicitado implements SrvSolicitadoRest {
	
	private final static Logger LOGGER = Logger.getLogger(ImpMenuRest.class.getName());
	private Boolean resultadoLocal;
	private String  mensajeLocal;

	@SuppressWarnings("static-access")
	@Override
	public SrvSolicitado[] consultaSrvSolicitados(Integer iTipoConsulta, String cToken) {
		
		RestTemplate restTemplate = new RestTemplate();		
		
		SrvSolicitado[] srvsolicitado 	= null;
		Validacion[] validacion   	= null;
		ObjectMapper mapper       	= new ObjectMapper();
		JsonNode     root         	= null;
		JsonNode     validacionJs 	= null;
		JsonNode     datos        	= null;
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(VariablesEntorno.getHeaderString(), VariablesEntorno.getTokenPrefix() + cToken);
			
			HttpEntity<?> httpEntity = new HttpEntity<Object>(headers);
			
			/*JSON obtenido de forma plana*/
			ResponseEntity<String> response = restTemplate.exchange(VariablesEntorno.getUrlwsd() + "/srvsolicitado/consulta?iTipoConsulta=" + iTipoConsulta,
					HttpMethod.GET ,httpEntity, String.class);
			
			root = mapper.readTree(response.getBody());
			
			/*Maneja los errores del servicio rest*/
			if(root.has("error")) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(MensajeError.getERROR1());
				this.LOGGER.log(Level.SEVERE,root.path("error").toString());
				return SrvSolicitado.srvsolicitadoDefault();
			}
			
			validacionJs = root.path("validacion");
			datos = root.path("datos");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
			if(validacion[0].getlError() == 1) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
				srvsolicitado = SrvSolicitado.srvsolicitadoDefault();
			} else {
				srvsolicitado = mapper.convertValue(datos, SrvSolicitado[].class);
				this.setResultadoLocal(false);
				this.setMensajeLocal("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: Exception en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
		}
		
		return srvsolicitado;
	}

	@Override
	public boolean islResultado() {
		return this.getResultadoLocal();
	}

	@Override
	public String getMensaje() {
		return this.getMensajeLocal();
	}
	
	public Boolean getResultadoLocal() {
		return resultadoLocal;
	}

	public void setResultadoLocal(Boolean resultadoLocal) {
		this.resultadoLocal = resultadoLocal;
	}

	public String getMensajeLocal() {
		return mensajeLocal;
	}

	public void setMensajeLocal(String mensajeLocal) {
		this.mensajeLocal = mensajeLocal;
	}
	
}
