package br.com.aaefl.pfm.midias.adapter.datastore.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="TBPFM01_USUA")
public class UsuariosEntity implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @Column(name="cod_usua")
    private String codUsuario;

    @Column(name="nome")
    String nome;

    @Column(name="email")
    String email;

    @Column(name="cod_tipo_usua")
    Integer tipoUsuario;

    @Column(name="dt_cria")
    LocalDateTime dataCriacao;

    @Column(name="dt_alte")
    LocalDateTime dataAlteracao;

    @Column(name="avatar")
    String urlAvatar;
}
