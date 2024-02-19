package dev.marianoj8.inaluma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marianoj8.inaluma.persistence.model.entity.UserRole;
import dev.marianoj8.inaluma.persistence.service.UserRoleService;
import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("v1/roles")
public class UserRoleController {
  @Autowired private final UserRoleService service;

  @GetMapping("fetch/all")
  public ResponseEntity<List<UserRole>> fetchAll() { return ResponseEntity.ok(service.fetch()); }

  @GetMapping("fetchBy/id/{id}")
  public ResponseEntity<UserRole> fetchById(@NonNull @PathVariable Long id) {
    var res = service.getById(id);
    return (res == null) ? new ResponseEntity<UserRole>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(res);
  }
}
