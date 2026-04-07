package com.produtos.ArquiteturaHexagonal.externals.controllers;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.product.SaveProductClient;

import com.produtos.ArquiteturaHexagonal.core.shared.usecase.IProductUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salvar")
public class SalvarProdutoController {

    private final IProductUseCase<SaveProductClient, Produto> saveProductClientProduct;

    public SalvarProdutoController(IProductUseCase<SaveProductClient, Produto> saveProductClientProduct) {

        this.saveProductClientProduct = saveProductClientProduct;
    }

    @PostMapping("/{id}")

    public ResponseEntity<Produto> salvarProduto(@PathVariable Long id, @RequestBody Produto dadosProduto){
        SaveProductClient entrada = new SaveProductClient(id,dadosProduto.getNome(),dadosProduto.getPreco(),dadosProduto.getQuantidade());
        Produto prodSalvo = saveProductClientProduct.executar(entrada);
        return ResponseEntity.ok(prodSalvo);
    }
}
