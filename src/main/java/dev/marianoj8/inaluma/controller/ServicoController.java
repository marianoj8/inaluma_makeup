package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.persistence.model.dto.ServicoDto;
import dev.marianoj8.inaluma.persistence.model.entity.Servico;
import dev.marianoj8.inaluma.persistence.service.ServicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/servicos")
public class ServicoController {

    private ServicoService service;

    @GetMapping("{id}")
    public ResponseEntity<Servico> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Servico>> fetch() {
        return ResponseEntity.ok(service.fetch());
    }

    @PostMapping
    public ResponseEntity<Servico> create(@RequestBody ServicoDto dto) {
        return new ResponseEntity<>(service.create(dto), CREATED);
    }

    @PutMapping
    public ResponseEntity<Servico> modify(@RequestBody ServicoDto dto) {
        return new ResponseEntity<>(service.update(dto), ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
