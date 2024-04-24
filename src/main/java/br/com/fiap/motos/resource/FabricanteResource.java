package br.com.fiap.motos.resource;

import br.com.fiap.motos.entity.Fabricante;
import br.com.fiap.motos.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteResource implements ResourceDTO<Fabricante, Fabricante, Fabricante> {

    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping
    public ResponseEntity<Fabricante> findFabricanteByExample(Example<Fabricante> example) {
        return ResponseEntity.ok().body((Fabricante) fabricanteService.findAll(example));
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
