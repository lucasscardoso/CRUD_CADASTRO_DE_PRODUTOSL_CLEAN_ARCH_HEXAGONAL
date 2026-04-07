package com.produtos.ArquiteturaHexagonal.externals.controllers;

import com.produtos.ArquiteturaHexagonal.externals.db.ProductDbAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deletar")
public class DeletaProdutoController {

    @Autowired
    private final ProductDbAdapter productDbAdapter;

    public DeletaProdutoController(ProductDbAdapter productDbAdapter) {
        this.productDbAdapter = productDbAdapter;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaPorId(@PathVariable Long id){
        productDbAdapter.deletar(id);
        return ResponseEntity.ok("Deletado com Sucesso!");
    }
}
