package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.dto.ClienteDto;
import dev.marianoj8.inaluma.persistence.model.entity.Cliente;
import dev.marianoj8.inaluma.persistence.repository.ClienteRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.marianoj8.inaluma.persistence.model.mapper.ClienteMapper.dtoToModel;

@Service
@AllArgsConstructor
public class ClienteService implements BaseService<Cliente, ClienteDto> {
    private ClienteRepository repository;

    @Override
    public Cliente getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Cliente> fetch() {
        return repository.findAll();
    }

    @Override
    public Cliente create(ClienteDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public Cliente update(ClienteDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
