package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Entity
public class User extends CustomAbstractEntity {
  @NotNull
  private String nome;

  @NotNull
  private String sobrenome;

  @Column(columnDefinition = "Bit(1) default 0", nullable = false)
  private boolean desvinculado;

  @ManyToOne(targetEntity = Sexo.class, optional = false)
  private Sexo genero;

  @Column(unique = true, nullable = false)
  private String contato;
  
  @ManyToOne(targetEntity = UserRole.class, optional = false)
  private UserRole role;
  
  @NotEmpty @Column(unique = true, nullable = false)
  private String username;
  
  @NotEmpty
  private String password;

  @OneToMany(targetEntity = Categoria.class) @OnDelete(action = OnDeleteAction.RESTRICT)
  private final java.util.Set<Categoria> especialidades = new java.util.HashSet<>();
}