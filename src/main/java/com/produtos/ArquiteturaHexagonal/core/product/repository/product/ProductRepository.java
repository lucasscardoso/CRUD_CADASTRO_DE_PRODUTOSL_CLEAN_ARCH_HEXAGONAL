package com.produtos.ArquiteturaHexagonal.core.product.repository.product;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;

import java.util.Optional;

public interface ProductRepository {

    Produto salvar(Produto produto);
    Optional<Produto> buscaPorId(Long id);
    void deletar(Long id);
    Produto altera(Produto produto ,Long id);
}
