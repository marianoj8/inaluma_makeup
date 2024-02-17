package dev.marianoj8.inaluma.persistence.model.entity;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import dev.marianoj8.inaluma.persistence.model.entity.utils.TiposPagamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @Entity
public class MetodoPagamento extends CustomAbstractEntity {
  @Column(nullable = false, unique = true)
  private String nome;

  @Column(columnDefinition = "Bit(1)", nullable = false)
  private boolean isElectronic;

  public static MetodoPagamento fromEnum(TiposPagamento e) {
    return new MetodoPagamento(e.getNome(), e.getIsElectronic());
  }
}