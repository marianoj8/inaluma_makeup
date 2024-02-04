package dev.marianoj8.inaluma.persistence.repository;

import dev.marianoj8.inaluma.persistence.model.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {
    @Query("select i from Items i where i.id = ?1")
    Items findOne(Long id);

    @Query("select i from Items i where i.factura.id = ?1")
    List<Items> getByFaturaId(Long faturaId);
}
