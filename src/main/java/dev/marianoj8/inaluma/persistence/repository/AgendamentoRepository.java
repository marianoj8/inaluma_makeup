package dev.marianoj8.inaluma.persistence.repository;

import dev.marianoj8.inaluma.persistence.model.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
