package br.com.aaefl.pfm.midias.adapter.datastore.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="TBPFM07_AULAS")
public class AulaEntity {

    @Id
    @Column(name="cod_aula")
    String codAula;

    @Column(name="cod_disci")
    String codDisciplina;

    @Column(name="hora_inicio")
    LocalDateTime inicioAula;

    @Column(name="hora_final")
    LocalDateTime finalAula;

    @Column(name="duracao")
    String duracaoAula;

    @Column(name="dt_cria")
    LocalDateTime dataCriacao;

    @Column(name="dt_alte")
    LocalDateTime dataAlteracao;

    @Column(name="url_video")
    String urlVideo;

    @Column(name="nome_aula")
    String nomeAula;

    @Column(name="desc_aula")
    String descricao;
}
