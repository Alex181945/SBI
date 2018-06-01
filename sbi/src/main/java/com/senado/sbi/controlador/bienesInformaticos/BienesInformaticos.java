package com.senado.sbi.controlador.bienesInformaticos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.seg.login.ULogin;

@Controller
@SessionAttributes("Usuario")
public class BienesInformaticos {
	
	@GetMapping(Vistas.BI_R)
	public String Consulta(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getBiConsultar();
	}
	public String Editar(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getBiEditar();
	}
	public String Inserta(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getBiInsertar();
	}
	public String Deshabilitar(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getBiDeshabilitar();
	}

}
