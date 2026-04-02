package com.produtos.ArquiteturaHexagonal.core.product.service;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;
import com.produtos.ArquiteturaHexagonal.core.product.repository.externalrepository.UserExternalRepository;
import com.produtos.ArquiteturaHexagonal.core.product.repository.product.ProductRepository;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.SaveProductClient;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.UserDto;
import com.produtos.ArquiteturaHexagonal.core.shared.usecase.IProductUseCase;


import java.util.Optional;

public class SalvarProduto implements IProductUseCase<SaveProductClient, Produto> {

    private final ProductRepository prodRepo;
    private final UserExternalRepository userExternalRepository;

    public SalvarProduto(ProductRepository prodRepo, UserExternalRepository userExternalRepository) {
        this.prodRepo = prodRepo;
        this.userExternalRepository = userExternalRepository;
    }

    @Override
    public Produto executar(SaveProductClient entrada) {

        Optional<UserDto> usuario = userExternalRepository.findById(entrada.id());
        if(usuario.isEmpty()){
            throw new RuntimeException("cliente nao encontrado");
        }


        Produto novoProduto = new Produto();
        novoProduto.setClienteId(usuario.get().id());
        novoProduto.setNome(entrada.nome());
        novoProduto.setPreco(entrada.preco());
        novoProduto.setQuantidade(entrada.quantidade());

        return prodRepo.salvar(novoProduto);
    }
}
