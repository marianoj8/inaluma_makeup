package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.controller.util.BaseControllerWithInserts;
import dev.marianoj8.inaluma.persistence.model.entity.Pagamento;
import dev.marianoj8.inaluma.persistence.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/pagamentos")
public class PagamentoController extends BaseControllerWithInserts<Pagamento, PagamentoService> {
  @GetMapping("fetchBy/facturaId/{id}")
  public ResponseEntity<List<Pagamento>> fetchByFacturaId(@NonNull Long id) {
    var res = service.fetchByFacturaId(id);
    return (res == null) ? new ResponseEntity<List<Pagamento>>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(res);
  }

  @GetMapping("fetchBy/operadorId/{id}")
  public ResponseEntity<List<Pagamento>> fetchByOperadorId(@NonNull Long id) {
    var res = service.fetchByOperadorId(id);
    return (res == null) ? new ResponseEntity<List<Pagamento>>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(res);
  }
}
