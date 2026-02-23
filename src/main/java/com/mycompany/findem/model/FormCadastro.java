package com.mycompany.findem.model;

/**
 *
 * @author Julia
 */
public class FormCadastro {
    
    
    private String nome;
    private String email;
    private String password;
    private String confirmarSenha;
    private String contato;

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

    public String getConfirmarSenha() {
    return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
    this.confirmarSenha = confirmarSenha;
    }
    
    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }


}
