package com.produtos.ArquiteturaHexagonal.core.shared.exceptions;

public class AccessDeniedException extends RuntimeException{

    public AccessDeniedException(String msg) {
        super(msg);
    }
}
