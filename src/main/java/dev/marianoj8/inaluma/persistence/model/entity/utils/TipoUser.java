package dev.marianoj8.inaluma.persistence.model.entity.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum TipoUser {
  cliente("CLT", "Cliente", false),
  admin("ADM", "Administrador", true),
  operador("OPD","Operador", true),
  funcionario("FNC", "Funcionario", true);

  private String nome;
  private String displayName;
  private boolean isEmployee;
}
