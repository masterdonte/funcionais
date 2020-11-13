package com.donte.mergehull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Donte
 */
public class Ponto {
    private int x;
    private int y;

    public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

	public static ArrayList<Ponto> ordenaListaPorX(ArrayList<Ponto> o){

        Collections.sort(o, new Comparator<Ponto>() {
            public int compare(Ponto o1, Ponto o2) {
                return o1.getX() - o2.getX();
            }
        });
        return  o;
    }

    public static ArrayList<Ponto> geraPontosRandomicamente(int numPts){
        int maxVal = 10000;
        ArrayList<Ponto> pontos = new ArrayList<Ponto>();

        for(int i = 0 ; i < numPts ; i ++ )
           pontos.add( new Ponto( (int)(Math.random() * maxVal), (int)(Math.random() * maxVal)) );
        
        return pontos;
    }
    
}
