/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.findem.repository;

import com.mycompany.findem.model.FormAnimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jppb2
 */
public class AnimalRepository {
    
    private List<FormAnimal> dataAnimal = new ArrayList<>();
    private int id = 1;
    
    public void save(FormAnimal animal){
        animal.setId(id++);
        dataAnimal.add(animal);
        System.out.println("Animal salvo no banco local com ID: !" + animal.getId());
    }
    
    public List<FormAnimal> findAll(){
        return new ArrayList<>(dataAnimal);
    }
    
    public FormAnimal findById(int id){
        for (FormAnimal animal : dataAnimal){
            if(animal.getId() == id){
                return animal;
            }
        }
        return null;
    }
    
}
