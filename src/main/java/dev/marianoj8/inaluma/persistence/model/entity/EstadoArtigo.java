package dev.marianoj8.inaluma.persistence.model.entity;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EstadoArtigo extends CustomAbstractEntity {
  @NotEmpty @Column(unique = true)
  private String nome;
  
  @NotEmpty @Column(unique = true)
  private String abreviacao;

  @NotNull @Column(columnDefinition = "Bit(1)")
  private Boolean forProduto;
}
