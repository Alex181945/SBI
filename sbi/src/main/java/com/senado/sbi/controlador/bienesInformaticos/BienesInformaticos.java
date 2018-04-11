package com.senado.sbi.controlador.bienesInformaticos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.seg.login.ULogin;

@Controller
public class BienesInformaticos 
{

	@GetMapping("/bienesInformaticos") 
	public String bienesInformaticos(@ModelAttribute("Usuario") ULogin sessionUsu) 
	{
		return Vistas.getbieninformatico();
		
	}
}
