package dev.marianoj8.inaluma.persistence.repository;

import dev.marianoj8.inaluma.persistence.model.entity.Produto;
import dev.marianoj8.inaluma.persistence.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("select c from Produto c where c.id = ?1")
    Produto getById(Long id);

    @Query("select c from Produto c")
    List<Produto> findAll();
}
