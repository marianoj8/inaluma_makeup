package dev.marianoj8.inaluma.persistence.service;

import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.Sexo;
import dev.marianoj8.inaluma.persistence.repository.SexoRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
public class SexoService extends BaseService<Sexo, SexoRepository> {
  public Sexo getByNome(String nome) { return repository.getByNome(nome); }
}
