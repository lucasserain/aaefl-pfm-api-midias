package br.com.aaefl.pfm.midias.adapter.datastore.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="TBPFM06_DISCI")
public class DisciplinaEntity {
    @Id
    @Column(name="cod_disci")
    private String codDisciplina;

    @Column(name="nome_disci")
    String nomeDisciplina;

    @Column(name="cod_prof")
    String codProfessor;

    @Column(name="info")
    String descricao;

    @Column(name="url_fundo")
    String urlFundo;
}
