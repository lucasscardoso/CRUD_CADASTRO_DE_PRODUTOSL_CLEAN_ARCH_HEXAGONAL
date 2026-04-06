package com.produtos.ArquiteturaHexagonal.externals.db;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;
import com.produtos.ArquiteturaHexagonal.core.product.repository.product.ProductRepository;
import com.produtos.ArquiteturaHexagonal.externals.entity.ProdutoEntity;
import com.produtos.ArquiteturaHexagonal.externals.interfaces.IUserExternalApi;
import com.produtos.ArquiteturaHexagonal.externals.repository.SpringDataProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductDbAdapter implements ProductRepository {

    private final SpringDataProductRepository springDataProductRepository;


    public ProductDbAdapter(SpringDataProductRepository springDataProductRepository) {
        this.springDataProductRepository = springDataProductRepository;

    }

    @Override
    public Produto salvar(Produto produto) {
        ProdutoEntity entity = ProdutoEntity.fromDomain(produto);
        ProdutoEntity salvar = springDataProductRepository.save(entity);

        return salvar.toDomain();
    }

    @Override
    public Optional<Produto> buscaPorId(Long id) {

       Optional<Produto> produto =  springDataProductRepository.findById(id).map(entity -> entity.toDomain());

        return produto;
    }


}
