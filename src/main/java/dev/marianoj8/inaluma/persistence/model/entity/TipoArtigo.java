package dev.marianoj8.inaluma.persistence.model.entity;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import dev.marianoj8.inaluma.persistence.model.entity.utils.TiposArtigo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @Entity @NoArgsConstructor
public class TipoArtigo extends CustomAbstractEntity{
  @Column(nullable = false, unique = true) private String nome;
  @Column(columnDefinition = "Bit(1)", nullable = false) private boolean isProduto;
  public static TipoArtigo fromEnum(TiposArtigo a) { return new TipoArtigo(a.getName(), a.getIsProduto()); }
}
