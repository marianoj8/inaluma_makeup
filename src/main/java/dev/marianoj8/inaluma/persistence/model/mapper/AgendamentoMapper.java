package dev.marianoj8.inaluma.persistence.model.mapper;

import dev.marianoj8.inaluma.persistence.model.dto.AgendamentoDto;
import dev.marianoj8.inaluma.persistence.model.entity.Agendamento;

public class AgendamentoMapper {
    public static AgendamentoDto modelToDto(Agendamento model) {
        return model == null ? null : new AgendamentoDto(
                model.getId(),
                model.getCreatedAt(),
                model.getLastModifiedAt(),
                model.getTotalModified(),
                model.getStatus(),
                model.getTipo(),
                model.getCliente(),
                model.getServico());
    }

    public static Agendamento dtoToModel(AgendamentoDto dto) {
        return dto == null ? null : new Agendamento(
                dto.id(),
                dto.createdAt(),
                dto.lastModifiedAt(),
                dto.totalModified(),
                dto.status(),
                dto.tipo(),
                dto.cliente(),
                dto.servico()
        );
    }
}
