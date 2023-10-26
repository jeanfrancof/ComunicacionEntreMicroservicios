package com.sacavix.configuracion;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.sacavix.eventos.Evento;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ConfiguracionSuscriptorKafka {

    private final String direccionbootstrap = "localhost:9092";

    @Bean
    public ConsumerFactory<String, Evento<?>> consumerFactory() {
        Map<String, String> propiedades = new HashMap<>();
        propiedades.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, direccionbootstrap);
        propiedades.put(JsonSerializer.TYPE_MAPPINGS, "com.sacavix:com.sacavix.events.Event");

        final JsonDeserializer<Evento<?>> jsonDeserializer = new JsonDeserializer<>();
        return new DefaultKafkaConsumerFactory(propiedades, new StringDeserializer(), jsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Evento<?>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Evento<?>> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
