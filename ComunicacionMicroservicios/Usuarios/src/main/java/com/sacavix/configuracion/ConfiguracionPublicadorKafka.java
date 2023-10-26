package com.sacavix.configuracion;

import java.util.HashMap;
import java.util.Map;

//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.kafka.core.KafkaAdmin;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.sacavix.eventos.Evento;

@Configuration
public class ConfiguracionPublicadorKafka {
	
	private final String Direccionbootstrap = "localhost:9092";

    @Bean
    public ProducerFactory<String, Evento<?>> producerFactory() {
        Map<String, Object> propiedadConfiguracion = new HashMap<>();
        propiedadConfiguracion.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Direccionbootstrap);
        propiedadConfiguracion.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        propiedadConfiguracion.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(propiedadConfiguracion);
    }

    @Bean
    public KafkaTemplate<String, Evento<?>> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
