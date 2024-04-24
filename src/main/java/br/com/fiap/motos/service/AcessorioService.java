package br.com.fiap.motos.service;

import br.com.fiap.motos.entity.Acessorio;
import br.com.fiap.motos.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AcessorioService implements ServiceDTO<Acessorio, Acessorio, Acessorio> {

    @Autowired
    private AcessorioRepository acessorioRepository;

    @Override
    public Collection<Acessorio> findAll(Example<Acessorio> example) {
        return acessorioRepository.findAll(example);
    }

    @Override
    public Acessorio findById(Long id) {
        return acessorioRepository.findById(id).orElse(null);
    }

    @Override
    public Acessorio save(Acessorio e) {
        return acessorioRepository.save(e);
    }

    @Override
    public Acessorio toEntity(Acessorio dto) {
        return Acessorio.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .preco(dto.getPreco())
                .build();
    }

    @Override
    public Acessorio toResponse(Acessorio e) {
        return Acessorio.builder()
                .id(e.getId())
                .nome(e.getNome())
                .preco(e.getPreco())
                .build();
    }
}
