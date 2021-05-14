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
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="TBPFM03_VIDEOS")
public class VideosEntity implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @Column(name="cod_video")
    private String idVideo;

    @Column(name="url_video")
    private String urlVideo;

    @Column(name="dt_cria")
    private LocalDateTime dataCriacao;

    @Column(name="temp_video")
    private LocalTime tempoVideo;

}
