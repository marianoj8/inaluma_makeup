package dev.marianoj8.inaluma.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.Factura;
import dev.marianoj8.inaluma.persistence.repository.FacturaRepository;
import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class FacturaService {
  @Autowired private FacturaRepository repository;

  public Factura getByClienteId(Long clienteId) { return repository.getByClienteId(clienteId); }
  public Factura getByAgendamentoId(Long agendamentoId) { return repository.getByAgendamentoId(agendamentoId); }
}
