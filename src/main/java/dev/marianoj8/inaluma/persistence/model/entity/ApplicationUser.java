package dev.marianoj8.inaluma.persistence.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
public class ApplicationUser extends CustomAbstractEntity {
    @Column(unique = true, nullable = false)
    private String username;
    private String tipo;
    @Column(nullable = false)
    private String password;
    private boolean estado;

    @ManyToOne(targetEntity = Funcionario.class, optional = true)
    private Funcionario funcionario;

    @ManyToOne(targetEntity = Cliente.class, optional = true)
    private Cliente cliente;

    public ApplicationUser(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, int totalModified,
                           String username, String tipo, String password,
                           boolean estado, Funcionario funcionario, Cliente cliente) {
        super(id, createdAt, lastModifiedAt, totalModified);
        this.username = username;
        this.tipo = tipo;
        this.password = password;
        this.estado = estado;
        this.funcionario = funcionario;
        this.cliente = cliente;
    }
}
