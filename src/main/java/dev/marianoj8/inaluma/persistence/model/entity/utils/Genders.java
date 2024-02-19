package dev.marianoj8.inaluma.persistence.model.entity.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum Genders {
  masculino("Masculino", "M", true),
  femenino("Femenino", "F", false);

  private String nome;
  private String shortName;
  private Boolean isHomem;
}
