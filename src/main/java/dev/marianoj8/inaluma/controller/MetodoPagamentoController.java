package dev.marianoj8.inaluma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marianoj8.inaluma.controller.util.BaseController;
import dev.marianoj8.inaluma.persistence.model.entity.MetodoPagamento;
import dev.marianoj8.inaluma.persistence.service.MetodoPagamentoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.NoArgsConstructor;

@RestController @NoArgsConstructor
@RequestMapping("v1/metodoPagamento")
public class MetodoPagamentoController extends BaseController<MetodoPagamento, MetodoPagamentoService> {
  @PostMapping("new")
  public ResponseEntity<MetodoPagamento> create(@NonNull @RequestBody MetodoPagamento dto) { return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED); }

  @PutMapping("update")
  public ResponseEntity<MetodoPagamento> update(@NonNull @RequestBody MetodoPagamento dto) { return new ResponseEntity<>(service.update(dto), HttpStatus.ACCEPTED); }
}
