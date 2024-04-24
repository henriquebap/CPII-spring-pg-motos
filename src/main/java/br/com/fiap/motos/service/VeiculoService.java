package br.com.fiap.motos.service;

import br.com.fiap.motos.entity.Veiculo;
import br.com.fiap.motos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VeiculoService implements ServiceDTO<Veiculo, Veiculo, Veiculo> {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    public Collection<Veiculo> findAll(Example<Veiculo> example) {
        return veiculoRepository.findAll(example);
    }

    @Override
    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    @Override
    public Veiculo save(Veiculo e) {
        return veiculoRepository.save(e);
    }

    @Override
    public Veiculo toEntity(Veiculo dto) {
        return Veiculo.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .anoDeFabricacao(dto.getAnoDeFabricacao())
                .cor(dto.getCor())
                .preco(dto.getPreco())
                .cilindradas(dto.getCilindradas())
                .modelo(dto.getModelo())
                .palavraDeEfeito(dto.getPalavraDeEfeito())
                .fabricante(dto.getFabricante())
                .tipo(dto.getTipo())
                .acessorios(dto.getAcessorios())
                .build();
    }

    @Override
    public Veiculo toResponse(Veiculo e) {
        return Veiculo.builder()
                .id(e.getId())
                .nome(e.getNome())
                .anoDeFabricacao(e.getAnoDeFabricacao())
                .cor(e.getCor())
                .preco(e.getPreco())
                .cilindradas(e.getCilindradas())
                .modelo(e.getModelo())
                .palavraDeEfeito(e.getPalavraDeEfeito())
                .fabricante(e.getFabricante())
                .tipo(e.getTipo())
                .acessorios(e.getAcessorios())
                .build();
    }
}
