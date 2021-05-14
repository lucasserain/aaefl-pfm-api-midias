package br.com.aaefl.pfm.midias.core.model;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuarioVideoAulaPK;
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

public class UsuarioVideoAula {

    private String codVideo;

    private String codAluno;

    private String codAula;

}
