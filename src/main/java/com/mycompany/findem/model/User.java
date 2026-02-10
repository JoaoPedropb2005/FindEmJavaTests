/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.findem.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jppb2
 */
public class User {
    
    private String nome;
    private String email;
    private String password;
    private String contato;
    private boolean isLogado = false;
    private List<FormAnimal> favoritos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
    
    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public boolean getIsLogado(){
        return isLogado;
    }

    public void setIsLogado(boolean isLogado){
        this.isLogado = isLogado;
    }
    
    public List<FormAnimal> getFavoritos(){
        return favoritos;
    }
    
    public void adicionarFavorito(FormAnimal animal){
        this.favoritos.add(animal);
    }
}
