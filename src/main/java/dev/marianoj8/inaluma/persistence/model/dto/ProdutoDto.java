package dev.marianoj8.inaluma.persistence.model.dto;

import java.time.LocalDateTime;

public record ProdutoDto(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt,
        int totalModified,
        String nome,
        String descricao,
        String tipo,
        boolean estado,
        double preco,
        int stock,
        String code) {
}
