package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AcessorioRequest(
        @Size(min = 5, max = 255, message = "Nome deve ter entre 5 e 255 caracteres!") @NotNull(message = "Nome é obrigatório!") String nome,

        @NotNull(message = "Preço é obrigatório!") Double preco) {
}
