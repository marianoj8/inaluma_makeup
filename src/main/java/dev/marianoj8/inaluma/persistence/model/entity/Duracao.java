package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter @Entity
public class Duracao extends CustomAbstractEntity {
  private Integer dias;
  private Integer horas;
  private Integer minutos;

  @OneToOne(targetEntity = Artigo.class, optional = false) @OnDelete(action = OnDeleteAction.CASCADE)
  private Artigo servico;
}
