package dev.marianoj8.inaluma.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.Categoria;
import dev.marianoj8.inaluma.persistence.repository.CategoriaRepository;
import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class CategoriaService {
  @Autowired private CategoriaRepository repository;
}
