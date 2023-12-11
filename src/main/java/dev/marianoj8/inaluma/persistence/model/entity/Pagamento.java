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
public class Pagamento extends CustomAbstractEntity {
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String metodo;
    @Column(nullable = false)
    private double valorPagamento;

    @ManyToOne(targetEntity = Agendamento.class, optional = true)
    private Agendamento agendamento;

    @ManyToOne(targetEntity = Venda.class, optional = true)
    private Venda venda;

    public Pagamento(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, int totalModified, String status,
                     String metodo, double valorPagamento, Agendamento agendamento, Venda venda) {
        super(id, createdAt, lastModifiedAt, totalModified);
        this.status = status;
        this.metodo = metodo;
        this.valorPagamento = valorPagamento;
        this.agendamento = agendamento;
        this.venda = venda;
    }
}
