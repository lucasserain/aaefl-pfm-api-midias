package br.com.aaefl.pfm.midias.core.model;
import lombok.*;

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
@Builder
@AllArgsConstructor
public class Videos {

    private String idVideo;

    private String urlVideo;

    private LocalDateTime dataCriacao;

    private LocalTime tempoVideo;

}
