package dev.marianoj8.inaluma.persistence.repository;

import org.springframework.stereotype.Repository;

import dev.marianoj8.inaluma.persistence.model.entity.UserRole;
import dev.marianoj8.inaluma.persistence.repository.util.BaseRepository;

@Repository
public interface UserRoleRepository extends BaseRepository<UserRole> {
  UserRole getByNome(String nome);
}
