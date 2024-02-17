package dev.marianoj8.inaluma.controller.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import jakarta.persistence.MappedSuperclass;
import lombok.NoArgsConstructor;

@MappedSuperclass @NoArgsConstructor
public class BaseControllerWithInserts<T extends CustomAbstractEntity, S extends BaseService<T, ?>> extends BaseController<T, S>{
  @PostMapping("new")
  public ResponseEntity<T> create(@NonNull @RequestBody T dto) { return new ResponseEntity<T>(service.create(dto), HttpStatus.CREATED); }

  @PutMapping("update")
  public ResponseEntity<T> update(@NonNull @RequestBody T dto) { return new ResponseEntity<T>(service.update(dto), HttpStatus.ACCEPTED); }
}