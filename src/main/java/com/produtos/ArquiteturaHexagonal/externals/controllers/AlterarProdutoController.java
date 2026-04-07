package com.produtos.ArquiteturaHexagonal.externals.controllers;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.product.SaveProductClient;
import com.produtos.ArquiteturaHexagonal.core.shared.usecase.IProductAlterUseCase;
import com.produtos.ArquiteturaHexagonal.core.shared.usecase.IProductUseCase;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/alterar")

public class AlterarProdutoController {

    private final IProductAlterUseCase<SaveProductClient,Produto> alterarProdutoUseCase;

    public AlterarProdutoController(IProductAlterUseCase<SaveProductClient,Produto> iProductUseCase) {

        this.alterarProdutoUseCase = iProductUseCase;
    }

    @PutMapping("/{id}")
    public Produto alterarProduto(@PathVariable Long id, @RequestBody Produto dto){

        SaveProductClient entrada = new SaveProductClient(id, dto.getNome(),dto.getPreco(),dto.getQuantidade());
      return alterarProdutoUseCase.executar(entrada);
    }
}
