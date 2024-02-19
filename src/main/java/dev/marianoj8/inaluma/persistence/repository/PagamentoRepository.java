package dev.marianoj8.inaluma.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.marianoj8.inaluma.persistence.model.entity.Pagamento;
import dev.marianoj8.inaluma.persistence.repository.util.BaseRepository;

@Repository
public interface PagamentoRepository extends BaseRepository<Pagamento> {
  @Query("select p from Pagamento p where p.factura.id = ?1")
  List<Pagamento> fetchByFacturaId(Long id);

  @Query("select p from Pagamento p where p.operador.id = ?1")
  List<Pagamento> fetchByOperadorId(Long id);
}