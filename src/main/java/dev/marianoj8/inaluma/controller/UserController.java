package dev.marianoj8.inaluma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marianoj8.inaluma.persistence.model.entity.User;
import dev.marianoj8.inaluma.persistence.model.entity.UserRole;
import dev.marianoj8.inaluma.persistence.service.UserService;
import lombok.AllArgsConstructor;

@RestController @AllArgsConstructor @RequestMapping("v1/users")
public class UserController {
  @Autowired UserService service;

  @GetMapping("role")
  public ResponseEntity<List<User>> getByRole(@RequestBody UserRole role) { return ResponseEntity.ok(service.fetchByRole(role)); }

  @GetMapping("fetch/all")
  public ResponseEntity<List<User>> fetch() {
    return ResponseEntity.ok(service.fetchAll());
  }
  

  @DeleteMapping("{id}")
  public ResponseEntity<Boolean> deleteById(Long id) { 
    service.deleteById(id);
    return ResponseEntity.ok(true);
  }
}