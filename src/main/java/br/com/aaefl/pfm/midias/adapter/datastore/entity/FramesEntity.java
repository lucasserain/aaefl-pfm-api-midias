package br.com.aaefl.pfm.midias.adapter.datastore.entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="TBPFM05_FRAMES")
public class FramesEntity implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @Column(name="cod_frame")
    private String idFrame;

    @Column(name="url_frame")
    private String urlFrame;

    @Column(name="dt_cria")
    private LocalDateTime dataCriacao;

    @Column(name="dt_alte")
    private LocalDateTime dataAlteracao;

    @Column(name="emoc_flux_a")
    private String emocao;
}
