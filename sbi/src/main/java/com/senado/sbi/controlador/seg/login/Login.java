package com.senado.sbi.controlador.seg.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.seg.login.Usuario;
import com.senado.sbi.rest.seg.login.LoginRest;

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
	
	@Autowired
	private LoginRest loginRest;
	
	@GetMapping("/")
	public String redirectLogin() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		Usuario usuario = new Usuario();
		mav.addObject("Usuario", usuario);
		mav.setViewName(Vistas.getLogin());
		return mav;
	}
	
	@PostMapping("/validausuario")
	public String validaUsuario(@ModelAttribute("usuario") Usuario objUsuario) {
		
		System.out.println(objUsuario.getcUsuario());
		System.out.println(objUsuario.getcContrasena());
		
		loginRest.validaUsuario(objUsuario);
		
		return "index2";
	}

}
