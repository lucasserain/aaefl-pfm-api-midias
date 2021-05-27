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
@Table(name="TBPFM08_RLMT_FRAMES_VIDEO")
@IdClass(VideoFramesPK.class)
public class VideoFramesEntity implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @Column(name="cod_video")
    private String codVideo;

    @Id
    @Column(name="cod_frame")
    private String codFrame;
}
