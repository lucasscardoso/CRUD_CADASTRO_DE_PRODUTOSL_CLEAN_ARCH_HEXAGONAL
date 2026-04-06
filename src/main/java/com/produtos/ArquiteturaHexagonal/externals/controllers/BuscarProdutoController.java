package com.produtos.ArquiteturaHexagonal.externals.controllers;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;
import com.produtos.ArquiteturaHexagonal.externals.db.ProductDbAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/busca")
public class BuscarProdutoController {

    @Autowired
    private ProductDbAdapter productDbAdapter;

    public BuscarProdutoController(ProductDbAdapter productDbAdapter) {
        this.productDbAdapter = productDbAdapter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable Long id){
        return productDbAdapter.buscaPorId(id).map(produto -> ResponseEntity.ok(produto)).orElse(ResponseEntity.notFound().build());

    }
}
