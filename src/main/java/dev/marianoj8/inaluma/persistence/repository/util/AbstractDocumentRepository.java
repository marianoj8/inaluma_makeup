package dev.marianoj8.inaluma.persistence.repository.util;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import dev.marianoj8.inaluma.persistence.model.entity.utils.AbstractDocument;
import jakarta.persistence.MappedSuperclass;

@NoRepositoryBean @MappedSuperclass
public interface AbstractDocumentRepository<T extends AbstractDocument> extends BaseRepository<T> {
  public default List<T> fetch() { return findAll(); }
  
  @Query("select d from #{#entityName} d where d.operador.id = ?1")
  public List<T> fetchByOperadorId(Long id);

  @Query("select d from #{#entityName} d where d.cliente.id = ?1")
  public List<T> fetchByClienteId(Long id);

  @Query("select d from #{#entityName} d where d.numero = ?1")
  public T fetchByNumber(String number);

  @Query("select d from #{#entityName} d where d.status = ?1")
  public List<T> fetchByStatus(String status);

  @Query("select d from #{#entityName} d where d.liquidada = true")
  public List<T> fetchLiquidadas();

  @Query("select d from #{#entityName} d where d.liquidada = false")
  public List<T> fetchPorLiquidar();

  @Query(nativeQuery = true, value = "select max(id) from #{#entityName} limit 1")
  public T fetchLatest();
}
