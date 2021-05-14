package br.com.aaefl.pfm.midias.core.service.exception;

public class ObjectAlreadyExistsException extends Exception {
    public ObjectAlreadyExistsException(String msg){
        super(msg);
    }

    public ObjectAlreadyExistsException(String msg, Throwable cause){
        super(msg, cause);
    }
}
