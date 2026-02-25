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
    private int id;
    private String email;
    private String password;
    private String contato;
    private boolean logado = false;
    private List<FormAnimal> favoritos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public List<FormAnimal> getFavoritos() {
        return favoritos;
    }

    public void adicionarFavorito(FormAnimal animal) {
        if (!favoritos.contains(animal)) {
            favoritos.add(animal);
        }
    }

    public void removerFavorito(FormAnimal animal) {
        favoritos.remove(animal);
    }
}