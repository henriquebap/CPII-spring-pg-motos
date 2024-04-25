package br.com.fiap.motos.resource;

import br.com.fiap.motos.entity.TipoVeiculo;
import br.com.fiap.motos.service.TipoVeiculoService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo-veiculo")
public class TipoVeiculoResource implements ResourceDTO<TipoVeiculo, TipoVeiculo, TipoVeiculo> {

    @Autowired
    private TipoVeiculoService tipoVeiculoService;

    @GetMapping
    public ResponseEntity<Collection<TipoVeiculo>> findTipoVeiculoByExample(
            @RequestParam(required = false) String nome) {
        TipoVeiculo exampleTipoVeiculo = new TipoVeiculo();
        exampleTipoVeiculo.setNome(nome);

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues()
                .withStringMatcher(StringMatcher.CONTAINING);

        Example<TipoVeiculo> example = Example.of(exampleTipoVeiculo, matcher);

        Collection<TipoVeiculo> tiposVeiculo = tipoVeiculoService.findAll(example);
        return ResponseEntity.ok().body(tiposVeiculo);
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