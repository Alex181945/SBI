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
		return cargaDatos(sessionUsu, "", "");
	}
	
	@GetMapping(Vistas.CT_ESTATUS_TICKET_FORMULARIO_R)
	public ModelAndView formulario(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(Vistas.getCtEstatusTicketFormulario());
		mav.addObject("objEstatusTicket", new EstatusTicketM());
		mav.addObject("lInserta", true);
		mav.addObject("estatusTicketInserta", Vistas.CT_ESTATUS_TICKET_INSERTA_R);
		mav.addObject("estatusTicketConsulta", Vistas.CT_ESTATUS_TICKET_CONSULTA_R);
		
		return mav;
	}
	
	@PostMapping(Vistas.CT_ESTATUS_TICKET_INSERTA_R)
	public ModelAndView inserta(@ModelAttribute("Usuario") ULogin sessionUsu,
			@ModelAttribute("objEstatusTicket") EstatusTicketM objEstatusTicketM) {
		
		ModelAndView mav = new ModelAndView();
		
		objEstatusTicketM.setcUsuario(sessionUsu.getcUsuario());
		estatusTicketRest.insertaEstatusTicket(objEstatusTicketM, sessionUsu.getcToken());
		
		if(estatusTicketRest.islResultado()) {
			mav.setViewName(Vistas.getCtEstatusTicketFormulario());
			mav.addObject("objEstatusTicket", objEstatusTicketM);
			mav.addObject("error", estatusTicketRest.getMensaje());
			mav.addObject("lInserta", true);
			mav.addObject("estatusTicketConsulta", Vistas.CT_ESTATUS_TICKET_CONSULTA_R);
		} else {
			mav = cargaDatos(sessionUsu, MensajeExito.getExitoCtEstatusticketsInserta(), "");
		}		

		return mav;
	}

	@GetMapping(Vistas.CT_ESTATUS_TICKET_CONSULTA_UNO_R)
	public ModelAndView consultaUno(@ModelAttribute("Usuario") ULogin sessionUsu,
			@ModelAttribute("iIDEstado") Integer iIDEstado) {
		
		ModelAndView mav = new ModelAndView();		
		mav.addObject("objEstatusTicket", estatusTicketRest.consultaEstatusTicket(iIDEstado, sessionUsu.getcToken()));
		if(estatusTicketRest.islResultado()) {
			mav = cargaDatos(sessionUsu, "", estatusTicketRest.getMensaje());
		}else {
			mav.setViewName(Vistas.getCtEstatusTicketFormulario());
			mav.addObject("lInserta", false);
			mav.addObject("estatusTicketActualiza", Vistas.CT_ESTATUS_TICKET_EDITA_R);
			mav.addObject("estatusTicketConsulta", Vistas.CT_ESTATUS_TICKET_CONSULTA_R);
		}

		return mav;
	}
	
	@PostMapping(Vistas.CT_ESTATUS_TICKET_EDITA_R)
	public ModelAndView edita(@ModelAttribute("Usuario") ULogin sessionUsu,
			@ModelAttribute("objEstatusTicket") EstatusTicketM objEstatusTicketM, 
			@ModelAttribute("activo") String lActivo) {
		
		ModelAndView mav = new ModelAndView();
		
		objEstatusTicketM.setcUsuario(sessionUsu.getcUsuario());
		objEstatusTicketM.setlActivo(lActivo.equals("on") ? 1 : 0);
		estatusTicketRest.actualizaEstatusTicket(objEstatusTicketM, sessionUsu.getcToken());
		if(estatusTicketRest.islResultado()) {
			mav.setViewName(Vistas.getCtEstatusTicketFormulario());
			mav.addObject("objEstatusTicket", objEstatusTicketM);
			mav.addObject("error", estatusTicketRest.getMensaje());
		} else {
			mav = cargaDatos(sessionUsu, MensajeExito.getExitoCtEstatusticketsEdita(), "");
		}
		
		return mav;
		
	}

	@PostMapping(Vistas.CT_ESTATUS_TICKET_BORRA_R)	
	public @ResponseBody String borra(@ModelAttribute("Usuario") ULogin sessionUsu,
			@ModelAttribute("ID") Integer iIDEdificio) {
		
		estatusTicketRest.borraEstatusTicket(iIDEdificio, sessionUsu.getcUsuario(), sessionUsu.getcToken());
		
		if(estatusTicketRest.islResultado()) {
			return estatusTicketRest.getMensaje();
		} 
		
		return "success";
	}
	
	/*Metodo para evitar los redirect y poder cargar los mensajes de exito o error*/
	public ModelAndView cargaDatos(@ModelAttribute("Usuario") ULogin sessionUsu, String mensajeExito,
			String mensajeError) {

		ModelAndView mav = new ModelAndView();

		/*Vista de la tabla de los catalogos*/
		mav.setViewName(Vistas.getCtEstatusTicketConsulta());

		/*Consulta los registros de catalogo*/
		mav.addObject("estatusTicket", estatusTicketRest.consultaEstatusTicketes(2, sessionUsu.getcToken()));
		if (estatusTicketRest.islResultado()) {
			mav.addObject("error", estatusTicketRest.getMensaje());
		}
				
		/*Captura y manda en caso de existir los mensajes de exito o erro*/
		if(mensajeExito != "" || mensajeExito != null) {
			mav.addObject("exito", mensajeExito);
		}
		if(mensajeError != "" || mensajeError != null) {
			mav.addObject("error", mensajeError);
		}

		/*Manda las ligas para acceder a los formularios de inseta, edita y eliminar registro*/
		mav.addObject("formInsertaEstatusTicket", Vistas.CT_ESTATUS_TICKET_FORMULARIO_R);
		mav.addObject("formActualizaEstatusTicket", Vistas.CT_ESTATUS_TICKET_CONSULTA_UNO_R);
		mav.addObject("eliminarEstatusTicket", Vistas.CT_ESTATUS_TICKET_BORRA_R);

		return mav;
	}

}
