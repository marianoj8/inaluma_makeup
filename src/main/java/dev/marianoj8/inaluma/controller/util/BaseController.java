package dev.marianoj8.inaluma.controller.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@MappedSuperclass @AllArgsConstructor @NoArgsConstructor
public abstract class BaseController<T extends CustomAbstractEntity, S extends BaseService<T, ?>> {
  @Autowired protected S service;

  @GetMapping("fetch/all")
  public ResponseEntity<List<T>> fetchAll() { return ResponseEntity.ok(service.fetch()); }

  @GetMapping("fetchBy/id/{id}")
  public ResponseEntity<T> fetchById(@NonNull @PathVariable Long id) {
    var res = service.getById(id);
    return (res == null) ? new ResponseEntity<T>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(res);
  }
}
