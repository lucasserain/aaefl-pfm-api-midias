package br.com.aaefl.pfm.midias.adapter.datastore.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="TBPFM04_RLMT_USUA_VIDEO_AULA")
@IdClass(UsuarioVideoAulaPK.class)
public class UsuarioVideoAulaEntity implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @Column(name="cod_video")
    private String codVideo;

    @Id
    @Column(name="cod_usua")
    private String codAluno;

    @Id
    @Column(name="cod_aula")
    private String codAula;

}
