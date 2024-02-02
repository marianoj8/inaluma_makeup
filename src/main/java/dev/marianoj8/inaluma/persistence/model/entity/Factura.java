package dev.marianoj8.inaluma.persistence.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Factura extends CustomAbstractEntity {
    String numeroFatura;
    String status;
    double totalFatura;
    @ManyToOne(targetEntity = ApplicationUser.class)
    ApplicationUser user;
    private double total;
    @ManyToOne(targetEntity = Cliente.class)
    private Cliente cliente;
    @ManyToOne(targetEntity = Funcionario.class)
    private Funcionario funcionario;
    @ManyToOne(targetEntity = Agendamento.class)
    private Agendamento agendamento;

}
