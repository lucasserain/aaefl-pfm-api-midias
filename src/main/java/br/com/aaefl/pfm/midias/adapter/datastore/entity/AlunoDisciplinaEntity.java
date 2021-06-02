package br.com.aaefl.pfm.midias.adapter.datastore.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="TBPFM10_RLMT_ALUNO_DISCI")
@IdClass(AlunoDisciplinaPK.class)
public class AlunoDisciplinaEntity implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @Column(name="cod_usua")
    private String codAluno;

    @Id
    @Column(name="cod_disci")
    private String codDisciplina;
}
