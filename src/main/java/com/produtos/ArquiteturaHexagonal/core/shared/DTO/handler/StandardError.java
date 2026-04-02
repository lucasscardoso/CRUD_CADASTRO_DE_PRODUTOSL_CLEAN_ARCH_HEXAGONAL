package com.produtos.ArquiteturaHexagonal.core.shared.DTO.handler;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record StandardError(
                            @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                            LocalDateTime timestamp,
                            Integer status,
                            String error,
                            String message,
                            String path) {
}
