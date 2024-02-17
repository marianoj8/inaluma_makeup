package dev.marianoj8.inaluma.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.marianoj8.inaluma.persistence.model.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
  @Query("select f from File f where f.id = ?1")
  public File fetchById(Long id);

  @Query("select f from File f where f.user.id = ?1")
  public File fetchByUserId(Long id);

  @Query("select f from File f where f.artigo.id = ?1")
  public File fetchByArtigoId(Long id);
}
