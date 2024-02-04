package dev.marianoj8.inaluma.persistence.model.entity;

import dev.marianoj8.inaluma.persistence.model.entity.utils.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente extends CustomAbstractEntity {
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    private Gender genero = Gender.M;
    @Column(unique = true, nullable = false)
    private String contato;

    public Cliente(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, int totalModified, String nome,
                   String sobrenome, Gender genero, String contato) {
        super(id, createdAt, lastModifiedAt, totalModified);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.contato = contato;
    }
}
