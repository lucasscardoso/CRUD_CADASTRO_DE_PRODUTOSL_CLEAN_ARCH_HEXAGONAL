package com.produtos.ArquiteturaHexagonal.externals.db;

import com.produtos.ArquiteturaHexagonal.core.product.repository.externalrepository.UserExternalRepository;
import com.produtos.ArquiteturaHexagonal.core.shared.DTO.UserDto;
import com.produtos.ArquiteturaHexagonal.externals.interfaces.IUserExternalApi;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDbAdapter implements UserExternalRepository {

    private final IUserExternalApi iUserExternalApi;

    public UserDbAdapter(IUserExternalApi iUserExternalApi) {
        this.iUserExternalApi = iUserExternalApi;
    }

    @Override
    public Optional<UserDto> findById(Long id) {

            return Optional.ofNullable(iUserExternalApi.buscarUserPorId(id));

    }
}
