package dev.marianoj8.inaluma.persistence.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.AbstractDocument;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Entity
public class Agendamento extends AbstractDocument {
  @NotNull @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime dataHoraAgendada;

  @ManyToOne(targetEntity = Servico.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private Servico servico;

  @ManyToOne(targetEntity = User.class) @OnDelete(action = OnDeleteAction.RESTRICT)
  private User funcionario;

  @Column(columnDefinition = "Bit(1) default 0")
  private Boolean reagendado;

  @ManyToOne(targetEntity = Agendamento.class) @OnDelete(action = OnDeleteAction.RESTRICT)
  private Agendamento agendamentoOriginal;
}