/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.findem.controller;
import com.mycompany.findem.service.AnimalService;
import com.mycompany.findem.model.FormAnimal;

/**
 *
 * @author jppb2
 */
public class AnimalController {
    
    private AnimalService service;
    
    public AnimalController(AnimalService service){
            this.service = service;
    }
    
    public String recebeForm(String nome, String raca, String especie, String categoria, String estado, String cidade, String ultimolocal){
        
        FormAnimal novoAnimal = new FormAnimal();
        novoAnimal.setName(nome);
        novoAnimal.setRaca(raca);
        novoAnimal.setEspecie(especie);
        novoAnimal.setCategoria(categoria);
        novoAnimal.setEstado(estado);
        novoAnimal.setCidade(cidade);
        novoAnimal.setUltimoLocalVisto(ultimolocal);
        
        try {
            service.cadastrarAnimal(novoAnimal);
            return "SUCESSO: O animal " + nome + " foi cadastrado!";
        } catch (IllegalArgumentException e) {
            return "ERRO: " + e.getMessage();
        }
        
        
    }
    
}
