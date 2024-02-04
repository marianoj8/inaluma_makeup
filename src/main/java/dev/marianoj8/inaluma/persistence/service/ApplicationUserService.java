package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.entity.ApplicationUser;
import dev.marianoj8.inaluma.persistence.repository.ApplicationUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationUserService {
    private ApplicationUserRepository repository;

    public ApplicationUser getById(Long id) {
        return repository.getReferenceById(id);
    }

    public ApplicationUser getByUsernameAndPassword(String username, String password) {
        return repository.login(username, password);
    }

    public List<ApplicationUser> fetch() {
        return repository.findAll();
    }

    public ApplicationUser create(ApplicationUser dto) {
        return repository.save(dto);
    }

    public ApplicationUser update(ApplicationUser dto) {
        return repository.save(dto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public boolean getByUsername(String username) {
        return repository.findByUsername(username) != null;
    }
}
