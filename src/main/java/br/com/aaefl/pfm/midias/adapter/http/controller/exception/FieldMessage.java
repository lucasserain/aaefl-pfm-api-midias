package br.com.aaefl.pfm.midias.adapter.http.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FieldMessage {

    private String fieldName;
    private String message;


}
