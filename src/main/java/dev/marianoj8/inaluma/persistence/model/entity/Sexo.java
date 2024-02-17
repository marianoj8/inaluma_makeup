package dev.marianoj8.inaluma.persistence.model.entity;

import org.springframework.lang.NonNull;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import dev.marianoj8.inaluma.persistence.model.entity.utils.Genders;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @Entity @AllArgsConstructor
public class Sexo extends CustomAbstractEntity {
  @Column(nullable = false, unique = true)
  private String nome;
  
  @Column(unique = true, nullable = false)
  private String shortName;
  
  public static @NonNull Sexo fromEnum(Genders g) { return new Sexo(g.getNome(), g.getShortName()); }
}
