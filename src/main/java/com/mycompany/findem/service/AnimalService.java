/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.findem.service;

import com.mycompany.findem.model.FormAnimal;
import com.mycompany.findem.model.User;
import com.mycompany.findem.repository.AnimalRepository;
import java.util.List;

/**
 *
 * @author jppb2
 */
public class AnimalService {

    private AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public void cadastrarAnimal(FormAnimal animal, User autor) {

        if (autor == null || !autor.isLogado()) {
            throw new SecurityException("O usuário precisa estar logado para cadastrar o animal.");
        }

        animal.setDono(autor);

        if (animal == null) {
            throw new IllegalArgumentException("O formulário não pode estar vazio.");
        }

        if (animal.getName() == null || animal.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do animal é obrigatório.");
        }

        if (animal.getRaca() == null || animal.getRaca().trim().isEmpty()) {
            throw new IllegalArgumentException("A Raça é obrigatória.");
        }

        if (animal.getEspecie() == null) {
            throw new IllegalArgumentException("A espécie é obrigatória.");
        }

        if (animal.getCategoria() == null) {
            throw new IllegalArgumentException("A Categoria é obrigatória.");
        }

        if (animal.getEstado() == null || animal.getEstado().length() != 2) {
            throw new IllegalArgumentException("O Estado é obrigatório.");
        }

        if (animal.getCidade() == null || animal.getCidade().trim().isEmpty()) {
            throw new IllegalArgumentException("A Cidade é obrigatória.");
        }

        if (animal.getUltimoLocalVisto() == null || animal.getUltimoLocalVisto().trim().isEmpty()) {
            throw new IllegalArgumentException("O Ultimo local visto é obrigatória.");
        }

        repository.save(animal);

    }

    public List<FormAnimal> listarTodos() {
        return repository.findAll();
    }

    public void favoritarAnimal(int idAnimal, User autor) {
        if (!autor.isLogado()) {
            throw new SecurityException("Faça login para favoritar um animal.");
        }

        FormAnimal animal = repository.findById(idAnimal);
        
        if(animal == null){
            throw new IllegalArgumentException("Erro: Animal não encontrado.");
        }

        autor.adicionarFavorito(animal);
        
        System.out.println("Animal favoritado com sucesso!");

    }
    
    public String entrarEmContato(int id, User autor) {
        if (autor == null || !autor.isLogado()) {
            throw new SecurityException("Você precisa estar logado para entrar em contato com o dono.");
        }

        FormAnimal animal = repository.findById(id);
        
        if(animal == null){
            throw new IllegalArgumentException("Erro: Animal não encontrado");
        }
        
        User dono = animal.getDono();
        return "Contato do dono " + dono.getNome() + ": " + dono.getContato();
    }

}
