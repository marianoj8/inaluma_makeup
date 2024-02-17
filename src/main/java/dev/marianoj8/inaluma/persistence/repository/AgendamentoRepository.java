package dev.marianoj8.inaluma.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.marianoj8.inaluma.persistence.model.entity.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {}
