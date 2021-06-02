package br.com.aaefl.pfm.midias.core.model;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disciplina {

    String codDisciplina;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=80, message = "O tamanho deve ser entre 5 e 80 caracteres ")
    String nomeDisciplina;
    String codProfessor;
    @Length(min=5, max=255, message = "O tamanho deve ser entre 5 e 255 caracteres ")
    String descricao;
    String urlFundo;

}
