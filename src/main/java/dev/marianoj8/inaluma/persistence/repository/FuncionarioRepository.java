package dev.marianoj8.inaluma.persistence.repository;

import dev.marianoj8.inaluma.persistence.model.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    @Query("select f from Funcionario f where f.id = ?1")
    Funcionario findOne(Long id);

    @Query("select f from Funcionario f where concat(f.nome,' ',f.sobrenome,' ',f.contato) like %?1%")
    List<Funcionario> search(String description);
}
