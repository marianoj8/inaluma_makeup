package dev.marianoj8.inaluma.persistence.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Produto extends Artigo {
  @ManyToOne(targetEntity = MarcaProduto.class)
  private MarcaProduto marca;
}
