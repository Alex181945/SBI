package com.senado.sbi.rest.modulo.menu.imp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senado.sbi.configuracion.VariablesEntorno;
import com.senado.sbi.modelo.datos.Validacion;
import com.senado.sbi.modelo.datos.consulta.DosParametrosEnteros;
import com.senado.sbi.modelo.modulo.Menu;
import com.senado.sbi.modelo.seg.login.ULogin;
import com.senado.sbi.rest.modulo.menu.MenuRest;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 07/04/2018
 * Descripcion: Implementacion de la interfaz MenuRest
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 *
 * Nota: 0 es falso, 1 es verdadero
 * 
 */

@Component
public class ImpMenuRest implements MenuRest {
	
	private Boolean resultadoLocal;
	private String  mensajeLocal;

	@Override
	public Menu cargaMenu(DosParametrosEnteros consulta, String cToken) {
		
		RestTemplate restTemplate = new RestTemplate();		
		
		Menu[]       menu         = null;
		Validacion[] validacion   = null;
		ObjectMapper mapper       = new ObjectMapper();
		JsonNode     root         = null;
		JsonNode     validacionJs = null;
		JsonNode     datos        = null;
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", VariablesEntorno.getTokenPrefix() + cToken);
			
			consulta.setHeaders(headers);
			
			/*JSON obtenido de forma plana*/
			ResponseEntity<String> response = restTemplate.postForEntity(VariablesEntorno.getUrlwsd() + "/carga/modulo",
					consulta, String.class);
			
			
			
		} catch (Exception e) {
			
		}
		
		if(validacion[0].getlError() == 1) {
			this.setResultadoLocal(true);
			this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
		} else {
			//uLogin = mapper.convertValue(datos, ULogin[].class);
			this.setResultadoLocal(false);
			this.setMensajeLocal("");
			//this.setuLogin(uLogin, token.asText());
		}

		return null;
	}

	@Override
	public boolean islResultado() {

		return false;
	}

	@Override
	public String getMensaje() {

		return null;
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
