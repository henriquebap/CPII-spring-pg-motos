package br.com.fiap.motos.resource;

import br.com.fiap.motos.entity.Loja;
import br.com.fiap.motos.entity.Veiculo;
import br.com.fiap.motos.service.LojaService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loja")
public class LojaResource implements ResourceDTO<Loja, Loja, Loja> {

    @Autowired
    private LojaService lojaService;

    @GetMapping
    public ResponseEntity<Collection<Loja>> findLojaByExample(@RequestParam(required = false) String nome) {
        Loja exampleLoja = Loja.builder().nome(nome).build();
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<Loja> example = Example.of(exampleLoja, matcher);
        Collection<Loja> lojas = lojaService.findAll(example);
        return ResponseEntity.ok().body(lojas);
    }

    @PostMapping
    public ResponseEntity<Loja> save(@RequestBody Loja loja) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lojaService.save(loja));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loja> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(lojaService.findById(id));
    }

    @GetMapping("/{id}/veiculos")
    public ResponseEntity<Loja> findVeiculosByLojaId(@PathVariable Long id) {
        Loja loja = lojaService.findById(id);
        if (loja == null) {
            return ResponseEntity.notFound().build();
        }
        loja.getVeiculosComercializados().size();
        return ResponseEntity.ok().body(loja);
    }

    @PostMapping("/{id}/veiculos")
    public ResponseEntity<Loja> saveVeiculoForLoja(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        Loja foundLoja = lojaService.findById(id);
        if (foundLoja == null) {
            return ResponseEntity.notFound().build();
        }
        foundLoja.getVeiculosComercializados().add(veiculo);
        Loja savedLoja = lojaService.save(foundLoja);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLoja);
    }
}