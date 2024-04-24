package br.com.fiap.motos.service;

import br.com.fiap.motos.entity.*;

import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@jakarta.transaction.Transactional
public class PersistenciaService {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private AcessorioService acessorioService;

    @Autowired
    private LojaService lojaService;

    @Autowired
    private TipoVeiculoService tipoVeiculoService;

    @Autowired
    private FabricanteService fabricanteService;

    @Autowired
    private CaracteristicaService caracteristicaService;

    public void persistirDados() {
        // Fabricantes
        Fabricante fabricante1 = Fabricante.builder().nome("Fabricante 1").build();
        fabricanteService.save(fabricante1);

        Fabricante fabricante2 = Fabricante.builder().nome("Fabricante 2").build();
        fabricanteService.save(fabricante2);

        // Tipos de Veículo
        TipoVeiculo tipoVeiculo1 = TipoVeiculo.builder().nome("Tipo 1").build();
        tipoVeiculoService.save(tipoVeiculo1);

        TipoVeiculo tipoVeiculo2 = TipoVeiculo.builder().nome("Tipo 2").build();
        tipoVeiculoService.save(tipoVeiculo2);

        // Acessórios
        Acessorio acessorio1 = Acessorio.builder().nome("Acessório 1").preco(100.00).build();
        acessorioService.save(acessorio1);

        Acessorio acessorio2 = Acessorio.builder().nome("Acessório 2").preco(200.00).build();
        acessorioService.save(acessorio2);

        // Veículos
        Veiculo veiculo1 = Veiculo.builder()
                .nome("Veículo 1")
                .anoDeFabricacao(Year.of(2022))
                .cor("Vermelho")
                .preco(50000.00)
                .cilindradas((short) 1500)
                .modelo("Modelo 1")
                .palavraDeEfeito("Efeito 1")
                .fabricante(fabricante1)
                .tipo(tipoVeiculo1)
                .build();

        veiculo1.getAcessorios().add(acessorio1);
        veiculoService.save(veiculo1);

        Veiculo veiculo2 = Veiculo.builder()
                .nome("Veículo 2")
                .anoDeFabricacao(Year.of(2023))
                .cor("Azul")
                .preco(60000.00)
                .cilindradas((short) 2000)
                .modelo("Modelo 2")
                .palavraDeEfeito("Efeito 2")
                .fabricante(fabricante2)
                .tipo(tipoVeiculo2)
                .build();

        veiculo2.getAcessorios().add(acessorio2);
        veiculoService.save(veiculo2);

        // Lojas
        Loja loja1 = Loja.builder().nome("Loja 1").build();
        loja1.getVeiculosComercializados().add(veiculo1);
        lojaService.save(loja1);

        Loja loja2 = Loja.builder().nome("Loja 2").build();
        loja2.getVeiculosComercializados().add(veiculo2);
        lojaService.save(loja2);

        // Características
        Caracteristica caracteristica1 = Caracteristica.builder().nome("Característica 1").descricao("Descrição 1")
                .veiculo(veiculo1).build();
        caracteristicaService.save(caracteristica1);

        Caracteristica caracteristica2 = Caracteristica.builder().nome("Característica 2").descricao("Descrição 2")
                .veiculo(veiculo2).build();
        caracteristicaService.save(caracteristica2);
    }
}
