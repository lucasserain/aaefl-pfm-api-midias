package br.com.aaefl.pfm.midias.adapter.http.controller.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String message, Long timeStamp) {
        super(status, message, timeStamp);
    }

    public void addError(String fieldName, String message){
        errors.add(new FieldMessage(fieldName,message));
    }
}
