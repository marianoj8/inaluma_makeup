package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class VarianteProduto extends Produto {
  private String cor;
  private String tom;
  private String densidade;
  private String codigoVariante;
  
  @ManyToOne(targetEntity = SubCategoria.class) @OnDelete(action = OnDeleteAction.RESTRICT)
  private SubCategoria subCategoria;

  @NotEmpty
  private Double preco;
}