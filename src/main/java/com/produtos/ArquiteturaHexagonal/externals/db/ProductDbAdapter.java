package com.produtos.ArquiteturaHexagonal.externals.db;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;
import com.produtos.ArquiteturaHexagonal.core.product.repository.product.ProductRepository;
import com.produtos.ArquiteturaHexagonal.externals.entity.ProdutoEntity;
import com.produtos.ArquiteturaHexagonal.externals.interfaces.IUserExternalApi;
import com.produtos.ArquiteturaHexagonal.externals.repository.SpringDataProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void deletar(Long id) {
        springDataProductRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Produto altera(Produto produto, Long id) {

        ProdutoEntity entidadeExiste = springDataProductRepository.findById(id).orElseThrow(() -> new RuntimeException("nao encontrado"));
        entidadeExiste.setNome(produto.getNome());
        entidadeExiste.setPreco(produto.getPreco());
        entidadeExiste.setQuantidade(produto.getQuantidade());
        springDataProductRepository.save(entidadeExiste);
        return entidadeExiste.toDomain();
//
//        ProdutoEntity salvar = ProdutoEntity.fromDomain(produto);
//        salvar.setId(id);
//        ProdutoEntity atualizado = springDataProductRepository.save(salvar);
//
//        return atualizado.toDomain();
    }



}
