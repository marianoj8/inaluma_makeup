package dev.marianoj8.inaluma.persistence.service;

import dev.marianoj8.inaluma.persistence.exceptions.FileStorageException;
import dev.marianoj8.inaluma.persistence.model.entity.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static dev.marianoj8.inaluma.persistence.model.mapper.ProdutoMapper.modelToDto;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DbFileService {

    private final ProdutoService service;

    // ApplicationUser profile photo
    public Produto getProductImg(Long productId) {
        Produto user = service.getById(productId);
        if (user.getId() != null) {
            return user;
        } else {
            // throw new MyFileNotFoundException("File not found with id " + fileId);
            return null;
        }
    }

    public Produto storeProductImg(MultipartFile file, Long productId) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            } else {
                String v = String.valueOf(file.getSize());
                double fixedSize = ((Double.parseDouble(v) / 1024) / 1024);

                Produto produto = service.getById(productId);
                produto.setData(file.getBytes());
                produto.setFileName(fileName);
                produto.setContentType(file.getContentType());
                produto.setFixedSize(fixedSize);

                return service.update(modelToDto(produto));
            }
        } catch (IOException ioe) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ioe);
        }
    }
}
