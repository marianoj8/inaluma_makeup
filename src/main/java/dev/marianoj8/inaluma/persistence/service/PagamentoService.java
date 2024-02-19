package dev.marianoj8.inaluma.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.Pagamento;
import dev.marianoj8.inaluma.persistence.repository.PagamentoRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service @NoArgsConstructor
public class PagamentoService extends BaseService<Pagamento, PagamentoRepository> {
  public List<Pagamento> fetchByFacturaId(@NonNull Long id) { return repository.fetchByFacturaId(id); }
  public List<Pagamento> fetchByOperadorId(@NonNull Long id) { return repository.fetchByOperadorId(id); }
}
