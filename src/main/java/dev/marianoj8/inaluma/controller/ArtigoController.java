package dev.marianoj8.inaluma.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.marianoj8.inaluma.controller.util.BaseControllerWithInserts;
import dev.marianoj8.inaluma.persistence.model.entity.Artigo;
import dev.marianoj8.inaluma.persistence.service.ArtigoService;

@RestController
@RequestMapping("v1/artigos")
public class ArtigoController extends BaseControllerWithInserts<Artigo, ArtigoService> {
  @GetMapping("fetchBy/tipo/id/{id}")
  public ResponseEntity<List<Artigo>> fetchByTipoId(@PathVariable Long id) { return ResponseEntity.ok(service.fetchByTipoId(id)); }

  @GetMapping("fetch/servicos")
  public ResponseEntity<List<Artigo>> fetchServicos() { return ResponseEntity.ok(service.fetchServicos()); }

  @GetMapping("fetch/produtos")
  public ResponseEntity<List<Artigo>> fetchProdutos() { return ResponseEntity.ok(service.fetchServicos()); }
}