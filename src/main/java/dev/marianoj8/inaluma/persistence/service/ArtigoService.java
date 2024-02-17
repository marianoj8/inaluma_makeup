package dev.marianoj8.inaluma.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.Artigo;
import dev.marianoj8.inaluma.persistence.repository.ArtigoRepository;
import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class ArtigoService {
  @Autowired private ArtigoRepository repository;

  public List<Artigo> fetchProdutos() { return repository.fetchProdutos(); }
  public Artigo findById(Long ownerId) { return repository.findById(ownerId).get(); }
  public Artigo update(Artigo owner) { return repository.save(owner); }
}
