package com.produtos.ArquiteturaHexagonal.core.shared.DTO.product;

public record PutProductClient(
        Long id,
        String nome,
        Double preco,
        Integer quantidade) {
}
