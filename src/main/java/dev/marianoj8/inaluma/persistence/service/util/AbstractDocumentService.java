package dev.marianoj8.inaluma.persistence.service.util;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import dev.marianoj8.inaluma.persistence.model.entity.utils.AbstractDocument;
import dev.marianoj8.inaluma.persistence.repository.util.AbstractDocumentRepository;
import jakarta.persistence.MappedSuperclass;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@MappedSuperclass @AllArgsConstructor @NoArgsConstructor @Transactional
public abstract class AbstractDocumentService<T extends AbstractDocument, R extends AbstractDocumentRepository<T>> {
  @Autowired protected R repository;
  @Autowired public ModelMapper mapper;

  public T create(@NonNull T dto, String prefix) {
    var latest = repository.fetchLatest();
    
    dto.setNumero(
      prefix.toUpperCase().concat(" ")
      .concat(latest.getId().toString())
      .concat(" / ")
      .concat(String.valueOf(LocalDateTime.now().getYear()))
    );

    return repository.create(dto);
  }
  
  public List<T> fetch() { return repository.fetch(); }
  public T getById(@NonNull Long id) { return repository.getById(id); }
  public void deleteById(@NonNull Long id) { repository.deleteById(id); }
  public T update(@NonNull T dto) { return repository.save(dto); }
  public List<T> fetchByOperadorId(Long id) { return repository.fetchByOperadorId(id); }
  public List<T> fetchByClienteId(Long id) { return repository.fetchByClienteId(id); }
  public T fetchByNumber(String number) { return repository.fetchByNumber(number); }
  public List<T> fetchByStatus(String status) { return repository.fetchByStatus(status); }
  public List<T> fetchLiquidadas() { return repository.fetchLiquidadas(); }
  public List<T> fetchPorLiquidar() { return repository.fetchPorLiquidar(); }
}
