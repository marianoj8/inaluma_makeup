package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.dto.VendaDto;
import dev.marianoj8.inaluma.persistence.model.entity.Venda;
import dev.marianoj8.inaluma.persistence.model.mapper.VendaMapper;
import dev.marianoj8.inaluma.persistence.repository.VendaRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.marianoj8.inaluma.persistence.model.mapper.VendaMapper.dtoToModel;
import static dev.marianoj8.inaluma.persistence.model.mapper.VendaMapper.modelToDto;

@Service
@AllArgsConstructor
public class VendaService implements BaseService<Venda, VendaDto> {
    private VendaRepository repository;

    @Override
    public Venda getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Venda> fetch() {
        return repository.findAll();
    }

    @Override
    public Venda create(VendaDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public Venda update(VendaDto dto) {
        return repository.save(dtoToModel(dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
