package dev.marianoj8.inaluma.persistence.service;

import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.MetodoPagamento;
import dev.marianoj8.inaluma.persistence.repository.MetodoPagamentoRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;

@Service
public class MetodoPagamentoService extends BaseService<MetodoPagamento, MetodoPagamentoRepository> { }
