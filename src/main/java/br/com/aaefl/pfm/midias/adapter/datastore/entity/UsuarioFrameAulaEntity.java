package br.com.aaefl.pfm.midias.adapter.datastore.entity;

import br.com.aaefl.pfm.midias.core.model.Frames;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="TBPFM08_RLMT_USUA_FRAME_AULA")
@IdClass(UsuarioFrameAulaPK.class)
public class UsuarioFrameAulaEntity implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @Column(name="cod_frame")
    private String codFrame;

    @Id
    @Column(name="cod_aluno")
    private String codAluno;

    @Id
    @Column(name="cod_aula")
    private String codAula;

    @Column(name="ind_frame")
    private Integer indiceFrame;

    @Column(name="dat_alte")
    private LocalDateTime dataAlteracao;
}
