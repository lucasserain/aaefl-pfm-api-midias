package br.com.aaefl.pfm.midias.adapter.datastore.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UsuarioVideoAulaPK implements Serializable {
    private static final long serialVersion = 1L;


    @Column(name="cod_video")
    private String codVideo;


    @Column(name="cod_usua")
    private String codAluno;


    @Column(name="cod_aula")
    private String codAula;

}
