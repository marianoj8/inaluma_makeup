package dev.marianoj8.inaluma.persistence.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.Artigo;
import dev.marianoj8.inaluma.persistence.repository.ArtigoRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class ArtigoService extends BaseService<Artigo, ArtigoRepository> {
  public List<Artigo> fetchByTipoId(Long id) { return repository.fetchByTipoId(id); }
  public List<Artigo> fetchProdutos() { return repository.fetchProdutos(); }
  public List<Artigo> fetchServicos() { return repository.fetchServicos(); }
}