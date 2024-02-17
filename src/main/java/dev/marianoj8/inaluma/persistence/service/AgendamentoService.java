package dev.marianoj8.inaluma.persistence.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.Agendamento;
import dev.marianoj8.inaluma.persistence.repository.AgendamentoRepository;
import dev.marianoj8.inaluma.persistence.service.util.AbstractDocumentService;

@Service
public class AgendamentoService extends AbstractDocumentService<Agendamento, AgendamentoRepository> {
  public List<Agendamento> fetchByFuncionarioId(Long id) { return repository.fetchByFuncionarioId(id); }
}
