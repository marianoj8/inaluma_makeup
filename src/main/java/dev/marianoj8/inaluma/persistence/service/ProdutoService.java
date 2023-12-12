package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.dto.ProdutoDto;
import dev.marianoj8.inaluma.persistence.model.entity.Produto;
import dev.marianoj8.inaluma.persistence.repository.ProdutoRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.marianoj8.inaluma.persistence.model.mapper.ProdutoMapper.dtoToModel;

@Service
@AllArgsConstructor
public class ProdutoService implements BaseService<Produto, ProdutoDto> {
    private ProdutoRepository repository;

    @Override
    public Produto getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Produto> fetch() {
        return repository.findAll();
    }

    @Override
    public Produto create(ProdutoDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public Produto update(ProdutoDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
