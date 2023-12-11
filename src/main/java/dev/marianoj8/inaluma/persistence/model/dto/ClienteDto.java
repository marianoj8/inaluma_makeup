package dev.marianoj8.inaluma.persistence.model.dto;

import dev.marianoj8.inaluma.persistence.model.entity.utils.Gender;

import java.time.LocalDateTime;

public record ClienteDto(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt,
        int totalModified,
        String nome,
        String sobrenome,
        Gender gender,
        String phone) {
}
