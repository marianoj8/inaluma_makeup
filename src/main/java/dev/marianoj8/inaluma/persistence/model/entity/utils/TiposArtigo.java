package dev.marianoj8.inaluma.persistence.model.entity.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum TiposArtigo {
  produto("Produto", 'P', true),
  servico("Serviço", 'S', false);

  private String name;
  private Character shortName;
  private Boolean isProduto;
}
