package com.produtos.ArquiteturaHexagonal.externals.exceptions;

import com.produtos.ArquiteturaHexagonal.core.shared.DTO.handler.StandardError;
import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.AccessDeniedException;
import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.InternalErrorException;
import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.ProductNotSaveClientNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotSaveClientNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ProductNotSaveClientNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError(
                LocalDateTime.now(),
                404,
                "Recurso não encontrado",
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(404).body(err);
    }


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<StandardError> accessDenied(AccessDeniedException e, HttpServletRequest request) {
        StandardError err = new StandardError(
                LocalDateTime.now(),
                403,
                "Acesso Negado",
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(403).body(err);
    }

    @ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<StandardError> internalError(InternalErrorException e, HttpServletRequest request) {
        StandardError err = new StandardError(
                LocalDateTime.now(),
                500,
                "Internal Server Error",
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(500).body(err);
    }
}
