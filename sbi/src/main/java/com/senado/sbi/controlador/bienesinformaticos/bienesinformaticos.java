package com.senado.sbi.controlador.bienesinformaticos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.seg.login.ULogin;

public class bienesinformaticos {
	@GetMapping("/bienesinformaticos")
	public String Consulta(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getRedirectConsulta();
	}
	public String Editar(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getRedirectEditar();
	}
	public String Inserta(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getRedirectInserta();
	}
	public String Deshabilitar(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getRedirectDeshabilitar();
	}

}
