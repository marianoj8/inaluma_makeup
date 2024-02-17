package dev.marianoj8.inaluma.persistence.repository;

import dev.marianoj8.inaluma.persistence.model.entity.Factura;
import dev.marianoj8.inaluma.persistence.repository.util.AbstractDocumentRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends AbstractDocumentRepository<Factura> {
  @Query("select f from Factura f where f.agendamento.id = ?1")
  public Factura fetchByAgendamentoId(Long id);
}
