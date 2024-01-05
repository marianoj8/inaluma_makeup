package dev.marianoj8.inaluma.persistence.model.mapper;

import dev.marianoj8.inaluma.persistence.model.dto.ProdutoDto;
import dev.marianoj8.inaluma.persistence.model.entity.Produto;

public class ProdutoMapper {
    public static Produto dtoToModel(ProdutoDto dto) {
        return dto == null ? null : new Produto(
                dto.id(),
                dto.createdAt(),
                dto.lastModifiedAt(),
                dto.totalModified(),
                dto.nome(),
                dto.descricao(),
                dto.tipo(),
                dto.estado(),
                dto.preco(),
                dto.stock(),
                dto.code(),
                dto.data(),
                dto.fileName(),
                dto.contentType(),
                dto.fixedSize()

        );
    }

    public static ProdutoDto modelToDto(Produto model) {
        return model == null ? null : new ProdutoDto(
                model.getId(),
                model.getCreatedAt(),
                model.getLastModifiedAt(),
                model.getTotalModified(),
                model.getNome(),
                model.getDescricao(),
                model.getTipo(),
                model.isEstado(),
                model.getPreco(),
                model.getStock(),
                model.getCode(),
                model.getData(),
                model.getFileName(),
                model.getContentType(),
                model.getFixedSize()
        );
    }
}
