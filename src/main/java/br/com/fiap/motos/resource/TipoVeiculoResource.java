package br.com.fiap.motos.resource;

import br.com.fiap.motos.entity.TipoVeiculo;
import br.com.fiap.motos.service.TipoVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo-de-veiculo")
public class TipoVeiculoResource implements ResourceDTO<TipoVeiculo, TipoVeiculo, TipoVeiculo> {

    @Autowired
    private TipoVeiculoService tipoVeiculoService;

    @GetMapping
    public ResponseEntity<TipoVeiculo> findTipoVeiculoByExample(Example<TipoVeiculo> example) {
        return ResponseEntity.ok().body((TipoVeiculo) tipoVeiculoService.findAll(example));
    }

    @PostMapping
    public ResponseEntity<TipoVeiculo> save(@RequestBody TipoVeiculo tipoVeiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoVeiculoService.save(tipoVeiculo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoVeiculo> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(tipoVeiculoService.findById(id));
    }
}
