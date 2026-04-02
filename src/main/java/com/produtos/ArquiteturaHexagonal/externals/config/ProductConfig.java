package com.produtos.ArquiteturaHexagonal.externals.config;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;
import com.produtos.ArquiteturaHexagonal.core.product.repository.externalrepository.UserExternalRepository;
import com.produtos.ArquiteturaHexagonal.core.product.repository.product.ProductRepository;
import com.produtos.ArquiteturaHexagonal.core.product.service.SalvarProduto;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.product.SaveProductClient;
import com.produtos.ArquiteturaHexagonal.core.shared.usecase.IProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public IProductUseCase<SaveProductClient, Produto> salvarProdutoUseCase(ProductRepository productRepository, UserExternalRepository userExternalRepository){
        return new SalvarProduto(productRepository, userExternalRepository);
    }
}
