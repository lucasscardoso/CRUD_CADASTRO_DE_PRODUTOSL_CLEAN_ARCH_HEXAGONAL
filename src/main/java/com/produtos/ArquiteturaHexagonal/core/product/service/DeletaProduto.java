package com.produtos.ArquiteturaHexagonal.core.product.service;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;
import com.produtos.ArquiteturaHexagonal.core.product.repository.product.ProductRepository;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.product.SaveProductClient;
import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.FindProductException;
import com.produtos.ArquiteturaHexagonal.core.shared.usecase.IProductUseCase;

import java.util.Optional;

public class DeletaProduto implements IProductUseCase<SaveProductClient, String> {

    private final ProductRepository prodRepo;

    public DeletaProduto(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    @Override
    public String executar(SaveProductClient entrada) {


           Optional<Produto> encontrado = prodRepo.buscaPorId(entrada.id());
           if(encontrado.isEmpty()){
               throw  new FindProductException("produto com id: %d" + entrada.id() + "não localizado!");
           }

           prodRepo.deletar(entrada.id());

        return "Produto com id: %d Deletado com sucesso" + entrada.id();
    }
}
