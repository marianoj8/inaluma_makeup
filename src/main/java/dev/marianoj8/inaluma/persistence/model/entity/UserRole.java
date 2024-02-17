package dev.marianoj8.inaluma.persistence.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import dev.marianoj8.inaluma.persistence.model.entity.utils.TipoUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Entity @Getter @Setter
public class UserRole extends CustomAbstractEntity {
  @Column(nullable = false, unique = true)
  private String nome;

  @Column(nullable = false, unique = true)
  private String displayName;

  @NotNull
  private boolean isEmployee;

  public static UserRole fromEnum(TipoUser role) { return new UserRole(role.getNome(), role.getDisplayName(), role.isEmployee()); }
   public boolean isOperator() { return this.getNome().equalsIgnoreCase(TipoUser.operador.getNome()); }
   public boolean isAdmin() { return this.getNome().equalsIgnoreCase(TipoUser.admin.getNome()); }
   public boolean isFuncionario() { return this.getNome().equalsIgnoreCase(TipoUser.funcionario.getNome()); }
   public boolean isCliente() { return this.isEmployee() == false; }
   public boolean isTeste() { return true; }
}
