package br.com.fiap.motos.resource;

import br.com.fiap.motos.entity.Caracteristica;
import br.com.fiap.motos.service.CaracteristicaService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicaResource implements ResourceDTO<Caracteristica, Caracteristica, Caracteristica> {

    @Autowired
    private CaracteristicaService caracteristicaService;

    @GetMapping
    public ResponseEntity<Collection<Caracteristica>> findCaracteristicaByExample(
            @RequestParam(required = false) String nome) {
        Caracteristica exampleCaracteristica = new Caracteristica();
        exampleCaracteristica.setNome(nome);

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues()
                .withStringMatcher(StringMatcher.CONTAINING);

        Example<Caracteristica> example = Example.of(exampleCaracteristica, matcher);

        Collection<Caracteristica> caracteristicas = caracteristicaService.findAll(example);
        return ResponseEntity.ok().body(caracteristicas);
    }

    @PostMapping
    public ResponseEntity<Caracteristica> save(@RequestBody Caracteristica caracteristica) {
        return ResponseEntity.status(HttpStatus.CREATED).body(caracteristicaService.save(caracteristica));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caracteristica> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(caracteristicaService.findById(id));
    }
}