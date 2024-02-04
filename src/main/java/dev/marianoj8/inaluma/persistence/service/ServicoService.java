package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.entity.Servico;
import dev.marianoj8.inaluma.persistence.repository.ServicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ServicoService {
    private ServicoRepository repository;

    public Servico getById(Long id) {
        return repository.getById(id);
    }

    public List<Servico> fetch() {
        return repository.findAll();
    }

    public Servico create(Servico dto) {
        return repository.save(dto);
    }

    public Servico update(Servico dto) {
        return repository.save(dto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
