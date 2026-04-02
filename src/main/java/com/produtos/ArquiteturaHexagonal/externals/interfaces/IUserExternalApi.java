package com.produtos.ArquiteturaHexagonal.externals.interfaces;

import com.produtos.ArquiteturaHexagonal.core.shared.DTO.UserDto;
import com.produtos.ArquiteturaHexagonal.externals.config.feignconfig.FeignClientConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "user-service", url = "localhost:8080/usuarios/buscar/",configuration = FeignClientConfig.class)
public interface IUserExternalApi {
    @GetMapping("{id}")
    UserDto buscarUserPorId(@PathVariable("id") Long id);

}
