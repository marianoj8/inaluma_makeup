package dev.marianoj8.inaluma.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.Pagamento;
import dev.marianoj8.inaluma.persistence.repository.PagamentoRepository;
import lombok.AllArgsConstructor;


@Service @AllArgsConstructor
public class PagamentoService {
  @Autowired private PagamentoRepository repository;

  public Pagamento findById(Long id) { return repository.findById(id).get(); }
  public List<Pagamento> findAll() { return repository.findAll(); }
  public Pagamento create(Pagamento dto) { return repository.save(dto); }
  public Pagamento update(Pagamento dto) { return repository.save(dto); }
  public void delete(Long id) { repository.deleteById(id); }
}
