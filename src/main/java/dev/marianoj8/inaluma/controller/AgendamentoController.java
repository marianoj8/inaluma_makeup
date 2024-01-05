package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.persistence.model.dto.AgendamentoDto;
import dev.marianoj8.inaluma.persistence.model.entity.Agendamento;
import dev.marianoj8.inaluma.persistence.service.AgendamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/agendamentos")
public class AgendamentoController {

    private AgendamentoService service;

    @GetMapping("{id}")
    public ResponseEntity<Agendamento> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> fetch() {
        return ResponseEntity.ok(service.fetch());
    }

    @PostMapping
    public ResponseEntity<Agendamento> create(@RequestBody AgendamentoDto dto) {
        return new ResponseEntity<>(service.create(dto), CREATED);
    }

    @PutMapping
    public ResponseEntity<Agendamento> modify(@RequestBody AgendamentoDto dto) {
        return new ResponseEntity<>(service.update(dto), ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
