package dev.marianoj8.inaluma.controller;

import dev.marianoj8.inaluma.persistence.model.entity.User;
import dev.marianoj8.inaluma.persistence.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController @RequiredArgsConstructor
@RequestMapping("v1/auth")
public class AuthController {
  private final UserService userService;

  record SignRequest(String username, String password) {}

  @PostMapping("sign-in")
  public ResponseEntity<User> signIn(@RequestBody SignRequest credentials) {
    var result = userService.signIn(credentials.username, credentials.password);

    if (result == null) throw new RuntimeException("NOT FOUND");

    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }
}
