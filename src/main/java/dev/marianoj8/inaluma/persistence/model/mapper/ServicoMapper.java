package dev.marianoj8.inaluma.persistence.model.mapper;

import dev.marianoj8.inaluma.persistence.model.dto.ServicoDto;
import dev.marianoj8.inaluma.persistence.model.entity.Servico;

public class ServicoMapper {
    public static Servico dtoToModel(ServicoDto dto) {
        return dto == null ? null : new Servico(
                dto.id(),
                dto.createdAt(),
                dto.lastModifiedAt(),
                dto.totalModified(),
                dto.nome(),
                dto.descricao(),
                dto.preco(),
                dto.duracao(),
                dto.units(),
                dto.estado(),
                dto.funcionario()
        );
    }

    public static ServicoDto modelToDto(Servico model) {
        return model == null ? null : new ServicoDto(
                model.getId(),
                model.getCreatedAt(),
                model.getLastModifiedAt(),
                model.getTotalModified(),
                model.getNome(),
                model.getDescricao(),
                model.getPreco(),
                model.getDuracao(),
                model.getUnits(),
                model.isEstado(),
                model.getFuncionario());
    }
}
