package com.produtos.ArquiteturaHexagonal.core.shared.usecase;

public interface IProductAlterUseCase<E,S>{
        S executar(E entrada);
}
