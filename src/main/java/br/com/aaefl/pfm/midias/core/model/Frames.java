package br.com.aaefl.pfm.midias.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class Frames implements Serializable {
    private static final long serialVersion = 1L;

    private String idFrame;

    private String urlFrame;

    private LocalDateTime dataCriacao;

    private LocalTime tempoFrame;

    private String emocao;
}
