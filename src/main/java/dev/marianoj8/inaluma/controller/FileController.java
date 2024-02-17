package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.persistence.model.entity.File;
import dev.marianoj8.inaluma.persistence.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController @RequestMapping(path = "v1/files")
public class FileController {
  @Autowired private FileService service;
  
  @GetMapping(path = "fetchBy/userId/{id}")
  public ResponseEntity<Resource> fetchByUserId(@NonNull @PathVariable Long id) { return prepareDownload(service.fetchByUserId(id)); }

  @GetMapping(path = "fetchBy/artigoId/{id}")
  public ResponseEntity<Resource> fetchByArtigoId(@NonNull @PathVariable Long id) { return prepareDownload(service.fetchByArtigoId(id)); }

  @PostMapping(path = "new")
  public ResponseEntity<File> create(@RequestParam(name = "multi_file", required = true) MultipartFile multiFile, @RequestBody(required = true) File file) {
    return saveOrUpdate(multiFile, file);
  }

  @PutMapping(path = "update")
  public ResponseEntity<File> update(@RequestParam(name = "multi_file", required = true) MultipartFile multiFile, @RequestBody(required = true) File file) {
    return saveOrUpdate(multiFile, file);
  }

  private Boolean isValidFile(File file) { return (file.getUser() != null) || (file.getArtigo() != null); }

  private ResponseEntity<File> saveOrUpdate(MultipartFile multiFile, File file) {
    return isValidFile(file) ? ResponseEntity.ok(service.saveFile(multiFile, file)) : new ResponseEntity<File>(HttpStatus.BAD_REQUEST);
  }

  private ResponseEntity<Resource> prepareDownload(File file) {
    return ResponseEntity.ok()
      .contentType(MediaType.parseMediaType(file.getContentType()))
      .header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
      .allow(HttpMethod.GET)
      .body(new ByteArrayResource(file.getData()));
  }
}
