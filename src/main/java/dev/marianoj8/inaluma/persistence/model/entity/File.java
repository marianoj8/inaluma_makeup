package dev.marianoj8.inaluma.persistence.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;

import dev.marianoj8.inaluma.persistence.model.entity.utils.CustomAbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @Entity @NoArgsConstructor
public class File extends CustomAbstractEntity {
  @NotEmpty private String fileName;
  @NonNull @NotEmpty private String contentType;
  @NotNull private double fixedSize;

  @NonNull @Lob @Column(columnDefinition = "longblob")
  private byte[] data;

  @OneToOne(targetEntity = User.class) @OnDelete(action = OnDeleteAction.CASCADE) 
  private User user;

  @OneToOne(targetEntity = Artigo.class) @OnDelete(action = OnDeleteAction.CASCADE) 
  private Artigo artigo;

  public File setData(byte[] data) { 
    this.data = data;
    return this;
  }

  public File(String fileName, String contentType, double fixedSize, byte[] data) {
    super();
    this.fileName = fileName;
    this.contentType = contentType;
    this.data = data;
  }
}
