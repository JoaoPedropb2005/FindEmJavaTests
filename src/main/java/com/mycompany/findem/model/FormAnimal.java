/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.findem.model;

/**
 *
 * @author jppb2
 */
public class FormAnimal {
    
    private int id;
    private User dono;
    private String name;
    private String raca;
    private CategoriaAnuncio categoria;
    private Especie especie;
    private String estado;
    private String cidade;
    private String ultimoLocalVisto;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getDono() {
        return dono;
    }

    public void setDono(User dono) {
        this.dono = dono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public CategoriaAnuncio getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAnuncio categoria) {
        this.categoria = categoria;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUltimoLocalVisto() {
        return ultimoLocalVisto;
    }

    public void setUltimoLocalVisto(String ultimoLocalVisto) {
        this.ultimoLocalVisto = ultimoLocalVisto;
    }

}
