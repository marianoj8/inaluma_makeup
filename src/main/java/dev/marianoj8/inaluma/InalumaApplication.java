package dev.marianoj8.inaluma;

import dev.marianoj8.inaluma.persistence.model.entity.ApplicationUser;
import dev.marianoj8.inaluma.persistence.model.entity.Cliente;
import dev.marianoj8.inaluma.persistence.model.entity.Funcionario;
import dev.marianoj8.inaluma.persistence.model.entity.utils.Gender;
import dev.marianoj8.inaluma.persistence.service.ApplicationUserService;
import dev.marianoj8.inaluma.persistence.service.ClienteService;
import dev.marianoj8.inaluma.persistence.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class InalumaApplication implements CommandLineRunner {
    private final ApplicationUserService applicationUserService;
    private final FuncionarioService funcionarioService;
    private final ClienteService clienteService;

    public static void main(String[] args) {
        SpringApplication.run(InalumaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (applicationUserService.fetch().isEmpty()) {


            Cliente c = new Cliente();
            c.setNome("Mariano");
            c.setSobrenome("JavaSwing");
            c.setGenero(Gender.M);
            c.setContato("932 518 145");


            Funcionario f1 = new Funcionario();
            f1.setNome("Valenia");
            f1.setSobrenome("Araujo");
            f1.setGenero(Gender.F);
            f1.setContato("934 945 098");
            f1.setEstado(true);
            f1.setCreatedAt(LocalDateTime.now());


            Funcionario f2 = new Funcionario();
            f2.setNome("Peidoso");
            f2.setSobrenome("Pedro");
            f2.setGenero(Gender.M);
            f2.setContato("932 943 000");
            f2.setEstado(true);
            f2.setCreatedAt(LocalDateTime.now());


            Cliente cliente = clienteService.create(c);
            Funcionario funcionario1 = funcionarioService.create(f1);
            Funcionario funcionario2 = funcionarioService.create(f2);


            ApplicationUser a1 = new ApplicationUser();
            a1.setFuncionario(funcionario1);
            a1.setUsername("valenia22");
            a1.setPassword("password");
            a1.setEstado(true);
            a1.setPerfil("ADMIN");
            a1.setCreatedAt(LocalDateTime.now());

            ApplicationUser a2 = new ApplicationUser();
            a2.setFuncionario(funcionario2);
            a2.setUsername("piedoso1L");
            a2.setPassword("password");
            a2.setEstado(true);
            a2.setPerfil("FUNCIONARIO");
            a2.setCreatedAt(LocalDateTime.now());

            ApplicationUser a3 = new ApplicationUser();
            a3.setCliente(cliente);
            a3.setUsername("marianojs8");
            a3.setPassword("password");
            a3.setEstado(true);
            a3.setPerfil("CLIENTE");
            a3.setCreatedAt(LocalDateTime.now());

            applicationUserService.create(a1);
            applicationUserService.create(a2);
            applicationUserService.create(a3);
        }
    }
}
