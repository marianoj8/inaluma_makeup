package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.entity.Funcionario;
import dev.marianoj8.inaluma.persistence.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioService {
    private FuncionarioRepository repository;

    public Funcionario getById(Long id) {
        return repository.findOne(id);
    }

    public List<Funcionario> fetch(String description) {
        return repository.search(description);
    }

    public Funcionario create(Funcionario dto) {
        return repository.save(dto);
    }

    public Funcionario update(Funcionario dto) {
        return repository.save(dto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
