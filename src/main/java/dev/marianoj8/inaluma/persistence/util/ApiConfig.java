package dev.marianoj8.inaluma.persistence.util;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
  info = @Info(
    contact = @Contact(
      name = "Mariano JavaSwing",
      email = "marianojs8@yandex.ru",
      url = "https://github.com/marianoj8"
    ),
    description = "OpenApi documentation for INALUMA MAKEUP - API",
    title = "INALUMA MAKEUP - (API)",
    version = "1.0 - Beta",
    license = @License(
      name = "General Public Licence (GPL)",
      url = "https://some-url.com"
    ),
    termsOfService = "Terms of service"
  ),
  servers = {
    @Server(
      description = "Local ENV",
      url = "http://localhost:8080"
    ),
    @Server(
      description = "PROD ENV",
      url = "https://wasp.com/"
    )
  }
)
public class ApiConfig {
}
