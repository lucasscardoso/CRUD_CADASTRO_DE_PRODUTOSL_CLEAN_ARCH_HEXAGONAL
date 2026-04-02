package com.produtos.ArquiteturaHexagonal.core.product.repository.product;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;

public interface ProductRepository {

    Produto salvar(Produto produto);
    Produto buscar(Produto id);
}
