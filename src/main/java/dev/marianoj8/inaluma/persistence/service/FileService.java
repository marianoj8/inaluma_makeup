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
  @Autowired private UserService usersService;
  @Autowired private ArtigoService artigoService;
  
  protected String tabela() { return "File"; }
  public File retrieveImg(User user) { return prepareDownload(user.getImagem()); }
  public File retrieveImg(Artigo artigo) { return prepareDownload(artigo.getImagem()); }
  public File retrieveImg(@NonNull Long ownerId, Boolean isUser) {
    File img;

    if(isUser) img = usersService.getById(ownerId).getImagem();
    else img = artigoService.getById(ownerId).getImagem();

    return prepareDownload(img);
  }

  private File prepareDownload(@NonNull File f) {
    var file = repository.findById(f.getId());
    return file.get().setData(ImageUtils.descomprimirImagem(f.getData()));
  }

  public File saveFile(MultipartFile f, User owner) {
    owner.setImagem(repository.save(processFile(f)));
    usersService.update(owner);

    return owner.getImagem();
  }

  public File saveFile(MultipartFile f, Artigo owner) {
    owner.setImagem(repository.save(processFile(f)));
    artigoService.update(owner);

    return owner.getImagem();
  }

  private @NonNull File processFile(MultipartFile f) {
    try {
      var fileName = StringUtils.cleanPath(f.getOriginalFilename());
      var fixedSize = Double.parseDouble(String.valueOf(f.getSize()))/1024/1024;  
      return new File(fileName, f.getContentType(), fixedSize, ImageUtils.comprimirImagem(f.getBytes()));
    } catch (IOException e) { throw new FileStorageException("Could not store file Please try again!"); }
  }
}
