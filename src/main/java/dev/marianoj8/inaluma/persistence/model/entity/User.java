package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

  @ManyToMany
  @JoinTable(
    name = "funcionarios_categorias",
    joinColumns = @JoinColumn(name = "funcionario_id"),
    inverseJoinColumns = @JoinColumn(name = "categoria_id")
  ) private final java.util.Set<Categoria> servicos = new java.util.HashSet<>();

  @OneToOne(mappedBy = "user") @OnDelete(action = OnDeleteAction.CASCADE)
  private File imagem;
}
