package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.persistence.model.entity.Artigo;
import dev.marianoj8.inaluma.persistence.model.entity.File;
import dev.marianoj8.inaluma.persistence.model.entity.User;
import dev.marianoj8.inaluma.persistence.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(path = "v1/files")
public class FileController {
  @Autowired private FileService service;
  
  @GetMapping(path = "users/img/{userId}")
  public ResponseEntity<Resource> getUserImg(@PathVariable Long userId) { return prepareDownload(service.retrieveImg(userId, true)); }

  @GetMapping(path = "items/img/{itemId}")
  public ResponseEntity<Resource> getItemImg(@PathVariable Long itemId) { return prepareDownload(service.retrieveImg(itemId, false)); }

  private ResponseEntity<Resource> prepareDownload(File file) {
    return ResponseEntity.ok()
      .contentType(MediaType.parseMediaType(file.getContentType()))
      .header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
      .allow(HttpMethod.GET)
      .body(new ByteArrayResource(file.getData()));
  }

  @Transactional
  @PutMapping(path = "users/img")
  public File updateImage(@RequestParam(name = "file", required = true) MultipartFile file, @RequestBody(required = true) User user) {
    return service.saveFile(file, user);
  }

  @Transactional
  @PutMapping(path = "items/img")
  public File updateImage(@RequestParam(name = "file", required = true) MultipartFile file, @RequestBody(required = true) Artigo item) {
    return service.saveFile(file, item);
  }
}
