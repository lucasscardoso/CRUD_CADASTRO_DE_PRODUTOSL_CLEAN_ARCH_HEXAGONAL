package com.produtos.ArquiteturaHexagonal.core.shared.usecase;

public interface IProductUseCase <E,S>{
        S executar(E entrada);
}
