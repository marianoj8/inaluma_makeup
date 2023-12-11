package dev.marianoj8.inaluma.persistence.model.mapper;

import dev.marianoj8.inaluma.persistence.model.dto.PagamentoDto;
import dev.marianoj8.inaluma.persistence.model.entity.Pagamento;

public class PagamentoMapper {

    public static Pagamento dtoToModel(PagamentoDto dto) {
        return dto == null ? null : new Pagamento(
                dto.id(),
                dto.createdAt(),
                dto.lastModifiedAt(),
                dto.totalModified(),
                dto.status(),
                dto.metodo(),
                dto.valorPagamento(),
                dto.agendamento(),
                dto.venda());
    }

    public static PagamentoDto modelToDto(Pagamento model) {
        return model == null ? null : new PagamentoDto(
                model.getId(),
                model.getCreatedAt(),
                model.getLastModifiedAt(),
                model.getTotalModified(),
                model.getStatus(),
                model.getMetodo(),
                model.getValorPagamento(),
                model.getAgendamento(),
                model.getVenda());
    }
}
