package dev.marianoj8.inaluma.persistence.repository.util;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long> {
  @Query(nativeQuery = true, value = "select * from #{#entityName} e where e.nome like %:nome%")
  public List<T> searhByNome(@Param("nome") String nome);

  @Modifying
  @Query("delete from #{#entityName} e where e.id = ?1")
  public void deleteById(@NonNull Long id);

  @Query("select e from #{#entityName} e where e.id = ?1")
  public @NonNull T getById(@NonNull Long id);

  public default List<T> fetch() { return findAll(); }
  public default T create(@NonNull T dto) { return save(dto); }
  public default T update(@NonNull T dto) { return create(dto); }
}
