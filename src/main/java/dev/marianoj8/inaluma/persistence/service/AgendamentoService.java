package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.dto.AgendamentoDto;
import dev.marianoj8.inaluma.persistence.model.entity.Agendamento;
import dev.marianoj8.inaluma.persistence.model.mapper.AgendamentoMapper;
import dev.marianoj8.inaluma.persistence.repository.AgendamentoRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.marianoj8.inaluma.persistence.model.mapper.AgendamentoMapper.dtoToModel;
import static dev.marianoj8.inaluma.persistence.model.mapper.AgendamentoMapper.modelToDto;

@Service
@AllArgsConstructor
public class AgendamentoService implements BaseService<Agendamento, AgendamentoDto> {
    private AgendamentoRepository repository;

    @Override
    public Agendamento getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Agendamento> fetch() {
        return repository.findAll();
    }

    @Override
    public Agendamento create(AgendamentoDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public Agendamento update(AgendamentoDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
