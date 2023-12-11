package dev.marianoj8.inaluma.persistence.model.entity;

import dev.marianoj8.inaluma.persistence.model.entity.utils.TimeUnits;
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
public class Servico extends CustomAbstractEntity {
    @Column(unique = true, nullable = false)
    private String nome;
    private String descricao;
    @Column(nullable = false)
    private double preco;
    @Column(nullable = false)
    private int duracao;
    @Column(nullable = false)
    private TimeUnits units;
    private boolean estado;

    @ManyToOne(targetEntity = Funcionario.class, optional = true)
    private Funcionario funcionario;

    public Servico(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, int totalModified, String nome,
                   String descricao, double preco, int duracao, TimeUnits units, boolean estado, Funcionario funcionario) {
        super(id, createdAt, lastModifiedAt, totalModified);
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.duracao = duracao;
        this.units = units;
        this.estado = estado;
        this.funcionario = funcionario;
    }
}
