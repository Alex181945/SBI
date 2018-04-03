package com.senado.sbi.controlador.seg.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.seg.login.ULogin;
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
@SessionAttributes("Usuario")
public class Login {
	
	@Autowired
	private LoginRest loginRest;
	
	@GetMapping("/")
	public String redirectLogin() {
		return Vistas.getRedirectLogin();
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		ULogin usuario = new ULogin();
		mav.addObject("Usuario", usuario);
		mav.setViewName(Vistas.getLogin());
		return mav;
	}
	
	@PostMapping("/validausuario")
	public String validaUsuario(@ModelAttribute("usuario") ULogin objUsuario, Model model) {

		loginRest.validaUsuario(objUsuario);
		
		if(loginRest.islResultado()) {
			model.addAttribute("error", loginRest.getMensaje());
			return Vistas.getLogin();
		}else {
			model.addAttribute("Usuario", loginRest.getUsuario());
		}
		
		return Vistas.getRedirectMenu();
	}

}
