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
public class Items extends CustomAbstractEntity {

    private int qty;
    private double subtotal;

    @ManyToOne(targetEntity = Produto.class)
    private Produto produto;
    @ManyToOne(targetEntity = Servico.class)
    private Servico servico;
    @ManyToOne(targetEntity = Factura.class)
    private Factura factura;

    @ManyToOne(targetEntity = Agendamento.class)
    private Agendamento agendamento;

}
