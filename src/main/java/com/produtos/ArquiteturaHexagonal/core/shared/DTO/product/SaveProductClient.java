package com.produtos.ArquiteturaHexagonal.core.shared.DTO.product;

public record SaveProductClient(
        Long id,
        String nome,
        Double preco,
        Integer quantidade) {
}
