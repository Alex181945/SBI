package com.senado.sbi.rest.op.ticket.imp;

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
import com.senado.sbi.modelo.datos.Validacion;
import com.senado.sbi.modelo.op.ticket.TicketM;
import com.senado.sbi.rest.op.ticket.TicketRest;

@Component
public class ImpTicketRest implements TicketRest {
	
	private final static Logger LOGGER = Logger.getLogger(ImpTicketRest.class.getName());
	private Boolean resultadoLocal;
	private String  mensajeLocal;

	@SuppressWarnings("static-access")
	@Override
	public void insertaTicket(TicketM objTicket, String cToken) {
		
		RestTemplate restTemplate = new RestTemplate();		
		
		Validacion[] validacion   = null;
		ObjectMapper mapper       = new ObjectMapper();
		JsonNode     root         = null;
		JsonNode     validacionJs = null;
		//JsonNode     datos        = null;
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(VariablesEntorno.getHeaderString(), VariablesEntorno.getTokenPrefix() + cToken);
			
			MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();     
			body.add("objTicket", objTicket.toJson());
			body.add("iTipoAsignacionTecnico", VariablesEntorno.getTipoasignaciontecnico());

			HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);
			
			/*JSON obtenido de forma plana*/
			ResponseEntity<String> response = restTemplate.exchange(VariablesEntorno.getUrlwsd() + "/ticket/inserta",
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
			//datos = root.path("datos");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
			if(validacion[0].getlError() == 1) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
			} else {
				this.setResultadoLocal(false);
				this.setMensajeLocal("");
				/*Si sale exitosamente correr procedimiento que mande un email
				 *y te diga que tu ticket fue dado de alta y te manda la informacion del mismo
				 */
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
