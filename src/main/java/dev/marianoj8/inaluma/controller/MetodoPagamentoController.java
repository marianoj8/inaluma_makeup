package dev.marianoj8.inaluma.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marianoj8.inaluma.controller.util.BaseControllerWithInserts;
import dev.marianoj8.inaluma.persistence.model.entity.MetodoPagamento;
import dev.marianoj8.inaluma.persistence.service.MetodoPagamentoService;
import lombok.NoArgsConstructor;

@RestController @NoArgsConstructor
@RequestMapping("v1/metodoPagamento")
public class MetodoPagamentoController extends BaseControllerWithInserts<MetodoPagamento, MetodoPagamentoService> { }