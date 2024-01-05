package dev.marianoj8.inaluma.persistence.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
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
public class Produto extends CustomAbstractEntity {
    @Column(unique = true, nullable = false)
    private String nome;
    private String descricao;
    private String tipo;
    private boolean estado;
    @Column(nullable = false)
    private double preco;
    private int stock;
    private String code;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] data;

    private String fileName;
    private String contentType;
    private double fixedSize;

    public Produto(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, int totalModified, String nome,
                   String descricao, String tipo, boolean estado, double preco, int stock, String code, byte[] data, String fileName, String contentType, double fixedSize) {
        super(id, createdAt, lastModifiedAt, totalModified);
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.estado = estado;
        this.preco = preco;
        this.stock = stock;
        this.code = code;
        
        this.data = data;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fixedSize = fixedSize;
    }
}
