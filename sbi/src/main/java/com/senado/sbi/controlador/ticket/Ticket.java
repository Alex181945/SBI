package com.senado.sbi.controlador.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.datos.consulta.DosParametrosEnteros;
import com.senado.sbi.modelo.op.ticket.TicketM;
import com.senado.sbi.modelo.seg.login.ULogin;
import com.senado.sbi.rest.ct.EdificioRest;
import com.senado.sbi.rest.ct.FormaSolicitudRest;
import com.senado.sbi.rest.ct.SrvSolicitadoRest;
import com.senado.sbi.rest.ct.TipoServicioRest;
import com.senado.sbi.rest.modulo.menu.MenuRest;
import com.senado.sbi.rest.op.ticket.TicketRest;

@Controller
@SessionAttributes("Usuario")
public class Ticket {
	
	@Autowired
	private MenuRest menuRest;
	@Autowired
	private TicketRest ticketRest;
	@Autowired
	private EdificioRest edificioRest;
	@Autowired
	private TipoServicioRest tiposervicioRest;
	@Autowired
	private FormaSolicitudRest formasolicitudRest;
	@Autowired
	private SrvSolicitadoRest srvsolicitadoRest;
	
	@GetMapping(Vistas.TICKET_R)
	public ModelAndView inicio(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		/*Consulta del menu*/
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sessionUsu.getiPerfil());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getTicketIncidencia());
		mav.addObject("titulo", "Ticket");
		mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
		mav.addObject("edificios", edificioRest.consultaEdificios(1, sessionUsu.getcToken()));
		mav.addObject("tiposervicio",tiposervicioRest.consultaTipoServicios1(1, sessionUsu.getcToken()));
		mav.addObject("formasolicitud", formasolicitudRest.consultaFormaSolicitudes(1, sessionUsu.getcToken()));
		mav.addObject("srvsolicitado", srvsolicitadoRest.consultaSrvSolicitados(1, sessionUsu.getcToken()));
		mav.addObject("Ticket", new TicketM());
		return mav;
	}
	
	@GetMapping(Vistas.TICKET_ASIGNACION_R)
	public ModelAndView asignacion(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sessionUsu.getiPerfil());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getTicketAsignacion());
		mav.addObject("titulo", "Ticket");
		mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
		mav.addObject("Ticket", new TicketM());
		return mav;
	}
	
	@PostMapping(Vistas.TICKET_INSERTA_R)
	public ModelAndView creaTicket(@ModelAttribute("Usuario") ULogin sessionUsu, @ModelAttribute("Ticket") TicketM ticket) {
		
		System.out.println(ticket.toString());
		ticketRest.insertaTicket(ticket, sessionUsu.getcToken());

		return null;
	}
	

}
