package com.produtos.ArquiteturaHexagonal.externals.repository;

import com.produtos.ArquiteturaHexagonal.externals.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository extends JpaRepository<ProdutoEntity,Long> {

}
