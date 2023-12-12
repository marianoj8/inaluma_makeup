package dev.marianoj8.inaluma.persistence.repository;

import dev.marianoj8.inaluma.persistence.model.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
}
