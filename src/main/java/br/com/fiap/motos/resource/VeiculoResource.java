package br.com.fiap.motos.resource;

import br.com.fiap.motos.service.AcessorioService;
import br.com.fiap.motos.entity.Acessorio;
import br.com.fiap.motos.entity.Veiculo;
import br.com.fiap.motos.service.VeiculoService;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<Collection<Veiculo>> findVeiculos() {
        Example<Veiculo> example = Example.of(new Veiculo());

        Collection<Veiculo> veiculos = veiculoService.findAll(example);

        return ResponseEntity.ok().body(veiculos);
    }

    @PostMapping
    public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.save(veiculo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable Long id) {
        Veiculo veiculo = veiculoService.findById(id);
        veiculo.getAcessorios().size();
        return ResponseEntity.ok().body(veiculo);
    }

    @GetMapping("/{id}/acessorios")
    public ResponseEntity<Set<Acessorio>> findAcessoriosByVeiculoId(@PathVariable Long id) {
        Veiculo veiculo = veiculoService.findById(id);
        if (veiculo == null) {
            return ResponseEntity.notFound().build();
        }
        Set<Acessorio> acessorios = veiculo.getAcessorios();
        return ResponseEntity.ok().body(acessorios);
    }

    @Autowired
    private AcessorioService acessorioService;

    @PostMapping("/{id}/acessorios")
    public ResponseEntity<Veiculo> saveAcessorioForVeiculo(@PathVariable Long id, @RequestBody Long acessorioId) {
        Veiculo foundVeiculo = veiculoService.findById(id);
        if (foundVeiculo == null) {
            return ResponseEntity.notFound().build();
        }

        Acessorio acessorio = acessorioService.findById(acessorioId);
        if (acessorio == null) {
            return ResponseEntity.notFound().build();
        }

        foundVeiculo.getAcessorios().add(acessorio);

        veiculoService.save(foundVeiculo);

        return ResponseEntity.status(HttpStatus.CREATED).body(foundVeiculo);
    }
}
