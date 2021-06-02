package br.com.aaefl.pfm.midias.core.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDisciplina {
    String codAluno;
    String codDisciplina;
}
