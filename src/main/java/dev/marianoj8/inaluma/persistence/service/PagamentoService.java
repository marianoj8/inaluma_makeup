package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.entity.Pagamento;
import dev.marianoj8.inaluma.persistence.repository.PagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PagamentoService {
    private PagamentoRepository repository;

    public Pagamento getById(Long id) {
        return repository.getReferenceById(id);
    }

    public List<Pagamento> fetch() {
        return repository.findAll();
    }

    public Pagamento create(Pagamento dto) {
        return repository.save(dto);
    }

    public Pagamento update(Pagamento dto) {
        return repository.save(dto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
