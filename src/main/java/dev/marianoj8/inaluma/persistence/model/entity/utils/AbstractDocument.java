package dev.marianoj8.inaluma.persistence.model.entity.utils;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class AbstractDocument extends CustomAbstractEntity {
  @NotNull
  private String numero;
  
  @NotNull
  private String status;

  @Column(nullable = false, columnDefinition = "Bit(1) default 0")
  private boolean liquidada;

  @OneToOne(targetEntity = User.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private User cliente;

  @OneToOne(targetEntity = User.class, optional = true) @OnDelete(action = OnDeleteAction.RESTRICT)
  private User operador;
}
