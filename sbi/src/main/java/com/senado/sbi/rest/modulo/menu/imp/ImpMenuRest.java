package com.senado.sbi.rest.modulo.menu.imp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senado.sbi.configuracion.VariablesEntorno;
import com.senado.sbi.modelo.datos.Validacion;
import com.senado.sbi.modelo.datos.consulta.DosParametrosEnteros;
import com.senado.sbi.modelo.modulo.Menu;
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
			headers.add(VariablesEntorno.getHeaderString(), VariablesEntorno.getTokenPrefix() + cToken);
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			
			MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
			body.add("iTipoConsulta", consulta.getParametro1().toString());
			body.add("iIDPerfil", consulta.getParametro2().toString());

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(
					body, headers);
			
			/*JSON obtenido de forma plana*/
			ResponseEntity<String> response = restTemplate.postForEntity(VariablesEntorno.getUrlwsd() + "/carga/modulo",
					request, String.class);
			
			root = mapper.readTree(response.getBody());
			validacionJs = root.path("validacion");
			datos = root.path("datos");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
			if(validacion[0].getlError() == 1) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
			} else {
				//uLogin = mapper.convertValue(datos, ULogin[].class);
				this.setResultadoLocal(false);
				this.setMensajeLocal("");
				//this.setuLogin(uLogin, token.asText());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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
