package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.exceptions.FileStorageException;
import dev.marianoj8.inaluma.persistence.model.entity.Artigo;
import dev.marianoj8.inaluma.persistence.model.entity.File;
import dev.marianoj8.inaluma.persistence.model.entity.User;
import dev.marianoj8.inaluma.persistence.model.entity.utils.ImageUtils;
import dev.marianoj8.inaluma.persistence.repository.FileRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service @AllArgsConstructor
public class FileService {
  @Autowired private FileRepository repository;
  
  public File fetchByUserId(Long id) { return prepareDownload(id, true); }
  public File fetchByArtigoId(Long id) { return prepareDownload(id, false); }

  private File prepareDownload(Long id, Boolean forUser) {
    final File file = forUser ? repository.fetchByUserId(id) : repository.fetchByArtigoId(id);
    file.setData(ImageUtils.descomprimirImagem(file.getData()));

    return file;
  }

  public File saveFile(MultipartFile multiFile, File file) {
    try {
      var fileName = StringUtils.cleanPath(multiFile.getOriginalFilename());
      var fixedSize = Double.parseDouble(String.valueOf(multiFile.getSize()))/1024/1024;

      file.setFileName(fileName);
      file.setContentType(multiFile.getContentType());
      file.setFixedSize(fixedSize);
      file.setData(ImageUtils.comprimirImagem(multiFile.getBytes()));

      return file;
    } catch (IOException e) { throw new FileStorageException("Could not store file Please try again!"); }
  }
}
