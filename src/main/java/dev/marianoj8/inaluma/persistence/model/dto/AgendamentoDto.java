package dev.marianoj8.inaluma.persistence.model.dto;

import dev.marianoj8.inaluma.persistence.model.entity.Cliente;
import dev.marianoj8.inaluma.persistence.model.entity.Servico;

import java.time.LocalDateTime;

public record AgendamentoDto(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt,
        int totalModified,
        String status,
        String tipo,
        Cliente cliente,
        Servico servico) {
}
