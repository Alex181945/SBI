package com.senado.sbi.controlador.errores;

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

public class Errores {
	
	@Autowired
	private MenuRest menuRest;
	
	@GetMapping(Vistas.ERROR_404_R)
	public ModelAndView error404(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sessionUsu.getiPerfil());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getError404());
		mav.addObject("titulo", "No encontrado");
		mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
		return mav;
	}

}
