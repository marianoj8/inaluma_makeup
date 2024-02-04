package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.persistence.model.entity.Produto;
import dev.marianoj8.inaluma.persistence.model.entity.Servico;
import dev.marianoj8.inaluma.persistence.service.DbFileService;
import dev.marianoj8.inaluma.persistence.util.UploadFileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "v1/files")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileController {

    private final DbFileService dbFileService;

    @Transactional
    @PostMapping(path = "product/img")
    public UploadFileResponse uploadImage(@RequestParam("file") MultipartFile file,
                                          @RequestParam("productId") Long productId) {

        Produto produto = dbFileService.storeProdutcImg(file, productId);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/v1/files/product/")
                .path("" + produto.getId())
                .toUriString();

        return new UploadFileResponse(produto.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
    }

    @GetMapping(path = "product/{productId}")
    public ResponseEntity<Resource> downloadImage(@PathVariable Long productId) {
//        log.info("Loading file from database");
        Produto produto = dbFileService.getProductImg(productId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(produto.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
                .allow(HttpMethod.GET)
                .body(new ByteArrayResource(produto.getData()));
    }


    @Transactional
    @PutMapping(path = "product/img")
    public UploadFileResponse updateImage(@RequestParam("file") MultipartFile file,
                                          @RequestParam("productId") Long productId) {

        Produto produto = dbFileService.storeProdutcImg(file, productId);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/v1/files/product/")
                .path("" + produto.getId())
                .toUriString();

        return new UploadFileResponse(produto.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
    }


    @Transactional
    @PostMapping(path = "service/img")
    public UploadFileResponse uploadServiceImage(@RequestParam("file") MultipartFile file,
                                                 @RequestParam("serviceId") Long serviceId) {

        Servico service = dbFileService.storeServiceImg(file, serviceId);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/v1/files/service/")
                .path("" + service.getId())
                .toUriString();

        return new UploadFileResponse(service.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
    }

    @Transactional
    @PutMapping(path = "service/img")
    public UploadFileResponse updateServiceImage(@RequestParam("file") MultipartFile file,
                                                 @RequestParam("serviceId") Long serviceId) {

        Servico service = dbFileService.storeServiceImg(file, serviceId);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/v1/files/service/")
                .path("" + service.getId())
                .toUriString();

        return new UploadFileResponse(service.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
    }

    @GetMapping(path = "service/{serviceId}")
    public ResponseEntity<Resource> downloadServiceImage(@PathVariable Long serviceId) {
//        log.info("Loading file from database");
        Servico servico = dbFileService.getServiceImg(serviceId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(servico.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
                .allow(HttpMethod.GET)
                .body(new ByteArrayResource(servico.getData()));
    }
}
