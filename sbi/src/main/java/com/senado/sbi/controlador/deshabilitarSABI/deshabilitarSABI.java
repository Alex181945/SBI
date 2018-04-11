package com.senado.sbi.controlador.deshabilitarSABI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.seg.login.ULogin;

public class deshabilitarSABI 
{
	@GetMapping("/deshabilitarSABI") 
	public String deshabilitarbienesInformaticos(@ModelAttribute("Usuario") ULogin sessionUsu) 
	{
		return Vistas.getdeshabilitaSabi();
		
	}
}
