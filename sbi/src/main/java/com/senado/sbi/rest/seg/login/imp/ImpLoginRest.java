package com.senado.sbi.rest.seg.login.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public void validaUsuario(ULogin objUsuario) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		/*JSON obtenido de forma plana*/
		ResponseEntity<String> response = restTemplate.postForEntity(VariablesEntorno.getURLWSD()+"validausuario", objUsuario, String.class);
		
		ULogin[] uLogin = null;
		Validacion[] validacion = null;
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = null;
		try {
			
			root = mapper.readTree(response.getBody());
			JsonNode validacionJs = root.path("validacion");
			JsonNode datos = root.path("datos");
			JsonNode token = root.path("token");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			uLogin = mapper.convertValue(datos, ULogin[].class);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < validacion.length; i++) {
			validacion[i].getlError();
		}
		
		for (int i = 0; i < uLogin.length; i++) {
			System.out.println(uLogin[i].getcUsuario());
		}
		
	}

	@Override
	public Boolean getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
