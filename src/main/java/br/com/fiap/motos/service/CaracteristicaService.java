package br.com.fiap.motos.service;

import br.com.fiap.motos.entity.Caracteristica;
import br.com.fiap.motos.repository.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CaracteristicaService implements ServiceDTO<Caracteristica, Caracteristica, Caracteristica> {

    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    @Override
    public Collection<Caracteristica> findAll(Example<Caracteristica> example) {
        return caracteristicaRepository.findAll(example);
    }

    @Override
    public Caracteristica findById(Long id) {
        return caracteristicaRepository.findById(id).orElse(null);
    }

    @Override
    public Caracteristica save(Caracteristica e) {
        return caracteristicaRepository.save(e);
    }

    @Override
    public Caracteristica toEntity(Caracteristica dto) {
        return Caracteristica.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .veiculo(dto.getVeiculo())
                .build();
    }

    @Override
    public Caracteristica toResponse(Caracteristica e) {
        return Caracteristica.builder()
                .id(e.getId())
                .nome(e.getNome())
                .descricao(e.getDescricao())
                .veiculo(e.getVeiculo())
                .build();
    }
}
