package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CaracteristicaRequest(
        @Size(min = 5, max = 255, message = "Nome deve ter entre 5 e 255 caracteres!") @NotNull(message = "Nome é obrigatório!") String nome,

        @Size(min = 5, max = 255, message = "Descrição deve ter entre 5 e 255 caracteres!") @NotNull(message = "Descrição é obrigatória!") String descricao,

        @NotNull(message = "ID do veículo é obrigatório!") AbstractRequest veiculoId) {
}
