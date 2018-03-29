package com.senado.sbi.rest.seg.login.imp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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

@Component
public class ImpLoginRest implements LoginRest {

	@Override
	public void validaUsuario(Usuario objUsuario) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		/*JSON obtenido de forma plana*/
		ResponseEntity<String> response = restTemplate.postForEntity(VariablesEntorno.getURLWSD()+"validausuario", objUsuario, String.class);
		
		System.out.println("---Inicio---Resultados de la peticion---Inicio---");
		System.out.println("GET All StatusCode = " + response.getStatusCode());
		System.out.println("GET All Headers = " + response.getHeaders());
		System.out.println("GET Body (object list): ");
		System.out.println(response.hasBody());
		System.out.println(response.getBody().toString());
		System.out.println("---Fin---Resultados de la peticion---Fin---");
		
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
