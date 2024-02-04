package dev.marianoj8.inaluma.persistence.repository;

import dev.marianoj8.inaluma.persistence.model.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    @Query("select f from Factura f where f.id = ?1")
    Factura findOne(Long id);

    @Query("select f from Factura f where f.cliente.id = ?1")
    Factura getByClienteId(Long clienteId);

    @Query("select f from Factura f where f.agendamento.id = ?1")
    Factura getByAgendamentoId(Long agendamentoId);

}
