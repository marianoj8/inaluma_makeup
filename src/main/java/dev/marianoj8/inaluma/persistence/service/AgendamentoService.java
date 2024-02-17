package dev.marianoj8.inaluma.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.repository.AgendamentoRepository;
import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class AgendamentoService {
  @Autowired private AgendamentoRepository repository;
}
