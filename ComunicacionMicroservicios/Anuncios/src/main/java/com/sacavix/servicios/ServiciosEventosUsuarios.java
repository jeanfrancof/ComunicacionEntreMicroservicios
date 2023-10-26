package com.sacavix.servicios;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.sacavix.eventos.EventoCreadoCliente;
import com.sacavix.eventos.Evento;

@Slf4j
@Component
public class ServiciosEventosUsuarios {

	@KafkaListener(topics = "${topic.customer.name:customers}", containerFactory = "kafkaListenerContainerFactory", groupId = "grupo1")
	public void consumer(Evento<?> event) {
		if (event.getClass().isAssignableFrom(EventoCreadoCliente.class)) {
			EventoCreadoCliente eventoCreadoCliente = (EventoCreadoCliente) event;
			log.info("Aceptado, Evento del cliente creado satisfactoriamente cuya identidad={}, data={}",
					eventoCreadoCliente.getId(),
					eventoCreadoCliente.getData().toString());
		}
	}
}
