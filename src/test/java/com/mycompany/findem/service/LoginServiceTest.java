package com.mycompany.findem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.findem.model.FormLogin;
import com.mycompany.findem.model.User;
import com.mycompany.findem.repository.UserRepository;
/**
 *
 * @author Julia
 */
public class LoginServiceTest {

    private UserRepository repository;
    private LoginService service;

    @BeforeEach
    void setup() {
        repository = new UserRepository();
        service = new LoginService(repository);

        // criando usuário já cadastrado
        User user = new User();
        user.setNome("Julia");
        user.setEmail("julia@gmail.com");
        user.setPassword("123456");
        user.setContato("81999999999");

        repository.salvar(user);
    }

    @Test
    void deveRealizarLoginComSucesso() {

        FormLogin form = new FormLogin();
        form.setEmail("julia@gmail.com");
        form.setPassword("123456");

        User user = service.login(form);

        assertNotNull(user);
        assertTrue(user.isLogado());
    }

    @Test
    void loginComEmailVazio() {

        FormLogin form = new FormLogin();
        form.setEmail("");
        form.setPassword("123456");

        User user = service.login(form);

        assertNull(user);
    }

    @Test
    void loginComEmailInvalido() {

        FormLogin form = new FormLogin();
        form.setEmail("julia@hotmail.com");
        form.setPassword("123456");

        User user = service.login(form);

        assertNull(user);
    }

    @Test
    void loginComSenhaVazia() {

        FormLogin form = new FormLogin();
        form.setEmail("julia@gmail.com");
        form.setPassword("");

        User user = service.login(form);

        assertNull(user);
    }

    @Test
    void loginComEmailNaoCadastrado() {

        FormLogin form = new FormLogin();
        form.setEmail("pedro@gmail.com");
        form.setPassword("123456");

        User user = service.login(form);

        assertNull(user);
    }

    @Test
    void loginComSenhaErrada() {

        FormLogin form = new FormLogin();
        form.setEmail("julia@gmail.com");
        form.setPassword("000000");

        User user = service.login(form);

        assertNull(user);
    }
}