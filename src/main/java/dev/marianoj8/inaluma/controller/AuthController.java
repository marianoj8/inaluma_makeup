package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.persistence.model.entity.utils.Gender;
import dev.marianoj8.inaluma.persistence.service.ApplicationUserService;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;


@RestController
@RequestMapping("v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ApplicationUserService userService;

    record SignRequest(
            String username,
            String password
    ) {

    }

    record SignResponse(
            Long userId,
            String username,
            String nome,
            String sobrenome,
            String contato,
            boolean estado,
            Gender genero,
            String perfil
    ) {

    }

    record UnauthorizedResponse(String errorMessage) {
    }

    @PostMapping("sign-in")
    public ResponseEntity<SignResponse> signIn(@RequestBody SignRequest request) {
        var result = userService.getByUsernameAndPassword(request.username, request.password);

        SignResponse response;
        if (result != null) {
            if (result.getFuncionario() != null && result.getPerfil().contains("ADMIN")) {
                response = new SignResponse(
                        result.getId(),
                        result.getUsername(),
                        result.getFuncionario().getNome(),
                        result.getFuncionario().getSobrenome(),
                        result.getFuncionario().getContato(),
                        true,
                        result.getFuncionario().getGenero(),
                        "ADMIN");
            } else if (result.getFuncionario() != null && result.getPerfil().contains("FUNCIONARIO")) {
                response = new SignResponse(
                        result.getId(),
                        result.getUsername(),
                        result.getFuncionario().getNome(),
                        result.getFuncionario().getSobrenome(),
                        result.getFuncionario().getContato(),
                        true,
                        result.getFuncionario().getGenero(),
                        "FUNCIONARIO");
            } else if (result.getCliente() != null && result.getPerfil().contains("CLIENTE")) {
                response = new SignResponse(
                        result.getId(),
                        result.getUsername(),
                        result.getCliente().getNome(),
                        result.getCliente().getSobrenome(),
                        result.getCliente().getContato(),
                        true,
                        null,
                        "CLIENTE");
            } else {
                throw new RuntimeException("UNAUTHORIZED");
            }
        } else {
            throw new RuntimeException("UNAUTHORIZED");
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
