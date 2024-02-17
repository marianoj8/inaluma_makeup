package dev.marianoj8.inaluma.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.marianoj8.inaluma.persistence.model.entity.Sexo;
import dev.marianoj8.inaluma.persistence.service.SexoService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController @AllArgsConstructor
@RequestMapping("v1/sexo")
public class SexoController {
  @Autowired private final SexoService service;

  @GetMapping("fetch/all")
  public ResponseEntity<List<Sexo>> fetchAll() { return ResponseEntity.ok(service.fetch()); }

  @GetMapping("fetch/by/id/{id}")
  public ResponseEntity<Sexo> getById(@PathVariable(name = "id") Long id) {
    return ResponseEntity.ok(service.getById(id));
  }
}
