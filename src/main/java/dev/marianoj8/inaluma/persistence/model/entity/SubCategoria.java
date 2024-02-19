package dev.marianoj8.inaluma.persistence.model.entity;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SubCategoria extends CustomAbstractEntity {
  @NotEmpty @Column(unique = true)
  private String nome;
  
  @NotNull @ManyToOne(targetEntity = Categoria.class)
  private Long categoria;
}