/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.findem.controller;

import com.mycompany.findem.model.CategoriaAnuncio;
import com.mycompany.findem.model.Especie;
import com.mycompany.findem.service.AnimalService;
import com.mycompany.findem.model.FormAnimal;
import com.mycompany.findem.model.User;
import java.util.List;

/**
 *
 * @author jppb2
 */
public class AnimalController {

    private AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    public String recebeForm(String nome, String raca, Especie especie, CategoriaAnuncio categoria, String estado, String cidade, String ultimolocal, User autor) {

        FormAnimal novoAnimal = new FormAnimal();

        novoAnimal.setName(nome);
        novoAnimal.setRaca(raca);
        novoAnimal.setEspecie(especie);
        novoAnimal.setCategoria(categoria);
        novoAnimal.setEstado(estado);
        novoAnimal.setCidade(cidade);
        novoAnimal.setUltimoLocalVisto(ultimolocal);

        try {
            service.cadastrarAnimal(novoAnimal, autor);
            return "SUCESSO: O animal " + nome + " foi cadastrado!";
        } catch (IllegalArgumentException e) {
            return "ERRO: " + e.getMessage();
        }

    }

    public String listaDeAnimais() {

        List<FormAnimal> lista = service.listarTodos();

        if (lista.isEmpty()) {
            System.out.println("Nenhum animal cadastrado no momento.");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("----------- Animais cadastrados ----------- \n");

        for (FormAnimal animal : lista) {
            sb.append("[").append(animal.getId()).append("] ")
                    .append(animal.getName()).append("\n");
        }
        return sb.toString();

    }

    public String favoritar(int id, User usuario) {
        try {
            service.favoritarAnimal(id, usuario);
            return "SUCESSO: Animal adicionado aos favoritos!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String pegarContato(int id) {
        try {
            return service.entrarEmContato(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
