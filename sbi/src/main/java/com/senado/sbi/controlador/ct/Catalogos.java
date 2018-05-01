package com.senado.sbi.controlador.ct;

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

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 30/04/2018
 * Descripcion: Controlador para mostrar la pagina de catalogos
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 * 
 */


@Controller
@SessionAttributes("Usuario")
public class Catalogos {
	
	@Autowired
	private MenuRest menuRest;
	
	@GetMapping(Vistas.CT_TODOS_R)
	public ModelAndView inicio(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		/*Consulta del menu*/
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sessionUsu.getiPerfil());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getCtTodos());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
		return mav;
	}

}
