package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.AbstractDocument;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor
public class Factura extends AbstractDocument {
  @OneToOne(targetEntity = Agendamento.class) @OnDelete(action = OnDeleteAction.RESTRICT) 
  private Agendamento agendamento;

  @ManyToOne(targetEntity = TipoCompra.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private TipoCompra tipoCompra;
}