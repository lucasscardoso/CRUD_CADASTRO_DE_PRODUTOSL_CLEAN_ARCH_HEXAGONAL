package com.produtos.ArquiteturaHexagonal.core.shared.exceptions.defaulterros;

import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.AccessDeniedException;
import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.InternalErrorException;
import com.produtos.ArquiteturaHexagonal.core.shared.exceptions.ProductNotSaveClientNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 404 -> new ProductNotSaveClientNotFoundException("Cliente não encontrado na API externa");
            case 403 -> new AccessDeniedException("Acesso negado ao serviço externo, validar se o token está valido ou expirado.");
            case 500 -> new InternalErrorException("Erro Interno,contate o Adminstrador (validar erro productside/Externalside)");
            default -> new Exception("Erro genérico da API");
        };
    }
}
