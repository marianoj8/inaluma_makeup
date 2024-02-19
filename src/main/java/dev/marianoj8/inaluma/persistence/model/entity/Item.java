package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Entity
@Table(name = "detalhes_factura")
public class Item extends CustomAbstractEntity {
  @NotEmpty private Integer qtd;
  @NotEmpty private Double preco;

  @ManyToOne(targetEntity = Servico.class) @OnDelete(action = OnDeleteAction.RESTRICT)
  private Servico servico;

  @ManyToOne(targetEntity = VarianteProduto.class) @OnDelete(action = OnDeleteAction.RESTRICT)
  private VarianteProduto produto;

  @ManyToOne(targetEntity = Factura.class) @OnDelete(action = OnDeleteAction.RESTRICT)
  private Factura factura;

  @ManyToOne(targetEntity = Carrinho.class) @OnDelete(action = OnDeleteAction.CASCADE)
  private Carrinho carrinho;
}
