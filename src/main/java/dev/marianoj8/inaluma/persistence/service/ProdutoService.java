package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.entity.Produto;
import dev.marianoj8.inaluma.persistence.repository.ProdutoRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProdutoService {
    private ProdutoRepository repository;

    public Produto getById(Long id) {
        return repository.getById(id);
    }

    public List<Produto> fetch() {
        return repository.findAll();
    }

    public Produto create(Produto dto) {
        return repository.save(dto);
    }

    public Produto update(Produto dto) {
        return repository.save(dto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
