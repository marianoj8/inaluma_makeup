package dev.marianoj8.inaluma.controller.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.marianoj8.inaluma.persistence.model.entity.utils.AbstractDocument;
import dev.marianoj8.inaluma.persistence.service.util.AbstractDocumentService;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@MappedSuperclass @AllArgsConstructor @NoArgsConstructor
public abstract class AbstractDocumentController<T extends AbstractDocument, S extends AbstractDocumentService<T, ?>> {
  @Autowired protected S service;

  protected abstract ResponseEntity<T> persist(@NonNull T dto);
  
  @PostMapping("new")
  public ResponseEntity<T> create(@NonNull @RequestBody T dto) { return persist(dto); }

  @GetMapping("fetch/all")
  public ResponseEntity<List<T>> fetchAll() { return ResponseEntity.ok(service.fetch()); }

  @GetMapping("fetchBy/id/{id}")
  public ResponseEntity<T> fetchById(@NonNull @PathVariable Long id) {
    var res = service.getById(id);
    return (res == null) ? new ResponseEntity<T>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(res);
  }

  @PutMapping("update")
  public ResponseEntity<T> update(@NonNull @RequestBody T dto) { return new ResponseEntity<T>(service.update(dto), HttpStatus.ACCEPTED); }

  @DeleteMapping("deleteBy/id/{id}")
  public ResponseEntity<Boolean> deleteById(@NonNull Long id) { 
    service.deleteById(id);
    return ResponseEntity.ok(true);
  }

  @GetMapping("fetchBy/operadorId/{id}")
  public List<T> fetchByOperadorId(@PathVariable Long id) { return service.fetchByOperadorId(id); }

  @GetMapping("fetchBy/clienteId/{id}")
  public List<T> fetchByClienteId(@PathVariable Long id) { return service.fetchByClienteId(id); }

  @GetMapping("fetchBy/number/{number}")
  public T fetchByNumber(@PathVariable String number) { return service.fetchByNumber(number); }

  @GetMapping("fetchBy/status/{status}")
  public List<T> fetchByStatus(@PathVariable String status) { return service.fetchByStatus(status); }

  @GetMapping("fetch/liquidadas")
  public List<T> fetchLiquidadas() { return service.fetchLiquidadas(); }

  @GetMapping("fetch/porLiquidar")
  public List<T> fetchPorLiquidar() { return service.fetchPorLiquidar(); }
}
