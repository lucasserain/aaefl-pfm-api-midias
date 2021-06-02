package br.com.aaefl.pfm.midias.core.model;

import lombok.*;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aula {
    String codAula;
    String codDisciplina;
    LocalDateTime inicioAula;
    LocalDateTime finalAula;
    Long duracaoAula;
    LocalDateTime dataCriacao;
    LocalDateTime dataAlteracao;
    String urlVideo;
    String nomeAula;
    String descricao;
}
