package dev.marianoj8.inaluma.persistence.model.dto;

import dev.marianoj8.inaluma.persistence.model.entity.Cliente;
import dev.marianoj8.inaluma.persistence.model.entity.Funcionario;

import java.time.LocalDateTime;

public record ApplicationUserDto(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt,
        int totalModified,
        String username,
        String tipo,
        String password,
        boolean estado,
        Funcionario funcionario,
        Cliente cliente) {
}
