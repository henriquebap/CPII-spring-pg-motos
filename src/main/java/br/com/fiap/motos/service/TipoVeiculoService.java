package br.com.fiap.motos.service;

import br.com.fiap.motos.entity.TipoVeiculo;
import br.com.fiap.motos.repository.TipoVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TipoVeiculoService implements ServiceDTO<TipoVeiculo, TipoVeiculo, TipoVeiculo> {

    @Autowired
    private TipoVeiculoRepository tipoVeiculoRepository;

    @Override
    public Collection<TipoVeiculo> findAll(Example<TipoVeiculo> example) {
        return tipoVeiculoRepository.findAll(example);
    }

    @Override
    public TipoVeiculo findById(Long id) {
        return tipoVeiculoRepository.findById(id).orElse(null);
    }

    @Override
    public TipoVeiculo save(TipoVeiculo e) {
        return tipoVeiculoRepository.save(e);
    }

    @Override
    public TipoVeiculo toEntity(TipoVeiculo dto) {
        return TipoVeiculo.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .build();
    }

    @Override
    public TipoVeiculo toResponse(TipoVeiculo e) {
        return TipoVeiculo.builder()
                .id(e.getId())
                .nome(e.getNome())
                .build();
    }
}
