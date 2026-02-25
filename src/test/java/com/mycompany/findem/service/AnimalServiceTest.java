/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.findem.service;

import com.mycompany.findem.model.CategoriaAnuncio;
import com.mycompany.findem.model.Especie;
import com.mycompany.findem.model.User;
import com.mycompany.findem.model.FormAnimal;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.mycompany.findem.model.FormCadastro;
import com.mycompany.findem.repository.AnimalRepository;
import com.mycompany.findem.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author jppb2
 */
@ExtendWith(MockitoExtension.class)
public class AnimalServiceTest {

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalService animalService;

    private User usuarioLogado;
    private FormAnimal formCompleto;

    @BeforeEach
    void setup() {

        usuarioLogado = new User();

        usuarioLogado.setId(1);
        usuarioLogado.setNome("João");
        usuarioLogado.setLogado(true);

        formCompleto = new FormAnimal();

        formCompleto.setName("Rex");
        formCompleto.setRaca("Labrador");
        formCompleto.setEspecie(Especie.CACHORRO);
        formCompleto.setCategoria(CategoriaAnuncio.PERDIDO);
        formCompleto.setEstado("PE");
        formCompleto.setCidade("Jaboatão dos Guararapes");
        formCompleto.setUltimoLocalVisto("Perto do parque central");
    }

    @Test
    void postagemDeAnimalComTodosOsCamposPreenchidos_DeveSalvarComSucesso() {

        animalService.cadastrarAnimal(formCompleto, usuarioLogado);

        verify(animalRepository, times(1)).save(any(FormAnimal.class));
    }

    @Test
    void postagemDeAnimalComNomeVazio_DeveLancarExcecao() {
        formCompleto.setName("");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            animalService.cadastrarAnimal(formCompleto, usuarioLogado);
        });

        assertEquals("O nome do animal é obrigatório.", exception.getMessage());
        verify(animalRepository, never()).save(any(FormAnimal.class));
    }

    @Test
    void postagemDeAnimalComRacaVazia_DeveLancarExcecao() {
        formCompleto.setRaca("");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            animalService.cadastrarAnimal(formCompleto, usuarioLogado);
        });

        assertEquals("A Raça é obrigatória.", exception.getMessage());
        verify(animalRepository, never()).save(any(FormAnimal.class));
    }

    @Test
    void postagemDeAnimalComEspecieNaoSelecionada_DeveLancarExcecao() {
        formCompleto.setEspecie(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            animalService.cadastrarAnimal(formCompleto, usuarioLogado);
        });

        assertEquals("A espécie é obrigatória.", exception.getMessage());
        verify(animalRepository, never()).save(any(FormAnimal.class));
    }

    @Test
    void postagemDeAnimalComCategoriaNaoSelecionada_DeveLancarExcecao() {
        formCompleto.setCategoria(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            animalService.cadastrarAnimal(formCompleto, usuarioLogado);
        });

        assertEquals("A Categoria é obrigatória.", exception.getMessage());
        verify(animalRepository, never()).save(any(FormAnimal.class));
    }

    @Test
    void postagemDeAnimalComEstadoVazio_DeveLancarExcecao() {
        formCompleto.setEstado("");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            animalService.cadastrarAnimal(formCompleto, usuarioLogado);
        });

        assertEquals("O Estado é obrigatório.", exception.getMessage());
        verify(animalRepository, never()).save(any(FormAnimal.class));
    }

    @Test
    void postagemDeAnimalComCidadeVazia_DeveLancarExcecao() {
        formCompleto.setCidade("   "); // Simulando espaços em branco

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            animalService.cadastrarAnimal(formCompleto, usuarioLogado);
        });

        assertEquals("A Cidade é obrigatória.", exception.getMessage());
        verify(animalRepository, never()).save(any(FormAnimal.class));
    }

    @Test
    void postagemDeAnimalComUltimoLocalVazio_DeveLancarExcecao() {
        formCompleto.setUltimoLocalVisto("");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            animalService.cadastrarAnimal(formCompleto, usuarioLogado);
        });

        assertEquals("O Ultimo local visto é obrigatória.", exception.getMessage());
        verify(animalRepository, never()).save(any(FormAnimal.class));
    }

    /*****************************
    * 
    * Testes de Permissão e Autenticação para acesso a funcionalidades
    * 
    ******************************/
    
    @Test
    void publicarAnuncio_SemEstarLogado_DeveLancarExcecao() {
        User usuarioNaoLogado = new User();
        usuarioNaoLogado.setLogado(false);

        SecurityException exception = assertThrows(SecurityException.class, () -> {
            animalService.cadastrarAnimal(formCompleto, usuarioNaoLogado);
        });

        assertEquals("O usuário precisa estar logado para cadastrar o animal.", exception.getMessage());
        verify(animalRepository, never()).save(any(FormAnimal.class));
    }

    @Test
    void favoritarAnimal_Logado_DeveConseguirFazer() {
        int idAnimal = 1;
        when(animalRepository.findById(idAnimal)).thenReturn(formCompleto);

        animalService.favoritarAnimal(idAnimal, usuarioLogado);

        verify(animalRepository, times(1)).findById(idAnimal);
    }

    @Test
    void favoritarAnimal_SemEstarLogado_DeveLancarExcecao() {
        int idAnimal = 1;
        User usuarioNaoLogado = new User();
        usuarioNaoLogado.setLogado(false);

        SecurityException exception = assertThrows(SecurityException.class, () -> {
            animalService.favoritarAnimal(idAnimal, usuarioNaoLogado);
        });

        assertEquals("Faça login para favoritar um animal.", exception.getMessage());
        verify(animalRepository, never()).findById(anyInt());
    }

    @Test
    void entrarEmContato_Logado_DeveRetornarContato() {
        int idAnimal = 1;
        
        User dono = new User();
        dono.setNome("Maria");
        dono.setContato("81999999999");
        formCompleto.setDono(dono);

        when(animalRepository.findById(idAnimal)).thenReturn(formCompleto);

        String resultado = animalService.entrarEmContato(idAnimal, usuarioLogado);

        assertEquals("Contato do dono Maria: 81999999999", resultado);
        verify(animalRepository, times(1)).findById(idAnimal);
    }

    @Test
    void entrarEmContato_SemEstarLogado_DeveLancarExcecao() {
        int idAnimal = 1;
        User usuarioNaoLogado = new User();
        usuarioNaoLogado.setLogado(false);

        SecurityException exception = assertThrows(SecurityException.class, () -> {
            animalService.entrarEmContato(idAnimal, usuarioNaoLogado);
        });

        assertEquals("Você precisa estar logado para entrar em contato com o dono.", exception.getMessage());
        verify(animalRepository, never()).findById(anyInt());
    }
    
}
