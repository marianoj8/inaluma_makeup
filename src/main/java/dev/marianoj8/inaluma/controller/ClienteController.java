package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.persistence.model.entity.Cliente;
import dev.marianoj8.inaluma.persistence.service.ClienteService;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/clientes")
public class ClienteController {

    private ClienteService service;

    @GetMapping("{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> fetch(@RequestParam(defaultValue = "") String description) {
        return ResponseEntity.ok(service.fetch(description));
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente dto) {
        return new ResponseEntity<>(service.create(dto), CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> modify(@RequestBody Cliente dto) {
        return new ResponseEntity<>(service.update(dto), ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
