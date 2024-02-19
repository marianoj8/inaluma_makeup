package dev.marianoj8.inaluma.persistence.model.entity.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum TiposPagamento {
  cash("Cash", false),
  cartaoCredito("Cartão de Crédito", true),
  cartaoDebito("Cartão de Débito", true);

  private String nome;
  private Boolean isElectronic;
}
