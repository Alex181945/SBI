package com.senado.sbi.controlador.ticket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.senado.sbi.configuracion.Vistas;

@Controller
@SessionAttributes("Usuario")
public class Ticket {
	
	@GetMapping("/t")
	public String redireccion(){
		return Vistas.getRedirectTicket();
	}
	
	@GetMapping("/ticket")
	public ModelAndView Inicio() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getTicket());
		mav.addObject("titulo", "Bienvenido");
		mav.addObject("menu", "Menu");
		return mav;
	}
	

}