package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FabricanteResponse(
        @NotNull(message = "ID do fabricante é obrigatório!") Long id,

        @Size(min = 5, max = 255, message = "Nome deve ter entre 5 e 255 caracteres!") @NotNull(message = "Nome do fabricante é obrigatório!") String nome) {
}
