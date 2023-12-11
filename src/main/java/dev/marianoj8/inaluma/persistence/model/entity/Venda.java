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
public class Venda extends CustomAbstractEntity {
    @Column(nullable = false)
    private double total;
    @Column(nullable = false)
    private double qty;

    @ManyToOne(targetEntity = Cliente.class, optional = false)
    private Cliente cliente;
    @ManyToOne(targetEntity = Produto.class, optional = false)
    private Produto produto;
    @ManyToOne(targetEntity = Funcionario.class, optional = false)
    private Funcionario funcionario;

    public Venda(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, int totalModified, double total,
                 double qty, Cliente cliente, Produto produto, Funcionario funcionario) {
        super(id, createdAt, lastModifiedAt, totalModified);
        this.total = total;
        this.qty = qty;
        this.cliente = cliente;
        this.produto = produto;
        this.funcionario = funcionario;
    }
}
