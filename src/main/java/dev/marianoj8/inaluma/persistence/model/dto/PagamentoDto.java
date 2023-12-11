package dev.marianoj8.inaluma.persistence.model.dto;

import dev.marianoj8.inaluma.persistence.model.entity.Agendamento;
import dev.marianoj8.inaluma.persistence.model.entity.Venda;

import java.time.LocalDateTime;

public record PagamentoDto(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt,
        int totalModified,
        String status,
        String metodo,
        double valorPagamento,
        Agendamento agendamento,
        Venda venda) {
}
