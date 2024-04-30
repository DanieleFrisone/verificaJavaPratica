package com.engim.verificapratica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorteggio {
    private List<Squadra> squadre = new ArrayList<>();
    private boolean daMischiare = true;
    private int nextName = 0;
    public void aggiungi(String nome, String nazione){
        squadre.add(new Squadra(nome,nazione));
        daMischiare = true;
        nextName = 0;
    }

    public Squadra next(){
        if(daMischiare){
            Collections.shuffle(squadre);
            daMischiare = false;
            nextName = 0;
        }
        if(nextName >= squadre.size())
            throw new IndexOutOfBoundsException("squadre finite");
        return squadre.get(nextName++);
    }



    public List<Squadra> getSquadre() {
        return squadre;
    }

    public boolean isDaMischiare() {
        return daMischiare;
    }

    public List<Partita> sorteggiaPartite(){

        int x = (int) Math.sqrt(squadre.size());
        List<Partita> listaPartite = new ArrayList<>();

        if (x != Math.sqrt(squadre.size())){
            throw new IndexOutOfBoundsException("squadre non potenza di 2");
        } else {
            Collections.shuffle(squadre);
            for (int i = 0; i<squadre.size(); i=i+2){
                Partita partita = new Partita(squadre.get(i), squadre.get(i+1));
                listaPartite.add(partita);
            }

            return listaPartite;
        }

    }


}
