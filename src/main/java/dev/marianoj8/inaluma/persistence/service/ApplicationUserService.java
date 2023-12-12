package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.dto.ApplicationUserDto;
import dev.marianoj8.inaluma.persistence.model.entity.ApplicationUser;
import dev.marianoj8.inaluma.persistence.repository.ApplicationUserRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.marianoj8.inaluma.persistence.model.mapper.ApplicationUserMapper.dtoToModel;

@Service
@AllArgsConstructor
public class ApplicationUserService implements BaseService<ApplicationUser, ApplicationUserDto> {
    private ApplicationUserRepository repository;

    @Override
    public ApplicationUser getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<ApplicationUser> fetch() {
        return repository.findAll();
    }

    @Override
    public ApplicationUser create(ApplicationUserDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public ApplicationUser update(ApplicationUserDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
