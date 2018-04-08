package com.senado.sbi.controlador.inicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.datos.consulta.DosParametrosEnteros;
import com.senado.sbi.modelo.seg.login.ULogin;
import com.senado.sbi.rest.modulo.menu.MenuRest;

@Controller
@SessionAttributes("Usuario")
public class MenuPrincipal {
	
	@Autowired
	private MenuRest menuRest;
	
	@GetMapping("/menu/inicio")
	public ModelAndView Inicio(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1);
		consulta.setParametro2(sessionUsu.getiPerfil());
		
		menuRest.cargaMenu(consulta, sessionUsu.getcToken());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getMenu());
		mav.addObject("titulo", "Bienvenido");
		mav.addObject("menu", "Menu");
		return mav;
	}
	

}
