package com.produtos.ArquiteturaHexagonal.core.product.service;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;
import com.produtos.ArquiteturaHexagonal.core.product.repository.externalrepository.UserExternalRepository;
import com.produtos.ArquiteturaHexagonal.core.product.repository.product.ProductRepository;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.external.UserDto;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.product.SaveProductClient;
import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.FindProductException;
import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.InternalErrorException;
import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.ProductNotSaveClientNotFoundException;
import com.produtos.ArquiteturaHexagonal.core.shared.usecase.IProductUseCase;

import java.util.Optional;

public class BuscaProduto implements IProductUseCase<SaveProductClient, Produto> {

    private final ProductRepository prodRepo;

    public BuscaProduto(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    @Override
    public Produto executar(SaveProductClient entrada) {


           Optional<Produto> encontrado = prodRepo.buscaPorId(entrada.id());
           if(encontrado.isEmpty()){
               throw  new FindProductException("produto com id: %d" + entrada.id() + "não localizado!");
           }

           Produto result = new Produto();
            result.setId(encontrado.get().getId());
            result.setNome(encontrado.get().getNome());
            result.setPreco(encontrado.get().getPreco());
            result.setQuantidade(encontrado.get().getQuantidade());
            result.setClienteId(encontrado.get().getClienteId());

        return result;
    }
}
