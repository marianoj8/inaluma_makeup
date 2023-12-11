package dev.marianoj8.inaluma.persistence.model.dto;

import dev.marianoj8.inaluma.persistence.model.entity.Funcionario;
import dev.marianoj8.inaluma.persistence.model.entity.utils.TimeUnits;

import java.time.LocalDateTime;

public record ServicoDto(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt,
        int totalModified,
        String nome,
        String descricao,
        double preco,
        int duracao,
        TimeUnits units,
        boolean estado,
        Funcionario funcionario) {
}
