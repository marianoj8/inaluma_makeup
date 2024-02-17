package dev.marianoj8.inaluma.persistence.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Entity
public class Categoria extends CustomAbstractEntity {
  @NotEmpty private String nome;
  @NotNull private Boolean isForProduto;

  @ManyToMany(mappedBy = "servicos") @JsonIgnore
  private java.util.Set<User> users = new java.util.HashSet<>();

  @ManyToMany(mappedBy = "categorias") @JsonIgnore
  private java.util.Set<Artigo> artigos = new java.util.HashSet<>();

  public Categoria(String nome, Boolean isForProduto) {
    super();

    this.nome = nome;
    this.isForProduto = isForProduto;
  }
}
