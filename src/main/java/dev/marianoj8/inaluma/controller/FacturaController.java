package dev.marianoj8.inaluma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import dev.marianoj8.inaluma.controller.util.AbstractDocumentController;
import dev.marianoj8.inaluma.persistence.model.entity.Factura;
import dev.marianoj8.inaluma.persistence.service.FacturaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController @RequestMapping("v1/facturas")
public class FacturaController extends AbstractDocumentController<Factura, FacturaService>{
  protected ResponseEntity<Factura> persist(@NonNull Factura dto) { return new ResponseEntity<>(service.create(dto, "FT"), HttpStatus.CREATED); }

  @GetMapping("fetchBy/agendamentoId/{id}")
  public ResponseEntity<Factura> fetchByAgendamentoId(@RequestParam Long id) { return ResponseEntity.ok(service.fetchByAgendamentoId(id)); }
}
