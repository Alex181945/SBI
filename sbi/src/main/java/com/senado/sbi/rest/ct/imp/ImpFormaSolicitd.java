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
import com.senado.sbi.modelo.ct.FormaSolicitud;
import com.senado.sbi.modelo.datos.Validacion;
import com.senado.sbi.rest.ct.FormaSolicitudRest;

@Component
public class ImpFormaSolicitd implements FormaSolicitudRest {
	
	private final static Logger LOGGER = Logger.getLogger(ImpFormaSolicitd.class.getName());
	private Boolean resultadoLocal;
	private String  mensajeLocal;

	@SuppressWarnings("static-access")
	@Override
	public FormaSolicitud[] consultaFormaSolicitudes(Integer iTipoConsulta, String cToken) {
		
		RestTemplate restTemplate = new RestTemplate();		
		
		FormaSolicitud[] formasolicitud  = null;
		Validacion[] 		validacion   = null;
		ObjectMapper 		mapper       = new ObjectMapper();
		JsonNode     		root         = null;
		JsonNode     		validacionJs = null;
		JsonNode     		datos        = null;
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(VariablesEntorno.getHeaderString(), VariablesEntorno.getTokenPrefix() + cToken);
			
			HttpEntity<?> httpEntity = new HttpEntity<Object>(headers);
			
			/*JSON obtenido de forma plana*/
			ResponseEntity<String> response = restTemplate.exchange(VariablesEntorno.getUrlwsd() + "/fmsolicitud/consulta?iTipoConsulta=" + iTipoConsulta,
					HttpMethod.GET ,httpEntity, String.class);
			
			root = mapper.readTree(response.getBody());
			
			/*Maneja los errores del servicio rest*/
			if(root.has("error")) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(MensajeError.getERROR1());
				this.LOGGER.log(Level.SEVERE,root.path("error").toString());
				return FormaSolicitud.formasolicitudDefault();
			}
			
			validacionJs = root.path("validacion");
			datos = root.path("datos");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
			if(validacion[0].getlError() == 1) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
				formasolicitud = FormaSolicitud.formasolicitudDefault();
			} else {
				formasolicitud = mapper.convertValue(datos, FormaSolicitud[].class);
				this.setResultadoLocal(false);
				this.setMensajeLocal("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: Exception en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
		}
		
		return formasolicitud;
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
