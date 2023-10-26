package com.sacavix.servicios;

import com.sacavix.entidad.Cliente;
import com.sacavix.entidad.Usuario;
import com.sacavix.eventos.UsuarioEventoCreado;
import com.sacavix.eventoEvento;
import com.sacavix.eventos.TipoDeEvento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class ServicioEventosUsuario {
	
	@Autowired
	private KafkaTemplate<String, Evento<?>> publicador;
	
	@Value("${topic.customer.name:customers}")
	private String temaUsuario;
	
	public void publicar(Usuario usuario) {

		
	    UsuarioEventoCreado creado = new UsuarioEventoCreado();	creado.setData(usuario);
		creado.setId(UUID.randomUUID().toString());
		creado.setType(TipoDeEvento.CREATED);
		creado.setDate(new Date());

		this.publicador.send(temaUsuario, creado);
	}
	
	

}
