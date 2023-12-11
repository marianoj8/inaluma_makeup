package dev.marianoj8.inaluma.persistence.model.mapper;

import dev.marianoj8.inaluma.persistence.model.dto.FuncionarioDto;
import dev.marianoj8.inaluma.persistence.model.entity.Funcionario;

public class FuncionarioMapper {
    public static Funcionario dtoToModel(FuncionarioDto dto) {
        return dto == null ? null : new Funcionario(
                dto.id(),
                dto.createdAt(),
                dto.lastModifiedAt(),
                dto.totalModified(),
                dto.nome(),
                dto.sobrenome(),
                dto.contacto(),
                dto.estado(),
                dto.genero());
    }

    public static FuncionarioDto modelToDto(Funcionario model) {
        return model == null ? null : new FuncionarioDto(
                model.getId(),
                model.getCreatedAt(),
                model.getLastModifiedAt(),
                model.getTotalModified(),
                model.getNome(),
                model.getSobrenome(),
                model.getContacto(),
                model.isEstado(),
                model.getGenero());
    }
}
