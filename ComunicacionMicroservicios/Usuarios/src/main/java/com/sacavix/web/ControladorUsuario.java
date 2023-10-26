package com.sacavix.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacavix.entidad.Cliente;
import com.sacavix.entidad.Usuario;
import com.sacavix.servicios.ServicioUsuario;

@RestController
@RequestMapping("/customers")
public class ControladorUsuario {
	
	private final ServicioUsuario servicioUsuario;

	public ControladorUsuario(ServicioUsuario servicioUsuario) {
		super();
		this.servicioUsuario = servicioUsuario;
	}
	
	@PostMapping
	public Usuario guardar(@RequestBody Usuario usuario) {
		return this.servicioUsuario.guardar(usuario);
	}
	

}
