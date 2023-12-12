package dev.marianoj8.inaluma.persistence.model.mapper;

import dev.marianoj8.inaluma.persistence.model.dto.ClienteDto;
import dev.marianoj8.inaluma.persistence.model.entity.Cliente;

public class ClienteMapper {

    public static Cliente dtoToModel(ClienteDto dto) {
        return dto == null ? null : new Cliente(
                dto.id(),
                dto.createdAt(),
                dto.lastModifiedAt(),
                dto.totalModified(),
                dto.nome(),
                dto.sobrenome(),
                dto.gender(),
                dto.phone());
    }

    public static ClienteDto modelToDto(Cliente model) {
        return model == null ? null : new ClienteDto(
                model.getId(),
                model.getCreatedAt(),
                model.getLastModifiedAt(),
                model.getTotalModified(),
                model.getNome(),
                model.getSobrenome(),
                model.getGender(),
                model.getPhone());
    }


}
