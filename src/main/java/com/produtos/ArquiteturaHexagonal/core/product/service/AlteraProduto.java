package com.produtos.ArquiteturaHexagonal.core.product.service;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;
import com.produtos.ArquiteturaHexagonal.core.product.repository.product.ProductRepository;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.product.PutProductClient;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.product.SaveProductClient;
import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.FindProductException;
import com.produtos.ArquiteturaHexagonal.core.shared.usecase.IProductAlterUseCase;
import com.produtos.ArquiteturaHexagonal.core.shared.usecase.IProductUseCase;

import java.util.Optional;

public class AlteraProduto implements IProductAlterUseCase<SaveProductClient, Produto> {

    private final ProductRepository prodRepo;

    public AlteraProduto(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    @Override
    public Produto executar(SaveProductClient entrada) {

        Optional<Produto> encontrado = prodRepo.buscaPorId(entrada.id());
        if(encontrado.isEmpty()){
            throw  new FindProductException("produto com id: %d" + entrada.id() + "não localizado!");
        }


        Produto produtoLocalizado = encontrado.get();
        produtoLocalizado.setId(encontrado.get().getId());
        produtoLocalizado.setNome(entrada.nome());
        produtoLocalizado.setQuantidade(entrada.quantidade());
        produtoLocalizado.setPreco(entrada.preco());

        return prodRepo.altera(produtoLocalizado,produtoLocalizado.getId());
    }

}
