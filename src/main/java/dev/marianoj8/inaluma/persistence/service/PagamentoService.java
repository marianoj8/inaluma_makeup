package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.dto.PagamentoDto;
import dev.marianoj8.inaluma.persistence.model.entity.Pagamento;
import dev.marianoj8.inaluma.persistence.repository.PagamentoRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.marianoj8.inaluma.persistence.model.mapper.PagamentoMapper.dtoToModel;

@Service
@AllArgsConstructor
public class PagamentoService implements BaseService<Pagamento, PagamentoDto> {
    private PagamentoRepository repository;

    @Override
    public Pagamento getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Pagamento> fetch() {
        return repository.findAll();
    }

    @Override
    public Pagamento create(PagamentoDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public Pagamento update(PagamentoDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
