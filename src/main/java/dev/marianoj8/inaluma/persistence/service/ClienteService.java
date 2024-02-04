package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.entity.Cliente;
import dev.marianoj8.inaluma.persistence.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository repository;

    public Cliente getById(Long id) {
        return repository.findOne(id);
    }

    public List<Cliente> fetch(String description) {
        return repository.search(description);
    }

    public Cliente create(Cliente dto) {
        return repository.save(dto);
    }

    public Cliente update(Cliente dto) {
        return repository.save(dto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
