package br.com.aaefl.pfm.midias.adapter.datastore.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class VideoFramesPK implements Serializable {
    private static final long serialVersion = 1L;

    @Column(name="cod_video")
    private String codVideo;

    @Column(name="cod_frame")
    private String codFrame;
}
