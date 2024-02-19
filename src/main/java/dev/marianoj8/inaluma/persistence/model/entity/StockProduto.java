package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class StockProduto extends CustomAbstractEntity {
  @NotNull
  private Integer qtd;

  @NotNull @Column(columnDefinition = "Bit(1) default 1")
  private Boolean entrada;

  @ManyToOne(targetEntity = Produto.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private Long produto;

  @ManyToOne(targetEntity = VarianteProduto.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private Long variante;
}
