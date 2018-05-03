package com.senado.sbi.controlador.ct.edificio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.senado.sbi.configuracion.MensajeExito;
import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.ct.EdificioM;
import com.senado.sbi.modelo.datos.consulta.DosParametrosEnteros;
import com.senado.sbi.modelo.seg.login.ULogin;
import com.senado.sbi.rest.ct.EdificioRest;
import com.senado.sbi.rest.modulo.menu.MenuRest;

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
	
	@Autowired
	private MenuRest menuRest;
	
	@GetMapping(Vistas.CT_EDIFICIO_CONSULTA_R)
	public ModelAndView consultaTodos(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sessionUsu.getiPerfil());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getCtEdificioConsulta());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
		mav.addObject("edificios", edificioRest.consultaEdificios(2, sessionUsu.getcToken()));
		return mav;
	}
	
	@GetMapping(Vistas.CT_EDIFICIO_FORMULARIO_R)
	public ModelAndView formulario(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sessionUsu.getiPerfil());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getCtEdificioFormulario());
		mav.addObject("lInserta",true);
		mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
		mav.addObject("objEdificio", new EdificioM());
		return mav;
	}
	
	@PostMapping(Vistas.CT_EDIFICIO_INSERTA_R)
	public ModelAndView inserta(@ModelAttribute("Usuario") ULogin sessionUsu,
			@ModelAttribute("objEdificio") EdificioM objEdificio) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sessionUsu.getiPerfil());
		
		objEdificio.setcUsuario(sessionUsu.getcUsuario());
		edificioRest.insertaEdificio(objEdificio, sessionUsu.getcToken());
		ModelAndView mav = new ModelAndView();
		
		if(edificioRest.islResultado()) {
			mav.setViewName(Vistas.getCtEdificioFormulario());
			mav.addObject("objEdificio", objEdificio);
			mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
			mav.addObject("error", edificioRest.getMensaje());
		} else {
			mav.setViewName(Vistas.getCtEdificioConsulta());
			mav.addObject("exito", MensajeExito.getExitoCtEdificioInserta());
			mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
			mav.addObject("edificios", edificioRest.consultaEdificios(1, sessionUsu.getcToken()));
		}

		return mav;
	}

	@GetMapping(Vistas.CT_EDIFICIO_CONSULTA_UNO_R)
	public ModelAndView consultaUno(@ModelAttribute("Usuario") ULogin sessionUsu,
			@ModelAttribute("iIDEdificio") Integer iIDEdificio) {
		ModelAndView mav = new ModelAndView();
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sessionUsu.getiPerfil());
		
		EdificioM edificio = edificioRest.consultaEdificio(iIDEdificio, sessionUsu.getcToken());
		
		if(edificioRest.islResultado()) {
			mav.setViewName(Vistas.getCtEdificioConsulta());
			mav.addObject("error", edificioRest.getMensaje());
			mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
			mav.addObject("edificios", edificioRest.consultaEdificios(2, sessionUsu.getcToken()));
		}else {
			mav.setViewName(Vistas.getCtEdificioFormulario());
			mav.addObject("lInserta",false);
			mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
			mav.addObject("objEdificio", edificio);
		}

		return mav;
	}
	
	@PostMapping(Vistas.CT_EDIFICIO_EDITA_R)
	public ModelAndView edita(@ModelAttribute("Usuario") ULogin sessionUsu,
			@ModelAttribute("objEdificio") EdificioM objEdificio, 
			@ModelAttribute("activo") String lActivo) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sessionUsu.getiPerfil());

		objEdificio.setcUsuario(sessionUsu.getcUsuario());
		objEdificio.setlActivo(lActivo.equals("on") ? 1 : 0);
		edificioRest.actualizaEdificio(objEdificio, sessionUsu.getcToken());
		ModelAndView mav = new ModelAndView();
		
		if(edificioRest.islResultado()) {
			mav.setViewName(Vistas.getCtEdificioFormulario());
			mav.addObject("objEdificio", objEdificio);
			mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
			mav.addObject("error", edificioRest.getMensaje());
		} else {
			mav.setViewName(Vistas.getCtEdificioConsulta());
			mav.addObject("exito", MensajeExito.getExitoCtEdificioEdita());
			mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
			mav.addObject("edificios", edificioRest.consultaEdificios(2, sessionUsu.getcToken()));
		}
		
		return mav;
		
	}

	@PostMapping(Vistas.CT_EDIFICIO_BORRA_R)	
	public @ResponseBody String borra(@ModelAttribute("Usuario") ULogin sessionUsu,
			@ModelAttribute("ID") Integer iIDEdificio) {
		
		edificioRest.borraEdificio(iIDEdificio, sessionUsu.getcUsuario(), sessionUsu.getcToken());
		
		if(edificioRest.islResultado()) {
			return edificioRest.getMensaje();
		} 
		
		return "success";
	}

}
