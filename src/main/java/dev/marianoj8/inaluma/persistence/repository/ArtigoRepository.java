package dev.marianoj8.inaluma.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.marianoj8.inaluma.persistence.model.entity.Artigo;
import dev.marianoj8.inaluma.persistence.repository.util.BaseRepository;

@Repository
public interface ArtigoRepository extends BaseRepository<Artigo> {
  @Query("select a from Artigo a where a.tipo.id = ?1")
  public List<Artigo> fetchByTipoId(Long id);
  
  @Query("select f from Artigo f where f.tipo.isProduto = true")
  public List<Artigo> fetchProdutos();
  
  @Query("select f from Artigo f where f.tipo.isProduto = false")
  public List<Artigo> fetchServicos();
}
