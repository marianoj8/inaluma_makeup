package dev.marianoj8.inaluma.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "api/v1/hello")
    public String message() {
        return "Olá, Spring!";
    }

    @GetMapping(path = "api/v1/hello/{name}")
    public String messageWithName(@PathVariable String name) {
        return String.format("Olá, %s! Seja bem-vindo!", name);
    }
}
