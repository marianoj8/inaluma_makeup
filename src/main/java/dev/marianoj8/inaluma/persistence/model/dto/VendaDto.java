package dev.marianoj8.inaluma.persistence.model.dto;

import dev.marianoj8.inaluma.persistence.model.entity.Cliente;
import dev.marianoj8.inaluma.persistence.model.entity.Funcionario;
import dev.marianoj8.inaluma.persistence.model.entity.Produto;

import java.time.LocalDateTime;

public record VendaDto(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt,
        int totalModified,
        double total,
        double qty,
        Cliente cliente,
        Produto produto,
        Funcionario funcionario) {
}
