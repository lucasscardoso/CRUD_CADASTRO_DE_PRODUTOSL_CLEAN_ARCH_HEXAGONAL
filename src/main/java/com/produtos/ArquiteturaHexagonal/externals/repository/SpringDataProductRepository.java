package com.produtos.ArquiteturaHexagonal.externals.repository;

import com.produtos.ArquiteturaHexagonal.externals.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataProductRepository extends JpaRepository<ProdutoEntity,Long> {

    @Override
    Optional<ProdutoEntity> findById(Long aLong);
}
