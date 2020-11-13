package com.donte.mergehull;
/**
 *
 * @author Donte
 */
public class Aresta {
    private Ponto vertice1;
    private Ponto vertice2;

    public Aresta(Ponto v1, Ponto v2){
        this.vertice1 = v1;
        this.vertice2 = v2;
    }

    public Ponto getVertice1() {
        return vertice1;
    }

    public void setVertice1(Ponto vertice1) {
        this.vertice1 = vertice1;
    }

    public Ponto getVertice2() {
        return vertice2;
    }

    public void setVertice2(Ponto vertice2) {
        this.vertice2 = vertice2;
    }

}
