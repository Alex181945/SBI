package com.senado.sbi.rest.seg.login.imp;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senado.sbi.configuracion.VariablesEntorno;
import com.senado.sbi.modelo.datos.Validacion;
import com.senado.sbi.modelo.seg.login.ULogin;
import com.senado.sbi.rest.seg.login.LoginRest;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 13/03/2018
 * Descripcion: Implementacion de Interfaz de Login Rest
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 *
 * Nota: 0 es falso, 1 es verdadero
 * 
 */

@Component
public class ImpLoginRest implements LoginRest {
	
	private Boolean resultadoLocal;
	private String  mensajeLocal;
	private ULogin  uLogin;

	@Override
	public void validaUsuario(ULogin objUsuario) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		/*JSON obtenido de forma plana*/
		ResponseEntity<String> response = restTemplate.postForEntity(VariablesEntorno.getURLWSP()+"validausuario", objUsuario, String.class);
		
		ULogin[] uLogin = null;
		Validacion[] validacion = null;
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = null;
		JsonNode validacionJs = null;
		JsonNode datos = null;
		JsonNode token = null;
		
		try {
			
			root = mapper.readTree(response.getBody());
			validacionJs = root.path("validacion");
			datos = root.path("datos");
			token = root.path("token");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: JsonProcessingException en " + this.getClass().getEnclosingMethod().getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: IOException en " + this.getClass().getEnclosingMethod().getName());
		}
		
		if(validacion[0].getlError() == 1) {
			this.setResultadoLocal(true);
			this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
		} else {
			uLogin = mapper.convertValue(datos, ULogin[].class);
			this.setResultadoLocal(false);
			this.setMensajeLocal("");
			this.setuLogin(uLogin, token.asText());
		}
		
	}
	
	@Override
	public boolean islResultado() {
		// TODO Auto-generated method stub
		return this.getResultadoLocal();
	}

	@Override
	public String getMensaje() {
		// TODO Auto-generated method stub
		return this.getMensajeLocal();
	}

	@Override
	public ULogin getUsuario() {
		// TODO Auto-generated method stub
		return this.getuLogin();
	}

	
	public Boolean getResultadoLocal() {
		return resultadoLocal;
	}

	
	public void setResultadoLocal(Boolean resultado) {
		resultadoLocal = resultado;
	}

	
	public String getMensajeLocal() {
		return mensajeLocal;
	}

	
	public void setMensajeLocal(String mensaje) {
		mensajeLocal = mensaje;
	}

	public ULogin getuLogin() {
		return uLogin;
	}

	public void setuLogin(ULogin[] uLoginArray, String cToken) {
		
		ULogin uLogin = new ULogin();
		uLogin.setcUsuario(uLoginArray[0].getcUsuario());
		uLogin.setcContrasena(uLoginArray[0].getcContrasena());
		uLogin.setcToken(cToken);
		uLogin.setcNombre(uLoginArray[0].getcNombre());
		uLogin.setcPaterno(uLoginArray[0].getcPaterno());
		uLogin.setcMaterno(uLoginArray[0].getcMaterno());
		uLogin.setcPuesto(uLoginArray[0].getcPuesto());
		uLogin.setcExtension(uLoginArray[0].getcExtension());
		uLogin.setcCorreo(uLoginArray[0].getcCorreo());
		uLogin.setlHonorarios(uLoginArray[0].getlHonorarios());
		uLogin.setiPerfil(uLoginArray[0].getiPerfil());
		uLogin.setlActivo(uLoginArray[0].getlActivo());
		uLogin.setDtCreado(uLoginArray[0].getDtCreado());
		uLogin.setDtModificado(uLoginArray[0].getDtModificado());
		uLogin.setcUsuarioR(uLoginArray[0].getcUsuarioR());
		
		this.uLogin = uLogin;
	}
	
}
