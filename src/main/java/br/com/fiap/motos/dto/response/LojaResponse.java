package br.com.fiap.motos.dto.response;

import java.util.Set;

public record LojaResponse(Long id, String nome, Set<Long> veiculosComercializados) {
}
