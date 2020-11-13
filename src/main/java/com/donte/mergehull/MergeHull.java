package com.donte.mergehull;

import java.util.ArrayList;
/**
 *
 * @author Donte
 */
public class MergeHull {
    
    public ListaCircular fechoConvexo(ArrayList<Ponto> pontos) {

        ArrayList<Ponto> mainList = new ArrayList<Ponto>();
        ListaCircular answer;
        
        mainList.addAll(pontos);
        Ponto.ordenaListaPorX(mainList);
     
		answer = recursivoFechoConvexo(mainList, 0, mainList.size()-1);
		
		return answer;
    }

    private ListaCircular recursivoFechoConvexo(ArrayList<Ponto> mainList, int inicio, int fim) {

        ListaCircular answer, aux1, aux2, hull1, hull2;

        if(fim - inicio +1 == 2 ){ // so tem dois pontos
            answer = new ListaCircular( mainList.get(inicio) );
            aux1 = new ListaCircular(mainList.get(inicio +1)); // no lugar de (inicio +1) poderia ter colocado o (fim)
            answer.insereFim(aux1);
            return answer;
        }else if(fim - inicio +1 == 3){ // tres pontos
            int posRelativa = verificaPosicaoRelativa(mainList.get(inicio + 0),mainList.get(inicio + 1),mainList.get(inicio + 2));
            answer = new ListaCircular( mainList.get(inicio + 0) );
            aux1   = new ListaCircular( mainList.get(inicio + 1) );
            aux2   = new ListaCircular( mainList.get(inicio + 2) );
            // usando o sentido horário para armazenar na lista
            if(posRelativa < 0){
                 answer.insereFim(aux1);
                 answer.insereInicio(aux2);
            }else {
                answer.insereFim(aux2);
                answer.insereInicio(aux1);
            }
            return answer;
        }else if(fim - inicio +1 == 1){ // se tivet so um ponto
            return new ListaCircular( mainList.get(inicio) );
        }


        hull1 = recursivoFechoConvexo (mainList, inicio, (inicio+fim)/2);
        hull2 = recursivoFechoConvexo (mainList, (inicio+fim)/2+1, fim);
        return mergeHulls(hull1,hull2) ;
    }

    private ListaCircular mergeHulls(ListaCircular listEsq, ListaCircular listDir) {
        ListaCircular aux1, aux2, aux3, aux4;

        aux1 = listEsq.procuraItemMaiorXMenorY();
        aux2 = listDir.procuraItemMenorXMenorY();
        aux3 = listEsq.procuraItemMaiorXMaiorY();
        aux4 = listDir.procuraItemMenorXMaiorY();

        while (verificaPosicaoRelativa((Ponto)aux1.getItem(), (Ponto)aux2.getItem(), (Ponto)aux2.getPrev().getItem()) < 0
               || (verificaPosicaoRelativa((Ponto)aux1.getNext().getItem(), (Ponto)aux1.getItem(), (Ponto)aux2.getItem()) < 0)){

            while (verificaPosicaoRelativa((Ponto)aux1.getItem(), (Ponto)aux2.getItem(), (Ponto)aux2.getPrev().getItem()) < 0 )
                    aux2 = aux2.getPrev();
            while (verificaPosicaoRelativa((Ponto)aux1.getNext().getItem(), (Ponto)aux1.getItem(), (Ponto)aux2.getItem()) < 0)
                    aux1 = aux1.getNext();
        }
        // calculando a tangente superior
        while (verificaPosicaoRelativa((Ponto)aux3.getPrev().getItem(), (Ponto)aux3.getItem(), (Ponto)aux4.getItem()) > 0
               || (verificaPosicaoRelativa((Ponto)aux3.getItem(), (Ponto)aux4.getItem(), (Ponto)aux4.getNext().getItem()) > 0)){

            while (verificaPosicaoRelativa((Ponto)aux3.getPrev().getItem(), (Ponto)aux3.getItem(), (Ponto)aux4.getItem()) > 0)
                    aux3 = aux3.getPrev();
            while (verificaPosicaoRelativa((Ponto)aux3.getItem(), (Ponto)aux4.getItem(), (Ponto)aux4.getNext().getItem()) > 0)
                    aux4 = aux4.getNext();
        }
        
        aux1.setPrev(aux2);
        aux2.setNext(aux1);
        aux3.setNext(aux4);
        aux4.setPrev(aux3);

        return aux1;
    }

    private int verificaPosicaoRelativa(Ponto a, Ponto b, Ponto c) {
        int x1 = a.getX(), y1 = a.getY();       // x1 y1 1 calculando o determinante
        int x2 = b.getX(), y2 = b.getY();       // x2 y2 1
        int x3 = c.getX(), y3 = c.getY();       // x3 y3 1
        return x1*y2 + x2*y3 + y1*x3 - y2*x3 - x1*y3 - x2*y1;
    }

}

/* aux1 = listEsq.procuraItemMaiorX();
        aux2 = listDir.procuraItemMenorX();
        aux3 = listEsq.procuraItemMaiorX();
        aux4 = listDir.procuraItemMenorX();*/
        // calculando a tangente inferior
