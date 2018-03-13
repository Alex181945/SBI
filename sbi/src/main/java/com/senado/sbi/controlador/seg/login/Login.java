package com.senado.sbi.controlador.seg.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 09/03/2018
 * Descripcion: Controlador para el inicio de sesion
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 * 
 */

@Controller
public class Login {
	
	@GetMapping("/")
	public String redirectLogin() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "index";
	}
	
	@PostMapping("/validausuario")
	public String validaUsuario(@ModelAttribute("usuario") String cUsuario,
			@ModelAttribute("password") String cPassword, Model model) {
		
		System.out.println(cUsuario);
		System.out.println(cPassword);
		
		return "";
	}

}
