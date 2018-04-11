package com.senado.sbi.controlador.editarSABI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.seg.login.ULogin;

public class editarSABI {
	@GetMapping("/editarSABI") 
	public String editabienesInformaticos(@ModelAttribute("Usuario") ULogin sessionUsu) 
	{
		return Vistas.geteditarSabi();
		
	}

}
