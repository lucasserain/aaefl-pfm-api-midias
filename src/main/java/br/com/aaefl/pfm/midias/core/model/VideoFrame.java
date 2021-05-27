package br.com.aaefl.pfm.midias.core.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class VideoFrame {

    private String codVideo;

    private String codFrame;
}
