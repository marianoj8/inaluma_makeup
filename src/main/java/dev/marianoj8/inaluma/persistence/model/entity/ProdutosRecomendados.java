package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProdutosRecomendados extends CustomAbstractEntity {
  @ManyToOne(targetEntity = VarianteProduto.class) @OnDelete(action =  OnDeleteAction.RESTRICT)
  private VarianteProduto produto;

  @ManyToOne(targetEntity = Servico.class) @OnDelete(action = OnDeleteAction.RESTRICT)
  private Servico servico;
}