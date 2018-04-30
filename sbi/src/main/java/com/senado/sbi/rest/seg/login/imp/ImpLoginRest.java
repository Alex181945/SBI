package com.senado.sbi.rest.seg.login.imp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senado.sbi.configuracion.MensajeError;
import com.senado.sbi.configuracion.VariablesEntorno;
import com.senado.sbi.modelo.datos.Validacion;
import com.senado.sbi.modelo.seg.login.ULogin;
import com.senado.sbi.modelo.seg.login.UsuarioTemp;
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

	private final static Logger LOGGER = Logger.getLogger(ImpLoginRest.class.getName());
	private Boolean resultadoLocal;
	private String  mensajeLocal;
	private ULogin  uLogin;

	@SuppressWarnings("static-access")
	@Override
	public void validaUsuario(UsuarioTemp objUsuario) {
		
		/*Instancia de restTemplate*/
		RestTemplate restTemplate = new RestTemplate();		
		
		/*Variables de la clase*/
		ULogin[] uLogin = null;
		Validacion[] validacion = null;
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = null;
		JsonNode validacionJs = null;
		JsonNode datos = null;
		JsonNode token = null;
		
		try {
			
			/*Envia peticion y parametros*/
			ResponseEntity<String> response = restTemplate.postForEntity(VariablesEntorno.getUrlwsd() + "validausuario",
					objUsuario, String.class);
			
			/*Obtiene todo el contenido de la respuesta json*/
			root = mapper.readTree(response.getBody());
			
			/*Maneja los errores del servicio rest*/
			if(root.has("error")) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(MensajeError.getERROR1());
				this.LOGGER.log(Level.SEVERE,root.path("error").toString());
				return;
			}
			
			/* Si no devuleve errores el servicio rest
			 * secciona la respuesta*/
			validacionJs = root.path("validacion");
			datos = root.path("datos");
			token = root.path("token");
			
			/* Mapea las validaciones del servicio rest,
			 * lo vuelve un objeto*/
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
			/* Comprueba si existen errore en la consulta a datos
			 * si todo sale bien devulve el objeto usuario y el token
			 * para las futuras peticiones al servicio rest*/
			if(validacion[0].getlError() == 1) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
			} else {
				uLogin = mapper.convertValue(datos, ULogin[].class);
				this.setResultadoLocal(false);
				this.setMensajeLocal("");
				this.setuLogin(uLogin, token.asText());
			}
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: JsonProcessingException en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return;
		} catch (IOException e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: IOException en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return;
		} catch (Exception e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: Exception en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return;
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
