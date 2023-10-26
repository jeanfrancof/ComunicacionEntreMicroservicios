package com.sacavix.eventos;

import com.sacavix.entidad.Usuario;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EventoCreadoUsuario extends Evento<Usuario> {

}
