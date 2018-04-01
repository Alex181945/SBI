package com.senado.sbi.controlador.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.senado.sbi.configuracion.Vistas;

@Controller
@SessionAttributes("Usuario")
public class Menu {
	
	@GetMapping("")
	public String redireccion(){
		return Vistas.getRedirectMenu();
	}
	
	@GetMapping("/menu/inicio")
	public ModelAndView Inicio() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getMenu());
		mav.addObject("titulo", "Bienvenido");
		mav.addObject("menu", "Menu");
		return mav;
	}
	

}
