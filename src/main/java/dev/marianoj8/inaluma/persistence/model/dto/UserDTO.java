package dev.marianoj8.inaluma.persistence.model.dto;

import dev.marianoj8.inaluma.persistence.model.entity.Categoria;
import dev.marianoj8.inaluma.persistence.model.entity.File;
import dev.marianoj8.inaluma.persistence.model.entity.Sexo;
import dev.marianoj8.inaluma.persistence.model.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserDTO extends AbstractRootDTO {
  private String nome;
  private String sobrenome;
  private boolean desvinculado;
  private Sexo genero;
  private String contato;
  private UserRole role;
  private String username;
  private String password;
  private java.util.Set<Categoria> servicos;
  private File imagem;
}
