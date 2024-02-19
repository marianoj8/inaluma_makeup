package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Servico extends Artigo {
  @NotNull @OneToOne(mappedBy = "servico") @OnDelete(action = OnDeleteAction.RESTRICT)
  private Duracao duracao;

  @ManyToOne(targetEntity = Servico.class) @JoinColumn(name = "servico_id")
  private Servico servico;

  @NotEmpty
  private Double preco;
}