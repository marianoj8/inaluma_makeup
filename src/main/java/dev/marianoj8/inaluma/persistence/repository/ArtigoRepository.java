package dev.marianoj8.inaluma.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.marianoj8.inaluma.persistence.model.entity.Artigo;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
  @Query("select a from Artigo a where a.tipo.nome = ?1")
  public Artigo getByTipo(String nomeTipo);
  
  @Query("select f from Artigo f where f.tipo.isProduto = true")
  public List<Artigo> fetchProdutos();
}
