package com.sacavix.eventos;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public abstract class Evento<T> {
    private String id;
    private Date date;
    private TipoEvento type;
    private T data;
}
