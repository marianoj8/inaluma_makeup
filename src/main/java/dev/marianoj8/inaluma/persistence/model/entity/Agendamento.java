package dev.marianoj8.inaluma.persistence.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Agendamento extends CustomAbstractEntity {
    @Column(nullable = false)
    private String status;
    private String tipo;

    @ManyToOne(targetEntity = Cliente.class, optional = false)
    private Cliente cliente;

    @ManyToOne(targetEntity = Servico.class, optional = false)
    private Servico servico;

    public Agendamento(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, int totalModified, String status, String tipo, Cliente cliente, Servico servico) {
        super(id, createdAt, lastModifiedAt, totalModified);
        this.status = status;
        this.tipo = tipo;
        this.cliente = cliente;
        this.servico = servico;
    }
}
