package br.com.aaefl.pfm.midias.core.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {

    String codUsuario;
    String nome;
    String email;
    Integer tipoUsuario;
    LocalDateTime dataCriacao;
    LocalDateTime dataAlteracao;
    String urlAvatar;


}
