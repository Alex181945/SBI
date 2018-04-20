package com.senado.sbi.controlador.seg.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.senado.sbi.configuracion.Vistas;

@Controller
public class LDAP {
	
	@GetMapping("/inicialdap")
	public String loginLdap() {
		System.out.println("Entro en LDAP");
		return Vistas.getLoginldap();
	}
	
	/*@PostMapping("/login")
	public String redirectMenuInicio() {
		return Vistas.getRedirectMenuprincipal();
	}*/
	
	
}
