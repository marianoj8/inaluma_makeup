package dev.marianoj8.inaluma.persistence.service;

import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.TipoArtigo;
import dev.marianoj8.inaluma.persistence.repository.TipoArtigoRepository;
import dev.marianoj8.inaluma.persistence.service.util.BaseService;

@Service
public class TipoArtigoServico extends BaseService<TipoArtigo, TipoArtigoRepository>{ }
