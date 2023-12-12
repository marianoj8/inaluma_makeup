package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.persistence.model.dto.ApplicationUserDto;
import dev.marianoj8.inaluma.persistence.model.entity.ApplicationUser;
import dev.marianoj8.inaluma.persistence.service.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/users")
public class ApplicationUserController {

    private ApplicationUserService service;

    @GetMapping("{id}")
    public ResponseEntity<ApplicationUser> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ApplicationUser>> fetch() {
        return ResponseEntity.ok(service.fetch());
    }

    @PostMapping
    public ResponseEntity<ApplicationUser> create(@RequestBody ApplicationUserDto dto) {
        return new ResponseEntity<>(service.create(dto), CREATED);
    }

    @PutMapping
    public ResponseEntity<ApplicationUser> modify(@RequestBody ApplicationUserDto dto) {
        return new ResponseEntity<>(service.update(dto), ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApplicationUser> modify(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
