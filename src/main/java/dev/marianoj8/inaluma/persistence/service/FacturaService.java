package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.entity.Factura;
import dev.marianoj8.inaluma.persistence.repository.FacturaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class FacturaService {
    private FacturaRepository repository;

    public Factura getById(Long id) {
        return repository.findOne(id);
    }

    public List<Factura> fetch() {
        return repository.findAll();
    }

    public Factura create(Factura factura) {
        var facturaSaved = repository.save(factura);
        facturaSaved.setNumeroFatura(factura.getId() + "/" + LocalDateTime.now().getYear());

        return repository.save(facturaSaved);
    }

    public Factura update(Factura factura) {
        return repository.save(factura);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Factura getByClienteId(Long clienteId) {
        return repository.getByClienteId(clienteId);
    }

    public Factura getByAgendamentoId(Long agendamentoId) {
        return repository.getByAgendamentoId(agendamentoId);
    }
}
