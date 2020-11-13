package com.donte.mergehull;

import java.util.ArrayList;

/**
 *
 * @author Donte
 */
public class ForcaBruta {

    public ArrayList<Aresta> fechoConvexo(ArrayList<Ponto> pontos){

        ArrayList<Ponto> list = new ArrayList<Ponto>();
        ArrayList<Aresta> answer = new ArrayList<Aresta>();

        list.addAll(pontos);
        Ponto.ordenaListaPorX(list);

        int i, j;

        for(i = 0 ; i < list.size() - 1 ; i ++){
            for(j = i + 1 ; j < list.size() ; j ++){
                if(halfSpaceVerification(list,list.get(i),list.get(j))){
                    answer.add(new Aresta(list.get(i), list.get(j)));
                }
            }
        }

        return answer;
    }

    private boolean halfSpaceVerification(ArrayList<Ponto> pontos, Ponto b, Ponto c) {
        int i, side1 = 0 ,side2 = 0, res;

        int x1, y1;                             // x1 y1 1
        int x2 = b.getX(), y2 = b.getY();       // x2 y2 1
        int x3 = c.getX(), y3 = c.getY();       // x3 y3 1

        for( i = 0 ; i < pontos.size() ; i ++ ){
            x1  = pontos.get(i).getX();
            y1  = pontos.get(i).getY();
            res = x1*y2 + x2*y3 + y1*x3 - y2*x3 - x1*y3 - x2*y1;
            if(res > 0)side1++;
            if(res < 0)side2++;
        }

        return (side1 == 0 || side2 == 0)? true : false;

    }

}
