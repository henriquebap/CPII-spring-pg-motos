package br.com.fiap.motos.resource;

import br.com.fiap.motos.entity.Veiculo;
import br.com.fiap.motos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResource implements ResourceDTO<Veiculo, Veiculo, Veiculo> {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<Veiculo> findVeiculoByExample(Example<Veiculo> example) {
        return ResponseEntity.ok().body((Veiculo) veiculoService.findAll(example));
    }

    @PostMapping
    public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.save(veiculo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(veiculoService.findById(id));
    }

    @GetMapping("/{id}/acessorios")
    public ResponseEntity<Veiculo> findAcessoriosByVeiculoId(@PathVariable Long id) {
        Veiculo veiculo = veiculoService.findById(id);
        if (veiculo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(veiculo);
    }

    @PostMapping("/{id}/acessorios")
    public ResponseEntity<Veiculo> saveAcessorioForVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        Veiculo foundVeiculo = veiculoService.findById(id);
        if (foundVeiculo == null) {
            return ResponseEntity.notFound().build();
        }
        foundVeiculo.setAcessorios(veiculo.getAcessorios());
        veiculoService.save(foundVeiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(foundVeiculo);
    }
}
