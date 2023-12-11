package dev.marianoj8.inaluma.persistence.model.mapper;

import dev.marianoj8.inaluma.persistence.model.dto.ApplicationUserDto;
import dev.marianoj8.inaluma.persistence.model.entity.ApplicationUser;

public class ApplicationUserMapper {

    public static ApplicationUserDto modelToDto(ApplicationUser model) {
        return model == null ? null : new ApplicationUserDto(
                model.getId(),
                model.getCreatedAt(),
                model.getLastModifiedAt(),
                model.getTotalModified(),
                model.getUsername(),
                model.getTipo(),
                model.getPassword(),
                model.isEstado(),
                model.getFuncionario(),
                model.getCliente());
    }

    public static ApplicationUser dtoToModel(ApplicationUserDto dto) {
        return dto == null ? null : new ApplicationUser(
                dto.id(),
                dto.createdAt(),
                dto.lastModifiedAt(),
                dto.totalModified(),
                dto.username(),
                dto.tipo(),
                dto.password(),
                dto.estado(),
                dto.funcionario(),
                dto.cliente());
    }
}
