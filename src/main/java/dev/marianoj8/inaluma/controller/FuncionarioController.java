package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.persistence.model.dto.FuncionarioDto;
import dev.marianoj8.inaluma.persistence.model.entity.Funcionario;
import dev.marianoj8.inaluma.persistence.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/funcionarios")
public class FuncionarioController {

    private FuncionarioService service;

    @GetMapping("{id}")
    public ResponseEntity<Funcionario> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> fetch() {
        return ResponseEntity.ok(service.fetch());
    }

    @PostMapping
    public ResponseEntity<Funcionario> create(@RequestBody FuncionarioDto dto) {
        return new ResponseEntity<>(service.create(dto), CREATED);
    }

    @PutMapping
    public ResponseEntity<Funcionario> modify(@RequestBody FuncionarioDto dto) {
        return new ResponseEntity<>(service.update(dto), ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
