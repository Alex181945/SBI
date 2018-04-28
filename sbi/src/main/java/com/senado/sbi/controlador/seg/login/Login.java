package com.senado.sbi.controlador.seg.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.senado.sbi.configuracion.Vistas;
import com.senado.sbi.modelo.seg.login.UsuarioTemp;
import com.senado.sbi.rest.seg.login.LoginRest;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 09/03/2018
 * Descripcion: Controlador para el inicio de sesion
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 * 
 */


@Controller
public class Login {
	
	@Autowired
	private LoginRest loginRest;
	
	@GetMapping(Vistas.RAIZ)
	public String redirectLogin() {
		return Vistas.getRedirectLogin();
	}
	
	@GetMapping(Vistas.LOGIN_R)
	public String login() {
		return Vistas.getLogin();
	}
	
	@PostMapping(Vistas.VALIDAUSU_R)
	public String validaUsuario(@ModelAttribute("usuario") String cUsuario,
			@ModelAttribute("password") String cPassword, Model model, HttpServletRequest request) {
		
		UsuarioTemp objUsuario = new UsuarioTemp();
		objUsuario.setcUsuario(cUsuario);
		objUsuario.setcContrasena(cPassword);
		
		loginRest.validaUsuario(objUsuario);
		
		if(loginRest.islResultado()) {
			model.addAttribute("error", loginRest.getMensaje());
			return Vistas.getLogin();
		}else {
			request.getSession().setAttribute("Usuario", loginRest.getUsuario());
		}
		
		return Vistas.getRedirectMenuprincipal();
	}
	
	@GetMapping(Vistas.LOGOUT_R)
	public String cerrarSesion(HttpServletRequest request) {
		//status.setComplete();
		request.getSession().invalidate();
		return Vistas.getLogin();
	}

}
