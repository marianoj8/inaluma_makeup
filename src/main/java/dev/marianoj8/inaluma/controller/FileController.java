package com.wasp.avt.endpoint.v1.controller.file;

import com.wasp.avt.persistence.model.models.ApplicationUser;
import com.wasp.avt.persistence.model.models.Comprovativo;
import com.wasp.avt.persistence.model.models.ProForma;
import com.wasp.avt.persistence.security.filter.SecurityConstants;
import com.wasp.avt.persistence.utils.payloads.DbFileService;
import com.wasp.avt.persistence.utils.payloads.UploadFileResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static com.wasp.avt.persistence.security.filter.SecurityConstants.HEADER_STRING;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "v1/files")
@SecurityRequirement(name = HEADER_STRING)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileEndpoint {

    private final DbFileService dbFileService;


    @GetMapping(value = "file1/{pedidoId}")
    public ResponseEntity<ProForma> getProformaIdbyPedidoId(@PathVariable("pedidoId") Long pedidoId) {
        return new ResponseEntity<>(dbFileService.getFile1Id(pedidoId), OK);
    }

    @GetMapping("file2/{pedidoId}")
    public ResponseEntity<Comprovativo> getComprovativoIdbyPedidoId(@PathVariable("pedidoId") Long pedidoId) {
        return new ResponseEntity<>(dbFileService.getFile2Id(pedidoId), OK);
    }

    @GetMapping(path = "factura/{fileId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<Resource> downloadFile1(@PathVariable Long fileId) {
//        log.info("Loading file from database");
        ProForma file = dbFileService.getFile1(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, SecurityConstants.HEADER_VALUE_STRING)
                .allow(HttpMethod.GET)
                .body(new ByteArrayResource(file.getData()));
    }

    @GetMapping(path = "comprovativo/{fileId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<Resource> downloadFile2(@PathVariable Long fileId) {
//        log.info("Loading file from database");
        Comprovativo file = dbFileService.getFile2(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, SecurityConstants.HEADER_VALUE_STRING)
                .allow(HttpMethod.GET)
                .body(new ByteArrayResource(file.getData()));
    }

    //     @PreAuthorize("hasAuthority('file:update')")
    @Transactional
    @PostMapping(path = "factura/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
                                         @RequestParam("pedidosId") Long pedidosId) {

        ProForma data = dbFileService.storeFile1(file, pedidosId);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/v1/files/factura")
                .path("" + data.getId())
                .toUriString();

        return new UploadFileResponse(
                data.getFileName(),
                fileDownloadUri,
                file.getContentType(),
                file.getSize());
    }

    @Transactional
    @PostMapping(path = "comprovativo/uploadFile")
    public UploadFileResponse uploadFile2(@RequestParam("file") MultipartFile file,
                                          @RequestParam("pedidosId") Long pedidosId) {

        Comprovativo data = dbFileService.storeFile2(file, pedidosId);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/v1/files/comprovativo")
                .path("" + data.getId())
                .toUriString();

        return new UploadFileResponse(
                data.getFileName(),
                fileDownloadUri,
                file.getContentType(),
                file.getSize());
    }


    @Transactional
    @PostMapping(path = "profile/img")
    public UploadFileResponse uploadImage(@RequestParam("file") MultipartFile file,
                                          @RequestParam("userId") Long userId) {

        ApplicationUser data = dbFileService.storeProfileImg(file, userId);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/v1/files/profile/")
                .path("" + data.getId())
                .toUriString();

        return new UploadFileResponse(data.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
    }

    @GetMapping(path = "profile/{userId}")
    public ResponseEntity<Resource> downloadImage(@PathVariable Long userId) {
//        log.info("Loading file from database");
        ApplicationUser user = dbFileService.getProfleImg(userId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(user.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
                .allow(HttpMethod.GET)
                .body(new ByteArrayResource(user.getImg()));
    }
}
