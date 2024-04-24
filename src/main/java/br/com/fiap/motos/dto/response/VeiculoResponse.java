package br.com.fiap.motos.dto.response;

import java.time.Year;
import java.util.Set;

public record VeiculoResponse(
        Long id,
        String nome,
        Year anoDeFabricacao,
        String cor,
        Double preco,
        Short cilindradas,
        String modelo,
        String palavraDeEfeito,
        Long fabricanteId,
        Long tipoVeiculoId,
        Set<Long> acessorios) {
}