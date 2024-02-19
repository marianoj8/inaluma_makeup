package dev.marianoj8.inaluma.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.marianoj8.inaluma.persistence.model.entity.Sexo;
import dev.marianoj8.inaluma.persistence.repository.util.BaseRepository;

@Repository
public interface SexoRepository extends BaseRepository<Sexo> {
  @Query(value = "select * from sexo s where s.nome like %:nome% limit 1", nativeQuery = true)
  public Sexo getByNome(@Param("nome") String nome);
}
