package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Carrinho extends CustomAbstractEntity {
  @ManyToOne(targetEntity = User.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private User cliente;

  @ManyToOne(targetEntity = User.class) @OnDelete(action = OnDeleteAction.RESTRICT)
  private User operador;

  @ManyToOne(targetEntity = EstadoCarrinho.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private EstadoCarrinho estado;

  @OneToMany(mappedBy = "carrinho") @OnDelete(action = OnDeleteAction.RESTRICT)
  private java.util.Set<Item> itens;
}