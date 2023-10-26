package com.sacavix.servicios;
import org.springframework.stereotype.Service;

import com.sacavix.entidad.Usuario;

@Service
public class ServicioUsuario {
	
	private final ServicioEventosUsuario servicioEventosUsuario;

	public ServicioUsuario(ServicioEventosUsuario servicioEventosUsuario) {
		super();
		this.servicioEventosUsuario = servicioEventosUsuario;
	}

	public Usuario guardar(Usuario usuario) {
		System.out.println("Aceptado " + usuario);
		this.servicioEventosUsuario.publicar(usuariosuario);
		return usuario;
		
	}

}
