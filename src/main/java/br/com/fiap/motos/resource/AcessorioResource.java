package br.com.fiap.motos.resource;

import br.com.fiap.motos.entity.Acessorio;
import br.com.fiap.motos.service.AcessorioService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acessorio")
public class AcessorioResource implements ResourceDTO<Acessorio, Acessorio, Acessorio> {

    @Autowired
    private AcessorioService acessorioService;

    @GetMapping
    public ResponseEntity<Collection<Acessorio>> findAcessorioByExample(@RequestParam(required = false) String nome) {
        Acessorio exampleAcessorio = new Acessorio();
        exampleAcessorio.setNome(nome);

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues()
                .withStringMatcher(StringMatcher.CONTAINING);

        Example<Acessorio> example = Example.of(exampleAcessorio, matcher);

        Collection<Acessorio> acessorios = acessorioService.findAll(example);
        return ResponseEntity.ok().body(acessorios);
    }

    @PostMapping
    public ResponseEntity<Acessorio> save(@RequestBody Acessorio acessorio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(acessorioService.save(acessorio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acessorio> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(acessorioService.findById(id));
    }
}