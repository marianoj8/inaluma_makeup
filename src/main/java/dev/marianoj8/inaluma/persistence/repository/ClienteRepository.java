package dev.marianoj8.inaluma.persistence.repository;

import dev.marianoj8.inaluma.persistence.model.entity.Cliente;
import dev.marianoj8.inaluma.persistence.model.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("select c from Cliente c where c.id = ?1")
    Cliente findOne(Long id);

    @Query("select c from Cliente c where concat(c.nome,' ',c.sobrenome,' ',c.contato) like %?1%")
    List<Cliente> search(String description);
}
