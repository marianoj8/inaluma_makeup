package dev.marianoj8.inaluma.persistence.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.AbstractDocument;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Entity
public class Agendamento extends AbstractDocument {
  @NotNull @Temporal(TemporalType.DATE)
  private LocalDate dataAgendada;

  @OneToOne(targetEntity = User.class) @OnDelete(action = OnDeleteAction.RESTRICT)
  private User funcionario;

  @OneToOne(mappedBy = "agendamento") @OnDelete(action = OnDeleteAction.CASCADE)
  private Factura factura;
}