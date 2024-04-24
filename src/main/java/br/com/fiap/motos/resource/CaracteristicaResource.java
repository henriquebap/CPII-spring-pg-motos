package br.com.fiap.motos.resource;

import br.com.fiap.motos.entity.Caracteristica;
import br.com.fiap.motos.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicaResource implements ResourceDTO<Caracteristica, Caracteristica, Caracteristica> {

    @Autowired
    private CaracteristicaService caracteristicaService;

    @GetMapping
    public ResponseEntity<Caracteristica> findCaracteristicaByExample(Example<Caracteristica> example) {
        return ResponseEntity.ok().body((Caracteristica) caracteristicaService.findAll(example));
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
