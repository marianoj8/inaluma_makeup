package dev.marianoj8.inaluma.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.marianoj8.inaluma.persistence.model.entity.Agendamento;
import dev.marianoj8.inaluma.persistence.repository.util.AbstractDocumentRepository;
import dev.marianoj8.inaluma.persistence.repository.util.BaseRepository;

@Repository
public interface AgendamentoRepository extends AbstractDocumentRepository<Agendamento> {
  @Query("select a from Agendamento a where a.funcionario.id = ?1")
  public List<Agendamento> fetchByFuncionarioId(Long id);
}
