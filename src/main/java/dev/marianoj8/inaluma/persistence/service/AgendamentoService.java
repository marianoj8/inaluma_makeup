package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.model.entity.Agendamento;
import dev.marianoj8.inaluma.persistence.repository.AgendamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AgendamentoService {
    private AgendamentoRepository repository;

    public Agendamento getById(Long id) {
        return repository.getReferenceById(id);
    }

    public List<Agendamento> fetch() {
        return repository.findAll();
    }

    public Agendamento create(Agendamento agendamento) {
        var agendamentoSaved =  repository.save(agendamento);
        agendamentoSaved.setNumeroAgendamento(agendamentoSaved.getId() + "/" + LocalDateTime.now().getYear());
        return repository.save(agendamentoSaved);
    }

    public Agendamento update(Agendamento agendamento) {
        return repository.save(agendamento);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
