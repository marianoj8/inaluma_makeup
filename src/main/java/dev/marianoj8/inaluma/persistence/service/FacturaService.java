package dev.marianoj8.inaluma.persistence.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.Factura;
import dev.marianoj8.inaluma.persistence.repository.FacturaRepository;
import dev.marianoj8.inaluma.persistence.service.util.AbstractDocumentService;

@Service
public class FacturaService extends AbstractDocumentService<Factura, FacturaRepository> {
  public List<Factura> getByClienteId(Long clienteId) { return repository.fetchByClienteId(clienteId); }
  public Factura fetchByAgendamentoId(Long id) { return repository.fetchByAgendamentoId(id); }
}
