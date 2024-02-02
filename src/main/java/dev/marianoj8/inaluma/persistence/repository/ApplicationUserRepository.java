package dev.marianoj8.inaluma.persistence.repository;

import dev.marianoj8.inaluma.persistence.model.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    @Query("select a from ApplicationUser a where a.username = ?1 and a.password = ?2")
    ApplicationUser login(String u, String p);

    @Query("select a from ApplicationUser a where a.username = ?1")
    ApplicationUser findByUsername(String username);
}
