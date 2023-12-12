package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.persistence.model.dto.VendaDto;
import dev.marianoj8.inaluma.persistence.model.entity.Venda;
import dev.marianoj8.inaluma.persistence.service.VendaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/vendas")
public class VendaController {

    private VendaService service;

    @GetMapping("{id}")
    public ResponseEntity<Venda> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Venda>> fetch() {
        return ResponseEntity.ok(service.fetch());
    }

    @PostMapping
    public ResponseEntity<Venda> create(@RequestBody VendaDto dto) {
        return new ResponseEntity<>(service.create(dto), CREATED);
    }

    @PutMapping
    public ResponseEntity<Venda> modify(@RequestBody VendaDto dto) {
        return new ResponseEntity<>(service.update(dto), ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Venda> modify(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
