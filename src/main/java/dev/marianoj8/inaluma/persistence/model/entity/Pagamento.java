package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Entity
public class Pagamento extends CustomAbstractEntity {
  @ManyToOne(targetEntity = MetodoPagamento.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private MetodoPagamento metodo;
  
  @NotEmpty
  private double valorPagamento;

  @ManyToOne(targetEntity = Factura.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private Factura factura;
  
  @ManyToOne(targetEntity = User.class) @OnDelete(action = OnDeleteAction.RESTRICT)
  private User operador;

  @ManyToOne(targetEntity = User.class) @OnDelete(action = OnDeleteAction.RESTRICT)
  private User cliente;
}
