package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.dto.ServicoDto;
import dev.marianoj8.inaluma.persistence.model.entity.Servico;
import dev.marianoj8.inaluma.persistence.repository.ServicoRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.marianoj8.inaluma.persistence.model.mapper.ServicoMapper.dtoToModel;

@Service
@AllArgsConstructor
public class ServicoService implements BaseService<Servico, ServicoDto> {
    private ServicoRepository repository;

    @Override
    public Servico getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Servico> fetch() {
        return repository.findAll();
    }

    @Override
    public Servico create(ServicoDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public Servico update(ServicoDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
