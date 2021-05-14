package br.com.aaefl.pfm.midias.core.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioFrameAula {

    private String codFrame;

    private String codAluno;

    private String codAula;

    private Integer indiceFrame;

    private LocalDateTime dataAlteracao;

}
