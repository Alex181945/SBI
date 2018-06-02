package com.senado.sbi.controlador.bienesinformaticos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.seg.login.ULogin;

@Controller
@SessionAttributes("Usuario")
public class BienesInformaticos {
	
	@GetMapping(Vistas.BI_CONSULTAR_R)
	public String Consulta(@ModelAttribute("Usuario") ULogin sessionUsu) {
		
		return Vistas.getBiConsultar();
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
