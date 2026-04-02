package com.produtos.ArquiteturaHexagonal.core.product.service;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;
import com.produtos.ArquiteturaHexagonal.core.product.repository.externalrepository.UserExternalRepository;
import com.produtos.ArquiteturaHexagonal.core.product.repository.product.ProductRepository;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.product.SaveProductClient;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.external.UserDto;
import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.InternalErrorException;
import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.ProductNotSaveClientNotFoundException;
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

        try{
        Optional<UserDto> usuario = userExternalRepository.findById(entrada.id());

        if(usuario.isEmpty()){
              throw new ProductNotSaveClientNotFoundException("cliente nao encontrado com id: " + entrada.id());
              }

        Produto novoProduto = new Produto();
        novoProduto.setClienteId(usuario.get().id());
        novoProduto.setNome(entrada.nome());
        novoProduto.setPreco(entrada.preco());
        novoProduto.setQuantidade(entrada.quantidade());

        return prodRepo.salvar(novoProduto);
        } catch (InternalErrorException e) {
            throw new InternalErrorException("Erro Interno,contate o Adminstrador (validar erro productside/Externalside)");
        }
    }
}
