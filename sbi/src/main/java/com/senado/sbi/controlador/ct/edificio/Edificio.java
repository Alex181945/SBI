package com.senado.sbi.controlador.ct.edificio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.seg.login.ULogin;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 30/04/2018
 * Descripcion: Controlador para el catalogo de edificios
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 * 
 */


@Controller
@SessionAttributes("Usuario")
public class Edificio {
	
	@GetMapping(Vistas.CT_EDIFICIO_CONSULTA_R)
	public ModelAndView consulta(@ModelAttribute("Usuario") ULogin sessionUsu) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getCtEdificioConsulta());
		return mav;
	}

}
