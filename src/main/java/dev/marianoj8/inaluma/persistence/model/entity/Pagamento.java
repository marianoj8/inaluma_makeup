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

    @ManyToOne(targetEntity = Factura.class)
    private Factura factura;

}
