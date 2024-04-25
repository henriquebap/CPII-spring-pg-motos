package br.com.fiap.motos.resource;

import br.com.fiap.motos.entity.Fabricante;
import br.com.fiap.motos.service.FabricanteService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteResource implements ResourceDTO<Fabricante, Fabricante, Fabricante> {

    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping
    public ResponseEntity<Collection<Fabricante>> findFabricanteByExample(@RequestParam(required = false) String nome) {
        Fabricante exampleFabricante = new Fabricante();
        exampleFabricante.setNome(nome);

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues()
                .withStringMatcher(StringMatcher.CONTAINING);

        Example<Fabricante> example = Example.of(exampleFabricante, matcher);

        Collection<Fabricante> fabricantes = fabricanteService.findAll(example);
        return ResponseEntity.ok().body(fabricantes);
    }

    @PostMapping
    public ResponseEntity<Fabricante> save(@RequestBody Fabricante fabricante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteService.save(fabricante));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(fabricanteService.findById(id));
    }
}
