package com.produtos.ArquiteturaHexagonal.core.shared.DTO;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;

public record SaveProductClient(
        Long id,
        String nome,
        Double preco,
        Integer quantidade) {
}
