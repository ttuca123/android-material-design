package com.home.apostasjl.model;

/**
 * Created by Tuca on 10/01/2018.
 */

public class Apostador {

    private int id;

    private String idGoogle;

    private String nome;

    private String email;

    private String senha;

    private String celular;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
