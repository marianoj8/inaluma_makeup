package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.controller.util.BaseControllerWithInserts;
import dev.marianoj8.inaluma.persistence.model.entity.Categoria;
import dev.marianoj8.inaluma.persistence.service.CategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/categorias")
public class CategoriaController extends BaseControllerWithInserts<Categoria, CategoriaService> { }
