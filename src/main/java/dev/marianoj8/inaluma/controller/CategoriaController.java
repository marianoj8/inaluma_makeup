package dev.marianoj8.inaluma.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.marianoj8.inaluma.persistence.model.entity.Categoria;
import dev.marianoj8.inaluma.persistence.service.CategoriaService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController @RequiredArgsConstructor
@RequestMapping("v1/categorias")
public class CategoriaController {
  @Autowired private final CategoriaService service;

  @GetMapping("fetch/all")
  public ResponseEntity<List<Categoria>> fetchAll() { return ResponseEntity.ok(service.fetch()); }

  @GetMapping("fetchBy/id/{id}")
  public ResponseEntity<Categoria> fetchById(@NonNull @PathVariable Long id) {
    var res = service.getById(id);
    return (res == null) ? new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(res);
  }

  @PostMapping("new")
  public ResponseEntity<Categoria> create(@NonNull @RequestBody Categoria dto) { return new ResponseEntity<Categoria>(service.create(dto), HttpStatus.CREATED); }

  @PutMapping("update")
  public ResponseEntity<Categoria> update(@NonNull @RequestBody Categoria dto) { return new ResponseEntity<Categoria>(service.update(dto), HttpStatus.ACCEPTED); }
}
