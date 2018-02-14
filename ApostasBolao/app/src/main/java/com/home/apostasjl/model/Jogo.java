package com.home.apostasjl.model;

import com.home.apostasjl.enuns.EnuResultado;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Tuca on 10/01/2018.
 */

public class Jogo {

    private int id;

    private List<Cartela> cartelas;

    private Map<Time, Time> jogadas;

    private EnuResultado resultado;

    private  Date data;


    private Jogo(){


    }

    public Jogo( List<Cartela> cartelas){

        this.cartelas = cartelas;

    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Cartela> getCartelas() {
        return cartelas;
    }

    public void setCartelas(List<Cartela> cartelas) {
        this.cartelas = cartelas;
    }

    public void setResultado(EnuResultado resultado) {
        this.resultado = resultado;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Time, Time> getJogadas() {
        return jogadas;
    }

    public void setJogadas(Map<Time, Time> jogadas) {
        this.jogadas = jogadas;
    }

    public EnuResultado getResultado() {
        return resultado;
    }
}
