package com.senado.sbi.controlador.ct.estatusticket;

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
import com.senado.sbi.modelo.ct.EstatusTicketM;
import com.senado.sbi.modelo.datos.consulta.DosParametrosEnteros;
import com.senado.sbi.modelo.seg.login.ULogin;
import com.senado.sbi.rest.ct.EstatusTicketRest;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 18/05/2018
 * Descripcion: Controlador para el catalogo de edificios
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 * 
 */


@Controller
@SessionAttributes("Usuario")
public class EstatusTicket {
	
	@Autowired
	private EstatusTicketRest estatusTicketRest;
	
	@GetMapping(Vistas.CT_ESTATUS_TICKET_CONSULTA_R)
	public ModelAndView consultaTodos(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(Vistas.getCtEstatusTicketConsulta());
		
		mav.addObject("estatusTicket", estatusTicketRest.consultaEstatusTicketes(2, sessionUsu.getcToken()));
		if(estatusTicketRest.islResultado()) {
			mav.addObject("error", estatusTicketRest.getMensaje());
		}
		
		mav.addObject("formInsertaEstatusTicket", Vistas.CT_ESTATUS_TICKET_INSERTA_R);
		mav.addObject("formActualizaEstatusTicket", Vistas.CT_ESTATUS_TICKET_EDITA_R);
		
		return mav;
	}
	
	@GetMapping(Vistas.CT_ESTATUS_TICKET_FORMULARIO_R)
	public ModelAndView formulario(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	@PostMapping(Vistas.CT_ESTATUS_TICKET_INSERTA_R)
	public ModelAndView inserta(@ModelAttribute("Usuario") ULogin sessionUsu,
			@ModelAttribute("objEstatusTicket") EstatusTicketM objEstatusTicketM) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getCtEstatusTicketFormulario());
		//mav.addObject("estatusTicket", attributeValue)

		return mav;
	}

	@GetMapping(Vistas.CT_ESTATUS_TICKET_CONSULTA_UNO_R)
	public ModelAndView consultaUno(@ModelAttribute("Usuario") ULogin sessionUsu,
			@ModelAttribute("iIDEstado") Integer iIDEstado) {
		
		ModelAndView mav = new ModelAndView();

		return mav;
	}
	
	@PostMapping(Vistas.CT_ESTATUS_TICKET_EDITA_R)
	public ModelAndView edita(@ModelAttribute("Usuario") ULogin sessionUsu,
			@ModelAttribute("objEstatusTicket") EstatusTicketM objEstatusTicketM, 
			@ModelAttribute("activo") String lActivo) {
		
		ModelAndView mav = new ModelAndView();
		
		return mav;
		
	}

	@PostMapping(Vistas.CT_ESTATUS_TICKET_BORRA_R)	
	public @ResponseBody String borra(@ModelAttribute("Usuario") ULogin sessionUsu,
			@ModelAttribute("ID") Integer iIDEdificio) {
		
		
		return null;
	}

}
