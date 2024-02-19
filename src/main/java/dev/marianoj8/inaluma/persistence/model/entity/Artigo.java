package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @MappedSuperclass
public abstract class Artigo extends CustomAbstractEntity {
  private String descricao;

  @NotEmpty @Column(unique = true)
  private String codigo;
  
  @NotEmpty
  private String nome;

  @ManyToOne(targetEntity = EstadoArtigo.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private EstadoArtigo estado;

  @OneToOne(targetEntity = TipoArtigo.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private TipoArtigo tipo;

  @ManyToOne(targetEntity = Categoria.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private Categoria categoria;
}