package dev.marianoj8.inaluma.persistence.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public abstract class AbstractRootDTO {
  protected Long id;
  protected LocalDateTime createdAt;
  protected LocalDateTime lastModifiedAt;
}
