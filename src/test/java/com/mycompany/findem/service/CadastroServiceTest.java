/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.findem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.mycompany.findem.model.FormCadastro;
import com.mycompany.findem.repository.UserRepository;

/**
 *
 * @author Julia
 */
public class CadastroServiceTest {
    
    @Test
    void testeDeConfiguracao(){
        assertTrue(true);
    }

    @Test
    void deveCadastrarUsuarioComSucesso() {

    UserRepository repository = new UserRepository();
    CadastroService service = new CadastroService(repository);

    FormCadastro form = new FormCadastro();
    form.setNome("Julia");
    form.setEmail("julia@gmail.com");
    form.setPassword("123456");
    form.setConfirmarSenha("123456");
    form.setContato("81999999999");

    String resultado = service.cadastrar(form);
        // resultado esperado
    assertEquals("Cadastro realizado com sucesso", resultado);
    }

    @Test
    void cadastrarComNomeVazio() {

    UserRepository repository = new UserRepository();
    CadastroService service = new CadastroService(repository);

    FormCadastro form = new FormCadastro();
    form.setNome("");
    form.setEmail("julia@gmail.com");
    form.setPassword("123456");
    form.setConfirmarSenha("123456");
    form.setContato("81999999999");

    String resultado = service.cadastrar(form);
        // resultado esperado
    assertEquals("Nome é obrigatório", resultado);
    }

    @Test
    void cadastrarComEmailVazio() {

    UserRepository repository = new UserRepository();
    CadastroService service = new CadastroService(repository);

    FormCadastro form = new FormCadastro();
    form.setNome("Julia");
    form.setEmail("");
    form.setPassword("123456");
    form.setConfirmarSenha("123456");
    form.setContato("81999999999");

    String resultado = service.cadastrar(form);
        // resultado esperado
    assertEquals("Email é obrigatório", resultado);
    }

    @Test
    void cadastrarComSenhaVazio() {

    UserRepository repository = new UserRepository();
    CadastroService service = new CadastroService(repository);

    FormCadastro form = new FormCadastro();
    form.setNome("Julia");
    form.setEmail("julia@gmail.com");
    form.setPassword("");
    form.setConfirmarSenha("123456");
    form.setContato("81999999999");

    String resultado = service.cadastrar(form);
        // resultado esperado
    assertEquals("Senha é obrigatória", resultado);
    }

    @Test
    void cadastrarComConfirmarSenhaVazio() {

    UserRepository repository = new UserRepository();
    CadastroService service = new CadastroService(repository);

    FormCadastro form = new FormCadastro();
    form.setNome("Julia");
    form.setEmail("julia@gmail.com");
    form.setPassword("123456");
    form.setConfirmarSenha("");
    form.setContato("81999999999");

    String resultado = service.cadastrar(form);
        // resultado esperado
    assertEquals("Confirmar Senha é obrigatório", resultado);
    }

    @Test
    void cadastrarComContatoVazio() {

    UserRepository repository = new UserRepository();
    CadastroService service = new CadastroService(repository);

    FormCadastro form = new FormCadastro();
    form.setNome("Julia");
    form.setEmail("julia@gmail.com");
    form.setPassword("123456");
    form.setConfirmarSenha("123456");
    form.setContato("");

    String resultado = service.cadastrar(form);
        // resultado esperado
    assertEquals("Contato é obrigatório", resultado);
    }

    @Test
    void cadastrarComEmailInvalido() {

    UserRepository repository = new UserRepository();
    CadastroService service = new CadastroService(repository);

    FormCadastro form = new FormCadastro();
    form.setNome("Julia");
    form.setEmail("julia@hotmail.com");
    form.setPassword("123456");
    form.setConfirmarSenha("123456");
    form.setContato("81999999999");

    String resultado = service.cadastrar(form);
        // resultado esperado
    assertEquals("Email inválido", resultado);
    }

    @Test
    void cadastroComSenhaMenorQueSeis() {

    UserRepository repository = new UserRepository();
    CadastroService service = new CadastroService(repository);

    FormCadastro form = new FormCadastro();
    form.setNome("Julia");
    form.setEmail("julia@gmail.com");
    form.setPassword("123");
    form.setConfirmarSenha("123");
    form.setContato("81999999999");


    String resultado = service.cadastrar(form);
        // resultado esperado
    assertEquals("Senha deve ter no mínimo 6 caracteres", resultado);
    }

    @Test
    void cadastroComSenhasDiferentes() {

    UserRepository repository = new UserRepository();
    CadastroService service = new CadastroService(repository);

    FormCadastro form = new FormCadastro();
    form.setNome("Julia");
    form.setEmail("julia@gmail.com");
    form.setPassword("123456");
    form.setConfirmarSenha("1234567");
    form.setContato("81999999999");


    String resultado = service.cadastrar(form);
        // resultado esperado
    assertEquals("As senhas não coincidem", resultado);
    }
    
}
