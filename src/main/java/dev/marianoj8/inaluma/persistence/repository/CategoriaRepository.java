package dev.marianoj8.inaluma.persistence.repository;

import org.springframework.stereotype.Repository;

import dev.marianoj8.inaluma.persistence.model.entity.Categoria;
import dev.marianoj8.inaluma.persistence.repository.util.BaseRepository;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria>{ }