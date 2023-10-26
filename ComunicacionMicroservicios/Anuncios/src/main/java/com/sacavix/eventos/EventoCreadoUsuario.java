package com.sacavix.eventos;
import com.sacavix.entidad.Cliente;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EventoCreadoUsuario extends Evento<Usuario> {

}
