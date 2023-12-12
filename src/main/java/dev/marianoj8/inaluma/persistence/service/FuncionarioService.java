package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.dto.FuncionarioDto;
import dev.marianoj8.inaluma.persistence.model.entity.Funcionario;
import dev.marianoj8.inaluma.persistence.repository.FuncionarioRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.marianoj8.inaluma.persistence.model.mapper.FuncionarioMapper.dtoToModel;

@Service
@AllArgsConstructor
public class FuncionarioService implements BaseService<Funcionario, FuncionarioDto> {
    private FuncionarioRepository repository;

    @Override
    public Funcionario getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Funcionario> fetch() {
        return repository.findAll();
    }

    @Override
    public Funcionario create(FuncionarioDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public Funcionario update(FuncionarioDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
