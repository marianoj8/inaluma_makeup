package dev.marianoj8.inaluma;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.marianoj8.inaluma.persistence.model.entity.Categoria;
import dev.marianoj8.inaluma.persistence.model.entity.MetodoPagamento;
import dev.marianoj8.inaluma.persistence.model.entity.Sexo;
import dev.marianoj8.inaluma.persistence.model.entity.TipoArtigo;
import dev.marianoj8.inaluma.persistence.model.entity.User;
import dev.marianoj8.inaluma.persistence.model.entity.UserRole;
import dev.marianoj8.inaluma.persistence.model.entity.utils.FilterOperator;
import dev.marianoj8.inaluma.persistence.model.entity.utils.Genders;
import dev.marianoj8.inaluma.persistence.model.entity.utils.TipoUser;
import dev.marianoj8.inaluma.persistence.model.entity.utils.TiposArtigo;
import dev.marianoj8.inaluma.persistence.model.entity.utils.TiposPagamento;
import dev.marianoj8.inaluma.persistence.service.CategoriaService;
import dev.marianoj8.inaluma.persistence.service.MetodoPagamentoService;
import dev.marianoj8.inaluma.persistence.service.SexoService;
import dev.marianoj8.inaluma.persistence.service.TipoArtigoServico;
import dev.marianoj8.inaluma.persistence.service.UserRoleService;
import dev.marianoj8.inaluma.persistence.service.UserService;

import java.util.ArrayList;

@SpringBootApplication @RequiredArgsConstructor
public class InalumaApplication implements CommandLineRunner {
  private final UserService userService;
  private final UserRoleService userRoleService;
  private final SexoService sexoService;
  private final MetodoPagamentoService metodoPagamentoService;
  private final TipoArtigoServico tipoArtigoServico;
  private final CategoriaService categoriaService;

  public static void main(String[] args) { SpringApplication.run(InalumaApplication.class, args); }

  @Override
  public void run(String... args) throws Exception {
    if (userService.fetchAll().isEmpty()) {
      addGenders();
      addUserRoles();
      addTipoArtigo();
      addMetodosPagamento();
      addCategorias();
      addUsers();
    }
  }

  private void addGenders() { for(var g: Genders.values()) sexoService.create(Sexo.fromEnum(g)); }
  private void addUserRoles() { for(var r: TipoUser.values()) userRoleService.create(UserRole.fromEnum(r)); }
  private void addMetodosPagamento() { for(var m: TiposPagamento.values()) metodoPagamentoService.create(MetodoPagamento.fromEnum(m)); }
  private void addTipoArtigo() { for(var a: TiposArtigo.values()) tipoArtigoServico.create(TipoArtigo.fromEnum(a)); }

  private void addCategorias() {
    categoriaService.create(new Categoria("Base líquida", true));
    categoriaService.create(new Categoria("Base em pó", true));
    categoriaService.create(new Categoria("Glitter", true));
    categoriaService.create(new Categoria("Corretivo N° 1", true));
    categoriaService.create(new Categoria("Corretivo N° 2", true));
    categoriaService.create(new Categoria("Spray fixador", true));
    categoriaService.create(new Categoria("Pincel", true));
    categoriaService.create(new Categoria("Paleta de sombras", true));
    categoriaService.create(new Categoria("Paleta de corretivos", true));
    categoriaService.create(new Categoria("Blush tom rosa", true));
    categoriaService.create(new Categoria("Blush Líquido", true));
    categoriaService.create(new Categoria("Batom Vermelho", true));
    categoriaService.create(new Categoria("Batom Roxo", true));
    categoriaService.create(new Categoria("Batom Rosa", true));
    categoriaService.create(new Categoria("Gloss com Glitter", true));
    categoriaService.create(new Categoria("Gloss sem Glitter", true));
    categoriaService.create(new Categoria("Cílios Postiços", true));
    categoriaService.create(new Categoria("Cola de Cílios", true));
    categoriaService.create(new Categoria("Lápis Preto", true));
    categoriaService.create(new Categoria("Lápis Marrom", true));
    categoriaService.create(new Categoria("Lápis Marrom Escuro", true));
    categoriaService.create(new Categoria("Delineador", true));
    categoriaService.create(new Categoria("Máscara de Cílios/Rímel", true));
    categoriaService.create(new Categoria("Iluminador em glitter", true));
    categoriaService.create(new Categoria("Puff/Esponja", true));
    categoriaService.create(new Categoria("Gel de sobrancelha", true));
    categoriaService.create(new Categoria("Escova sobrancelha", true));
  }

  private void addUsers() {
    var femenino = sexoService.getByNome(Genders.femenino.getNome());
    var admin = userRoleService.getByNome(TipoUser.admin.getNome());

    User u = new User();
    u.setNome("Valênia Araújo");
    u.setSobrenome("Castanheta");
    u.setGenero(femenino);
    u.setContato("934945098");
    u.setRole(admin);
    u.setUsername("valenia22");
    u.setPassword("password");
    
    userService.create(u);
  }
}