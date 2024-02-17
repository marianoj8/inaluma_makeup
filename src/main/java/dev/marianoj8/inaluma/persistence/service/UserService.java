package dev.marianoj8.inaluma.persistence.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.User;
import dev.marianoj8.inaluma.persistence.model.entity.UserRole;
import dev.marianoj8.inaluma.persistence.repository.UserRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import jakarta.transaction.Transactional;

@Service @Transactional
public class UserService extends BaseService<User, UserRepository> {
  public List<User> fetchByRole(UserRole role) { return repository.fetchByRole(role.getNome()); }
  public List<User> fetchAdmins() { return repository.fetchAdmins(); }
  public List<User> fetchOperators() { return repository.fetchOperators(); }
  public List<User> fetchEmployees() { return repository.fetchOperators(); }
  public List<User> fetchAll() { return repository.fetch(); }

  public User signIn(String username, String password) { return repository.signIn(username, password); }
  public boolean checkAvailability(String username) { return repository.checkAvailability(username) != null; }
}