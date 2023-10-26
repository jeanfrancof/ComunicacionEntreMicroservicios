package com.sacavix.eventos;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Evento <T> {
    private String identidad;
    private Date fecha;
    private TipoDeEvento tipo;
    private T datos;
}
