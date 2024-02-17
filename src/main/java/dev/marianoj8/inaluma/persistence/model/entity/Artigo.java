package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Entity
public class Artigo extends CustomAbstractEntity {
  private String descricao;
  private Long stockProduto;
  private String codigoProduto;

  @OneToOne(mappedBy = "artigo") @OnDelete(action = OnDeleteAction.RESTRICT)
  private File imagem;
  
  @NotEmpty
  private String nome;

  @NotEmpty
  private Double preco;
  
  @OneToOne(targetEntity = TipoArtigo.class, optional = false) @OnDelete(action = OnDeleteAction.RESTRICT)
  private TipoArtigo tipo;

  @OneToOne(mappedBy = "servico") @OnDelete(action = OnDeleteAction.RESTRICT)
  private Duracao duracao;

  @ManyToMany
  @OnDelete(action = OnDeleteAction.RESTRICT)
  @JoinTable(
    name = "artigos_categorias",
    joinColumns = @JoinColumn(name = "item_id"),
    inverseJoinColumns = @JoinColumn(name = "categoria_id")
  ) private final java.util.Set<Categoria> categorias = new java.util.HashSet<>();

  @OneToMany(mappedBy = "item") @OnDelete(action = OnDeleteAction.RESTRICT)
  private java.util.Set<ItemFactura> itensFactura = new java.util.HashSet<>();
}
