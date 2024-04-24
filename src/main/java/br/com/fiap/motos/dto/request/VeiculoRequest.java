package br.com.fiap.motos.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Year;
import java.util.Set;

public record VeiculoRequest(
        @Size(min = 5, max = 255) @NotNull(message = "Nome é obrigatório!") String nome,

        @NotNull(message = "Ano de fabricação é obrigatório!") Year anoDeFabricacao,

        @Size(min = 2, max = 255) @NotNull(message = "Cor é obrigatória!") String cor,

        @NotNull(message = "Preço é obrigatório!") Double preco,

        @NotNull(message = "Cilindradas são obrigatórias!") Short cilindradas,

        @Size(min = 5, max = 255) String modelo,

        @Size(min = 5, max = 255) @NotNull(message = "Palavra de efeito é obrigatória!") String palavraDeEfeito,

        @NotNull(message = "Fabricante ID é obrigatório!") AbstractRequest fabricanteId,

        @NotNull(message = "Tipo de veículo ID é obrigatório!") AbstractRequest tipoVeiculoId,

        @Valid Set<Long> acessorios) {
}
