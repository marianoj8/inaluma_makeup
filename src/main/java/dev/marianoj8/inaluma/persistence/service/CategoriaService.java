package dev.marianoj8.inaluma.persistence.service;

import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.Categoria;
import dev.marianoj8.inaluma.persistence.repository.CategoriaRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import jakarta.transaction.Transactional;

@Service @Transactional
public class CategoriaService extends BaseService<Categoria, CategoriaRepository> {
}
