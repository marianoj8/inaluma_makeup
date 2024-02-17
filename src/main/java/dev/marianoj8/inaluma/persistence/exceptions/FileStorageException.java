package dev.marianoj8.inaluma.persistence.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FileStorageException extends RuntimeException {
  public FileStorageException(String message) {
    super(message);
  }

  public FileStorageException(String message, Throwable cause) {
    super(message, cause);
  }
}
