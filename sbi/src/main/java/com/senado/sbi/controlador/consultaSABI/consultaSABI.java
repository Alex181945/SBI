package com.senado.sbi.controlador.consultaSABI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.seg.login.ULogin;

public class consultaSABI 
{
	@GetMapping("/consultaSABI") 
	public String consultabienesInformaticos(@ModelAttribute("Usuario") ULogin sessionUsu) 
	{
		return Vistas.getconsultaSabi();
		
	}
}
