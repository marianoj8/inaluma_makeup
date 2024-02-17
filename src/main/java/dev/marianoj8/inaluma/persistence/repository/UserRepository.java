package dev.marianoj8.inaluma.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.marianoj8.inaluma.persistence.model.entity.User;
import dev.marianoj8.inaluma.persistence.model.entity.utils.TipoUser;
import dev.marianoj8.inaluma.persistence.repository.util.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<User> {
  @Query("select f from User f where f.role.nome = ?1")
  public List<User> fetchByRole(String roleName);

  @Query("select f from User f where f.role.isEmployee = ?1")
  public List<User> fetchEmployees(boolean isEmployee);

  @Query("select f from User f where f.username = :username and f.password = :password")
  public User signIn(@Param("username") String username, @Param("password") String password);

  @Query("select f from User f where f.username = ?1")
  public User checkAvailability(String username);

  @Query("select u from User u where u.role.id = ?1")
  public User fetchByRoleId(Long id);

  public default List<User> fetchClients() { return fetchEmployees(false); }
  public default List<User> fetchAdmins() { return fetchByRole(TipoUser.admin.getNome()); }
  public default List<User> fetchOperators() { return fetchByRole(TipoUser.operador.getNome()); }
  public default List<User> fetchFuncionarios() { return fetchByRole(TipoUser.funcionario.getNome()); }
}
