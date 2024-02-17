package dev.marianoj8.inaluma.persistence.model.entity;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.marianoj8.inaluma.persistence.model.entity.utils.AbstractDocument;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor
public class Factura extends AbstractDocument {
  @OneToOne(targetEntity = Agendamento.class, optional = true) @OnDelete(action = OnDeleteAction.RESTRICT) 
  private Agendamento agendamento;

  @OneToMany(mappedBy = "factura")
  private final Set<Pagamento> pagamentos;

  @OneToMany(mappedBy = "factura")
  private final List<ItemFactura> itens;
}
