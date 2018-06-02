package com.senado.sbi.controlador.bienesinformaticos;

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
public class BienesInformaticos {
	
	@Autowired
	private MenuRest menuRest;
	
	@GetMapping(Vistas.BI_CONSULTAR_R)
	public ModelAndView Consulta(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		/*Consulta del menu*/
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sessionUsu.getiPerfil());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getBiConsultar());
		mav.addObject("titulo", "Registrar");
		mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
		
		return mav;
	}
	
	@GetMapping(Vistas.BI_EDITA_R)
	public String Editar(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getBiEditar();
	}
	
	@GetMapping(Vistas.BI_INSERTAR_R)
	public String Inserta(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getBiInsertar();
	}
	
	@GetMapping(Vistas.BI_DESHABILITAR_R)
	public String Deshabilitar(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getBiDeshabilitar();
	}

}
