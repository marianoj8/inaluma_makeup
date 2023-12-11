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
public class Funcionario extends CustomAbstractEntity {
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String contacto;
    private boolean estado;
    @Column(columnDefinition = "char(1) default 'M'")
    private Gender genero;

    public Funcionario(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, int totalModified, String nome,
                       String sobrenome, String contacto, boolean estado, Gender genero) {
        super(id, createdAt, lastModifiedAt, totalModified);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.contacto = contacto;
        this.estado = estado;
        this.genero = genero;
    }
}
