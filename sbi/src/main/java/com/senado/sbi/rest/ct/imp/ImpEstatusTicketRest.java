package com.senado.sbi.rest.ct.imp;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senado.sbi.configuracion.MensajeError;
import com.senado.sbi.configuracion.VariablesEntorno;
import com.senado.sbi.modelo.ct.EstatusTicketM;
import com.senado.sbi.modelo.datos.Validacion;
import com.senado.sbi.rest.ct.EstatusTicketRest;

@Component
public class ImpEstatusTicketRest implements EstatusTicketRest {
	
	private final static Logger LOGGER = Logger.getLogger(ImpEstatusTicketRest.class.getName());
	private Boolean resultadoLocal;
	private String  mensajeLocal;

	@SuppressWarnings("static-access")
	@Override
	public EstatusTicketM[] consultaEstatusTicketes(Integer iTipoConsulta, String cToken) {
		
		RestTemplate restTemplate = new RestTemplate();		
		
		EstatusTicketM[]   estatusTicket = null;
		Validacion[] validacion   		 = null;
		ObjectMapper mapper       		 = new ObjectMapper();
		JsonNode     root         		 = null;
		JsonNode     validacionJs 		 = null;
		JsonNode     datos        		 = null;
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(VariablesEntorno.getHeaderString(), VariablesEntorno.getTokenPrefix() + cToken);
			
			HttpEntity<?> httpEntity = new HttpEntity<Object>(headers);
			
			/*JSON obtenido de forma plana*/
			ResponseEntity<String> response = restTemplate.exchange(VariablesEntorno.getUrlwsd() + "/edificios/consulta?iTipoConsulta=" + iTipoConsulta,
					HttpMethod.GET ,httpEntity, String.class);
			
			root = mapper.readTree(response.getBody());
			
			/*Maneja los errores del servicio rest*/
			if(root.has("error")) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(MensajeError.getERROR1());
				this.LOGGER.log(Level.SEVERE,root.path("error").toString());
				return EstatusTicketM.estatusTicketDefault();
			}
			
			validacionJs = root.path("validacion");
			datos = root.path("datos");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
			if(validacion[0].getlError() == 1) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
				estatusTicket = EstatusTicketM.estatusTicketDefault();
			} else {
				estatusTicket = mapper.convertValue(datos, EstatusTicketM[].class);
				this.setResultadoLocal(false);
				this.setMensajeLocal("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: Exception en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
		}
		
		return estatusTicket;
	}

	@SuppressWarnings("static-access")
	@Override
	public EstatusTicketM consultaEstatusTicket(Integer iIDEstado, String cToken) {

		RestTemplate restTemplate = new RestTemplate();		
		
		EstatusTicketM   estatusTicket = null;
		Validacion[] validacion   	   = null;
		ObjectMapper mapper       	   = new ObjectMapper();
		JsonNode     root         	   = null;
		JsonNode     validacionJs 	   = null;
		JsonNode     datos        	   = null;
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(VariablesEntorno.getHeaderString(), VariablesEntorno.getTokenPrefix() + cToken);
			
			HttpEntity<?> httpEntity = new HttpEntity<Object>(headers);
			
			/*JSON obtenido de forma plana*/
			ResponseEntity<String> response = restTemplate.exchange(VariablesEntorno.getUrlwsd() + "/edificios/consulta/uno?iIDEdificio=" + iIDEstado,
					HttpMethod.GET ,httpEntity, String.class);
			
			root = mapper.readTree(response.getBody());
			
			/*Maneja los errores del servicio rest*/
			if(root.has("error")) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(MensajeError.getERROR1());
				this.LOGGER.log(Level.SEVERE,root.path("error").toString());
				return EstatusTicketM.estatusTicketDefault()[0];
			}
			
			validacionJs = root.path("validacion");
			datos = root.path("datos");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
			if(validacion[0].getlError() == 1) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
				estatusTicket = EstatusTicketM.estatusTicketDefault()[0];
			} else {
				EstatusTicketM[] ticketTemp = mapper.convertValue(datos, EstatusTicketM[].class);
				estatusTicket = ticketTemp[0]; 
				this.setResultadoLocal(false);
				this.setMensajeLocal("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: Exception en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
		}
		
		return estatusTicket;
	}

	@SuppressWarnings("static-access")
	@Override
	public void actualizaEstatusTicket(EstatusTicketM objEstatusTicket, String cToken) {
		
		RestTemplate restTemplate = new RestTemplate();		
		
		Validacion[] validacion   = null;
		ObjectMapper mapper       = new ObjectMapper();
		JsonNode     root         = null;
		JsonNode     validacionJs = null;
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(VariablesEntorno.getHeaderString(), VariablesEntorno.getTokenPrefix() + cToken);
			
			MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();     
			body.add("objEstatusTicket", objEstatusTicket.toJson());
			
			HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);
			
			/*JSON obtenido de forma plana*/
			ResponseEntity<String> response = restTemplate.exchange(VariablesEntorno.getUrlwsd() + "/edificios/actualiza",
					HttpMethod.PUT ,httpEntity, String.class);
			
			root = mapper.readTree(response.getBody());
			
			/*Maneja los errores del servicio rest*/
			if(root.has("error")) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(MensajeError.getERROR1());
				this.LOGGER.log(Level.SEVERE,root.path("error").toString());
				return;
			}
			
			validacionJs = root.path("validacion");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
			if(validacion[0].getlError() == 1) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
			} else {
				this.setResultadoLocal(false);
				this.setMensajeLocal("");
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: Exception en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
		}
		
	}

	@SuppressWarnings("static-access")
	@Override
	public void insertaEstatusTicket(EstatusTicketM objEstatusTicket, String cToken) {
		
		RestTemplate restTemplate = new RestTemplate();		
		
		Validacion[] validacion   = null;
		ObjectMapper mapper       = new ObjectMapper();
		JsonNode     root         = null;
		JsonNode     validacionJs = null;
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(VariablesEntorno.getHeaderString(), VariablesEntorno.getTokenPrefix() + cToken);
			
			MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();     
			body.add("objEstatusTicket", objEstatusTicket.toJson());
			
			HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);
			
			/*JSON obtenido de forma plana*/
			ResponseEntity<String> response = restTemplate.exchange(VariablesEntorno.getUrlwsd() + "/edificios/inserta",
					HttpMethod.POST ,httpEntity, String.class);
			
			root = mapper.readTree(response.getBody());
			
			/*Maneja los errores del servicio rest*/
			if(root.has("error")) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(MensajeError.getERROR1());
				this.LOGGER.log(Level.SEVERE,root.path("error").toString());
				return;
			}
			
			validacionJs = root.path("validacion");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
			if(validacion[0].getlError() == 1) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
			} else {
				this.setResultadoLocal(false);
				this.setMensajeLocal("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: Exception en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
		}
		
	}

	@SuppressWarnings("static-access")
	@Override
	public void borraEstatusTicket(Integer iIDEstado, String cUsuario, String cToken) {
		
		RestTemplate restTemplate = new RestTemplate();		
		
		Validacion[] validacion   = null;
		ObjectMapper mapper       = new ObjectMapper();
		JsonNode     root         = null;
		JsonNode     validacionJs = null;
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(VariablesEntorno.getHeaderString(), VariablesEntorno.getTokenPrefix() + cToken);
			
			MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();     
			body.add("iIDEstado", iIDEstado.toString());
			body.add("cUsuario", cUsuario);
			
			HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);
			
			/*JSON obtenido de forma plana*/
			ResponseEntity<String> response = restTemplate.exchange(VariablesEntorno.getUrlwsd() + "/edificios/borra",
					HttpMethod.DELETE ,httpEntity, String.class);
			
			root = mapper.readTree(response.getBody());
			
			/*Maneja los errores del servicio rest*/
			if(root.has("error")) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(MensajeError.getERROR1());
				this.LOGGER.log(Level.SEVERE,root.path("error").toString());
				return;
			}
			
			validacionJs = root.path("validacion");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
			if(validacion[0].getlError() == 1) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
			} else {
				this.setResultadoLocal(false);
				this.setMensajeLocal("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: Exception en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
		}
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
