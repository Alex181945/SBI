package com.senado.sbi.rest.seg.login.imp;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.senado.sbi.configuracion.VariablesEntorno;
import com.senado.sbi.modelo.seg.login.Usuario;
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

public class ImpLoginRest implements LoginRest {

	@SuppressWarnings("static-access")
	@Override
	public void validaUsuario(String cUsuario, String cContrasena) {
		
		RestTemplate restTemplate = new RestTemplate();
		VariablesEntorno variables = new VariablesEntorno();
		
		ResponseEntity<Usuario[]> response =
	            restTemplate.getForEntity(variables.getURLWSD(), Usuario[].class);
		
		System.out.println();
		System.out.println("GET All StatusCode = " + response.getStatusCode());
		System.out.println("GET All Headers = " + response.getHeaders());
		System.out.println("GET Body (object list): ");
		Arrays.asList(response.getBody())
		            .forEach(book -> System.out.println("--> " + book));
		
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
