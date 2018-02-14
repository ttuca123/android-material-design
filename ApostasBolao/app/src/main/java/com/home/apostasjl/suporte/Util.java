package com.home.apostasjl.suporte;

import com.home.apostasjl.enuns.EnuPalpite;
import com.home.apostasjl.enuns.EnuResultado;
import com.home.apostasjl.model.Apostador;
import com.home.apostasjl.model.Cartela;
import com.home.apostasjl.model.Jogo;
import com.home.apostasjl.model.Palpite;
import com.home.apostasjl.model.Time;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tuca on 10/01/2018.
 */

public class Util {

    public static List<Jogo> preencherJogos(){
        List<Jogo> jogos = new ArrayList<Jogo>();

        for(int i=0; i<12; i++){

            Jogo jogo = new Jogo(preencherCartelas());
            Map<Time, Time> time =  preencherTimes(i);
            jogo.setId(i);
            jogo.setJogadas(time);
            jogo.setData(new Date());
            jogo.setResultado(EnuResultado.SEM_RESULTADO);
            jogos.add(jogo);
        }


        return jogos;
    }


    public static Map<Time,Time> preencherTimes(int id){

        Map<Time,Time> times = new HashMap<Time, Time>();

        Time time1 = new Time();

        Time time2 = new Time();

        switch (id){

            case 0:
                time1 = new Time();
                time1.setNome("Palmeiras");

                time2 = new Time();
                time2.setNome("Corintians");

                break;
            case 1:
                time1 = new Time();
                time1.setNome("Vasco");

                time2 = new Time();
                time2.setNome("Santos");
                break;
            case 2:
                time1 = new Time();
                time1.setNome("São Paulo");

                time2 = new Time();
                time2.setNome("Palmeiras");
                break;
            case 3:
                time1 = new Time();
                time1.setNome("Botafogo");

                time2 = new Time();
                time2.setNome("Fluminense");
                break;
            case 4:
                time1 = new Time();
                time1.setNome("Fluminense");

                time2 = new Time();
                time2.setNome("Atlético");
                break;
            case 5:
                time1 = new Time();
                time1.setNome("Goiás");

                time2 = new Time();
                time2.setNome("Ceará");
                break;
            case 6:
                time1 = new Time();
                time1.setNome("Fortaleza");

                time2 = new Time();
                time2.setNome("Ceará");
                break;
            case 7:
                time1 = new Time();
                time1.setNome("Internacional");

                time2 = new Time();
                time2.setNome("Fluminense");
                break;
            case 8:
                time1 = new Time();
                time1.setNome("Fluminense");

                time2 = new Time();
                time2.setNome("Ceará");
                break;
            case 9:
                time1 = new Time();
                time1.setNome("Goiás");

                time2 = new Time();
                time2.setNome("Botafogo");
                break;
            case 10:
                time1 = new Time();
                time1.setNome("São Paulo");

                time2 = new Time();
                time2.setNome("Santos");
                break;
            case 11:
                time1 = new Time();
                time1.setNome("Ceará");

                time2 = new Time();
                time2.setNome("Vasco");
                break;

        }

        times.put(time1, time2);
        return times;



    }

    public static List<Cartela> preencherCartelas(){
        List<Cartela> cartelas = new ArrayList<Cartela>();
        Apostador apostador = new Apostador();

        apostador.setNome("Jorge Luís");
        apostador.setSenha("123456");
        apostador.setCelular("99795363");
        apostador.setEmail("jorgeluizjlba@gmail.com");

        for(int i=0; i<10; i++){
            Cartela cartela = new Cartela();
            cartela.setNrCartela(""+i);
            cartela.setApostador(apostador);
            cartelas.add(cartela);
        }


        return cartelas;
    }

    public static List<Palpite> preencherPalpites(){
        List<Palpite> palpites = new ArrayList<Palpite>();

        for(int i=0; i<10; i++){
            if(i<5) {
                palpites.add(new Palpite(EnuPalpite.CASA));
            }else if(i>5 && i<8){
                palpites.add(new Palpite(EnuPalpite.EMPATE));
            }else{
                palpites.add(new Palpite(EnuPalpite.FORA));
            }
        }


        return palpites;
    }


}
