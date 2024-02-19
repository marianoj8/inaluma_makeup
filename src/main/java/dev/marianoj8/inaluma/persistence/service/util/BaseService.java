package dev.marianoj8.inaluma.persistence.service.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import dev.marianoj8.inaluma.persistence.repository.util.BaseRepository;
import jakarta.persistence.MappedSuperclass;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@MappedSuperclass @AllArgsConstructor @NoArgsConstructor @Transactional
public abstract class BaseService<T extends CustomAbstractEntity, R extends BaseRepository<T>> {
  @Autowired protected R repository;
  @Autowired public ModelMapper mapper;

  public List<T> fetchByNome(String nome) { return repository.searhByNome(nome); }

  @Transactional
  public List<T> fetch() { return repository.fetch(); }
  public T getById(@NonNull Long id) { return repository.getById(id); }
  public void deleteById(@NonNull Long id) { repository.deleteById(id); }
  public T create(@NonNull T dto) { return repository.create(dto); }
  public T update(@NonNull T dto) { return create(dto); }
}
