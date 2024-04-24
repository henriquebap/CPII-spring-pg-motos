package br.com.fiap.motos.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;

public record LojaRequest(
        @Size(min = 5, max = 255, message = "Nome deve ter entre 5 e 255 caracteres!") @NotNull(message = "Nome é obrigatório!") String nome,

        @Valid @NotNull(message = "Veículos comercializados são obrigatórios!") Set<Long> veiculosComercializados) {
}
