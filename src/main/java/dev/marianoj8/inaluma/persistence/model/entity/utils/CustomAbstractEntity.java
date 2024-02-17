package dev.marianoj8.inaluma.persistence.model.entity.utils;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data @NoArgsConstructor @EqualsAndHashCode(onlyExplicitlyIncluded = true) @MappedSuperclass
public class CustomAbstractEntity {
  protected Integer totalModified;

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @EqualsAndHashCode.Include
  protected Long id;

  @Column(updatable = false) @CreationTimestamp @Temporal(TemporalType.TIMESTAMP)
  protected LocalDateTime createdAt;

  @Temporal(TemporalType.TIMESTAMP) @UpdateTimestamp
  protected LocalDateTime lastModifiedAt;

  @Column(nullable = false, columnDefinition = "Bit(1) default 0")
  private boolean eliminado = false;
}
