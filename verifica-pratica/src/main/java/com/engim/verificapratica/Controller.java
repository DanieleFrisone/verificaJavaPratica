package com.engim.verificapratica;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {


    private static Sorteggio sorteggio = new Sorteggio();

    /*
    * ES 1: get ("/add?nome=n&nazione=m") che aggiunge al sorteggio una squadra con nome n e nazione m (utilizzare
    * la classe Sorteggio) - 15 p
    * */

    @GetMapping("/add")
    public void add(@RequestParam(value = "nome") String n, @RequestParam(value = "nazione") String m){
        sorteggio.aggiungi(n, m);
    }

    /*
    *
    * ES 2: get ("/listaSquadre?nazione=n") che restituisce la lista delle squadre di nazione n - 20 p
    **/

    @GetMapping("/listaSquadre")
    public List<Squadra> listaSquadre(@RequestParam(value = "nazione") String n){

        List<Squadra> listaSquadre = new ArrayList<>();
        listaSquadre = sorteggio.getSquadre();
        List<Squadra> listaSquadreRichiesta = new ArrayList<>();

        for (Squadra squadra : listaSquadre) {
            if (squadra.getNazione().equals(n)) {
                listaSquadreRichiesta.add(squadra);
            }
        }
        return listaSquadreRichiesta;
    }


    /*
    * ES 3: get ("/sorteggia") che restituisce 2 squadre di nazioni diverse (utilizzare la classe Sorteggio, il metodo
    * next. Consiglio: dopo aver sorteggiato la prima, continuare a sorteggiare finché la seconda
    * non è di una nazione diversa) - 20 p
    **/

    @GetMapping("/sorteggia")
    public List<Squadra> sorteggia(){
        Squadra s1 = sorteggio.next();
        Squadra s2 = sorteggio.next();
        while (s1.getNazione().equals(s2.getNazione())){
            s2 = sorteggio.next();
        }

        List<Squadra> coppiaSquadreNazioneDiverse = new ArrayList<>();
        coppiaSquadreNazioneDiverse.add(s1);
        coppiaSquadreNazioneDiverse.add(s2);

        return coppiaSquadreNazioneDiverse;
    }



    /*
    * ES 4: implementare il sorteggio delle squadre di una fase finale di un torneo a eliminazione diretta.
    * Creare il metodo sorteggiaPartite che:
    * - controlla se il numero di squadre aggiunte è una potenza di 2. Se non lo è lancia una RuntimeException.
    * - Finché ci sono squadre non sorteggiate: sorteggia 2 squadre e le inserisce in un oggetto della classe Partita (da creare)
    * - restituisce la lista di Partite.
    * creare get ("/getPartite") che restituisce la lista appena creata - 30 p
    * */

    @GetMapping("/getPartite")
    public List<Partita> getPartite(){
        return sorteggio.sorteggiaPartite();
    }



}
