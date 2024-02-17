package dev.marianoj8.inaluma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import dev.marianoj8.inaluma.controller.util.AbstractDocumentController;
import dev.marianoj8.inaluma.persistence.model.entity.Agendamento;
import dev.marianoj8.inaluma.persistence.service.AgendamentoService;

@RestController @RequestMapping("v1/agendamentos")
public class AgendamentoController extends AbstractDocumentController<Agendamento, AgendamentoService> {
  protected ResponseEntity<Agendamento> persist(@NonNull Agendamento dto) { return new ResponseEntity<>(service.create(dto, "AG"), HttpStatus.CREATED); }
}