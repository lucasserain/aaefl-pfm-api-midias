package br.com.aaefl.pfm.midias.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aula {
    String codAula;
    String codDisciplina;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone="GMT-3")
    LocalDateTime inicioAula;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone="GMT-3")
    LocalDateTime finalAula;
    Long duracaoAula;
    LocalDateTime dataCriacao;
    LocalDateTime dataAlteracao;
    String urlVideo;
    String nomeAula;
    String descricao;
}
