package dev.marianoj8.inaluma.persistence.model.mapper;

import dev.marianoj8.inaluma.persistence.model.dto.VendaDto;
import dev.marianoj8.inaluma.persistence.model.entity.Venda;

public class VendaMapper {
    public static Venda dtoToModel(VendaDto dto) {
        return dto == null ? null : new Venda(
                dto.id(),
                dto.createdAt(),
                dto.lastModifiedAt(),
                dto.totalModified(),
                dto.total(),
                dto.qty(),
                dto.cliente(),
                dto.produto(),
                dto.funcionario());
    }

    public static VendaDto modelToDto(Venda model) {
        return model == null ? null : new VendaDto(
                model.getId(),
                model.getCreatedAt(),
                model.getLastModifiedAt(),
                model.getTotalModified(),
                model.getTotal(),
                model.getQty(),
                model.getCliente(),
                model.getProduto(),
                model.getFuncionario());
    }
}
