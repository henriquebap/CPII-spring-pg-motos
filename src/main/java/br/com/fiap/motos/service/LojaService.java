package br.com.fiap.motos.service;

import br.com.fiap.motos.entity.Loja;
import br.com.fiap.motos.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LojaService implements ServiceDTO<Loja, Loja, Loja> {

    @Autowired
    private LojaRepository lojaRepository;

    @Override
    public Collection<Loja> findAll(Example<Loja> example) {
        return lojaRepository.findAll(example);
    }

    @Override
    public Loja findById(Long id) {
        return lojaRepository.findById(id).orElse(null);
    }

    @Override
    public Loja save(Loja e) {
        return lojaRepository.save(e);
    }

    @Override
    public Loja toEntity(Loja dto) {
        return Loja.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .veiculosComercializados(dto.getVeiculosComercializados())
                .build();
    }

    @Override
    public Loja toResponse(Loja e) {
        return Loja.builder()
                .id(e.getId())
                .nome(e.getNome())
                .veiculosComercializados(e.getVeiculosComercializados())
                .build();
    }
}
