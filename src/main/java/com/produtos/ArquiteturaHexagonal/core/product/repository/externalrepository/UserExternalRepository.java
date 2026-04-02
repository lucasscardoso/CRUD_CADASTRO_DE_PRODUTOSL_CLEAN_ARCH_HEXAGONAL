package com.produtos.ArquiteturaHexagonal.core.product.repository.externalrepository;

import com.produtos.ArquiteturaHexagonal.core.shared.DTO.UserDto;

import java.util.Optional;

public interface UserExternalRepository {
    Optional<UserDto> findById(Long id);
}
