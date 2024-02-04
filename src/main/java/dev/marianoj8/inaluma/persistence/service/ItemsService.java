package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.entity.Items;
import dev.marianoj8.inaluma.persistence.repository.ItemsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ItemsService {
    private ItemsRepository repository;

    public Items getById(Long id) {
        return repository.getReferenceById(id);
    }

    public List<Items> fetch() {
        return repository.findAll();
    }

    public Items create(Items items) {
        return repository.save(items);
    }

    public Items update(Items items) {
        return repository.save(items);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Items> getByFaturaId(Long faturaId) {
        return repository.getByFaturaId(faturaId);
    }
}
