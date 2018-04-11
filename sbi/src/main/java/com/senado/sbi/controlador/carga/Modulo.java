package com.senado.sbi.controlador.carga;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.seg.login.ULogin;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 07/04/2018
 * Descripcion: Controlador para la carga de datos de la 
 * aplicacion
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 * 
 */


@Controller
public class Modulo {
	
	@PostMapping("/carga/modulo")
	public String CargaModulo(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getRedirectMenuprincipal();
	}

}
