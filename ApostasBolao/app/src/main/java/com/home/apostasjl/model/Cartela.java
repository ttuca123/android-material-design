package com.home.apostasjl.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tuca on 10/01/2018.
 */

public class Cartela {

    Apostador apostador;

    String nrCartela;

    private Palpite[]  palpites;

    public Apostador getApostador() {
        return apostador;
    }

    public void setApostador(Apostador apostador) {
        this.apostador = apostador;
    }

    public String getNrCartela() {
        return nrCartela;
    }

    public void setNrCartela(String nrCartela) {
        this.nrCartela = nrCartela;
    }

    public Palpite[] getPalpites() {
        if(palpites==null){

            palpites = new Palpite[12];
        }

        return palpites;
    }

    public void setPalpites(Palpite[] palpites) {
        this.palpites = palpites;
    }
}
