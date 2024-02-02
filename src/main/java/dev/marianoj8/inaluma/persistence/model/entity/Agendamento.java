package dev.marianoj8.inaluma.persistence.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

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
    @ManyToOne(targetEntity = ApplicationUser.class)
    private Funcionario funcionario;
    @ManyToOne(targetEntity = ApplicationUser.class)
    private ApplicationUser user;
    private Date dataAgendamento;
    private String numeroAgendamento;
    @ManyToOne(targetEntity = Servico.class, optional = false)
    private Servico servico;

}
