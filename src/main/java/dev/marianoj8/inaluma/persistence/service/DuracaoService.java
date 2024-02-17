package dev.marianoj8.inaluma.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marianoj8.inaluma.persistence.model.entity.Duracao;
import dev.marianoj8.inaluma.persistence.repository.DuracaoRepository;
import lombok.AllArgsConstructor;


@Service @AllArgsConstructor
public class DuracaoService {
  @Autowired private DuracaoRepository repository;
}