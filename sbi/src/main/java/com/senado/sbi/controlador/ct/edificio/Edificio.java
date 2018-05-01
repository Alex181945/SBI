package com.senado.sbi.controlador.ct.edificio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.ct.EdificioM;
import com.senado.sbi.modelo.seg.login.ULogin;
import com.senado.sbi.rest.ct.EdificioRest;

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
	
	@Autowired
	private EdificioRest edificioRest;
	
	@GetMapping(Vistas.CT_EDIFICIO_CONSULTA_R)
	public ModelAndView consulta(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getCtEdificioConsulta());
		mav.addObject("edificios", edificioRest.consultaEdificios(1, sessionUsu.getcToken()));
		return mav;
	}
	
	@GetMapping(Vistas.CT_EDIFICIO_FORMULARIO_R)
	public ModelAndView formulario(@ModelAttribute("Usuario") ULogin sessionUsu) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getCtEdificioFormulario());
		mav.addObject("objEdificio", new EdificioM());
		return mav;
	}

}
