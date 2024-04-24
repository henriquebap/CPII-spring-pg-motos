package br.com.fiap.motos.resource;

import br.com.fiap.motos.entity.Loja;
import br.com.fiap.motos.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loja")
public class LojaResource implements ResourceDTO<Loja, Loja, Loja> {

    @Autowired
    private LojaService lojaService;

    @GetMapping
    public ResponseEntity<Loja> findLojaByExample(Example<Loja> example) {
        return ResponseEntity.ok().body((Loja) lojaService.findAll(example));
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
        return ResponseEntity.ok().body(loja);
    }

    @PostMapping("/{id}/veiculos")
    public ResponseEntity<Loja> saveVeiculoForLoja(@PathVariable Long id, @RequestBody Loja loja) {
        Loja foundLoja = lojaService.findById(id);
        if (foundLoja == null) {
            return ResponseEntity.notFound().build();
        }
        foundLoja.setVeiculosComercializados(loja.getVeiculosComercializados());
        lojaService.save(foundLoja);
        return ResponseEntity.status(HttpStatus.CREATED).body(foundLoja);
    }
}
