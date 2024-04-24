package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TipoVeiculoRequest(
        @Size(min = 5, max = 255) @NotNull(message = "Nome é obrigatório!") String nome) {
}
