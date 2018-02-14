package com.home.apostasjl.model;

import java.util.List;

/**
 * Created by Artur on 10/01/2018.
 */

public class Rodada {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    private List<Jogo> lstJogos;

    private Boolean encerrada;

    public List<Jogo> getLstJogos() {
        return lstJogos;
    }

    public void setLstJogos(List<Jogo> lstJogos) {
        this.lstJogos = lstJogos;
    }

    public Boolean getEncerrada() {
        return encerrada;
    }

    public void setEncerrada(Boolean encerrada) {
        this.encerrada = encerrada;
    }
}
