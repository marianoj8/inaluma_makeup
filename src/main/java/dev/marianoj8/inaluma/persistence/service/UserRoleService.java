package dev.marianoj8.inaluma.persistence.service;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.UserRole;
import dev.marianoj8.inaluma.persistence.repository.UserRoleRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;

@Service
public class UserRoleService extends BaseService<UserRole, UserRoleRepository> {
  public UserRole create(@NonNull UserRole dto) { return repository.save(dto); }
  public UserRole getByNome(String nome) { return repository.getByNome(nome); }
}