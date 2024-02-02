package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.persistence.model.entity.Factura;
import dev.marianoj8.inaluma.persistence.service.FacturaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/facturas")
public class FacturaController {

    private FacturaService service;

    @GetMapping("{id}")
    public ResponseEntity<Factura> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Factura>> fetch() {
        return ResponseEntity.ok(service.fetch());
    }

    @PostMapping
    public ResponseEntity<Factura> create(@RequestBody Factura dto) {
        return new ResponseEntity<>(service.create(dto), CREATED);
    }

    @PutMapping
    public ResponseEntity<Factura> modify(@RequestBody Factura dto) {
        return new ResponseEntity<>(service.update(dto), ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
