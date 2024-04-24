package br.com.fiap.motos.service;

import br.com.fiap.motos.entity.Fabricante;
import br.com.fiap.motos.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FabricanteService implements ServiceDTO<Fabricante, Fabricante, Fabricante> {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public Collection<Fabricante> findAll(Example<Fabricante> example) {
        return fabricanteRepository.findAll(example);
    }

    @Override
    public Fabricante findById(Long id) {
        return fabricanteRepository.findById(id).orElse(null);
    }

    @Override
    public Fabricante save(Fabricante e) {
        return fabricanteRepository.save(e);
    }

    @Override
    public Fabricante toEntity(Fabricante dto) {
        return Fabricante.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .build();
    }

    @Override
    public Fabricante toResponse(Fabricante e) {
        return Fabricante.builder()
                .id(e.getId())
                .nome(e.getNome())
                .build();
    }
}
