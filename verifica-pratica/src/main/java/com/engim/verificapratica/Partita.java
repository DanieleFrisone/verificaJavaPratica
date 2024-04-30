package com.engim.verificapratica;

public class Partita {

    private Squadra s1;
    private Squadra s2;

    public Partita(Squadra s1, Squadra s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public Squadra getS1() {
        return s1;
    }

    public void setS1(Squadra s1) {
        this.s1 = s1;
    }

    public Squadra getS2() {
        return s2;
    }

    public void setS2(Squadra s2) {
        this.s2 = s2;
    }
}
