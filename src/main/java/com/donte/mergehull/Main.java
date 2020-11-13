package com.donte.mergehull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Donte
 */
public class Main {

    public static void main (String args[]){

        //Scanner sc =  new Scanner(System.in);
        int vet[] = {50,150,250,350,450,550,650,750,850};      
        int cases = 9;
        double time1,time2, timeFinMerge, timeFinBrute;
       // ListaCircular fechoHull = null, aux;
       // ArrayList<Aresta> fechoBrute = null;

        MergeHull hull = new MergeHull();
        ForcaBruta brute = new ForcaBruta();

        ArrayList <Ponto> pontos = null;

        

        try{
            //File fl1 = new 
            FileWriter writer = new FileWriter(new File("saida.txt")); // sem o true como parametro ele sempre cria um novo arquivo
            PrintWriter saida = new PrintWriter(writer,true);
            saida.printf("%10s%23s%36s\n","NºPontos","TempoMerge", "TempoBrute");
            for (int i = cases - 1; i >= 0 ; i --){
                pontos = Ponto.geraPontosRandomicamente(vet[i]);
                
                time2 = System.nanoTime();
                //fechoBrute = brute.fechoConvexo(pontos);
                brute.fechoConvexo(pontos);
                timeFinBrute = (System.nanoTime() - time2)/1000000;
                
                time1 = System.nanoTime();
                //fechoHull  = hull.fechoConvexo(pontos);
                hull.fechoConvexo(pontos);
                timeFinMerge = (System.nanoTime() - time1)/1000000;
                
                saida.printf("%10d%23.3f%36.3f\n",vet[i],timeFinMerge, timeFinBrute);
        
                
            }
            saida.close();
            writer.close();

        }catch(IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     /*   aux = fechoHull;
        do {
            Ponto p1 = (Ponto) aux.getItem();
            System.out.println(p1.getX() + " " + p1.getY());
            aux = aux.getNext();
        }while(aux != fechoHull);
        System.out.println("#################################\n");
        
        for(int i = 0 ; i < fechoBrute.size() ; i ++){
            System.out.println(fechoBrute.get(i).getVertice1().getX()+"," +
                               fechoBrute.get(i).getVertice1().getY() + " ---------> " +
                               fechoBrute.get(i).getVertice2().getX()+"," +
                               fechoBrute.get(i).getVertice2().getY() );
        }*/


       
    System.exit(0);
    }

}

 /*pontos = Ponto.geraPontosRandomicamente(vet[0]);
        System.out.println(pontos.size());


        time1 = System.nanoTime();
        fechoHull  = hull.fechoConvexo(pontos);
        System.out.println(System.nanoTime() - time1 + "   ");

        time2 = System.nanoTime();
        fechoBrute = brute.fechoConvexo(pontos);
        System.out.println(System.nanoTime() - time2);

        aux = fechoHull;
        do {
            Ponto p1 = (Ponto) aux.getItem();
            System.out.println(p1.getX() + " " + p1.getY());
            aux = aux.getNext();
        }while(aux != fechoHull);
        System.out.println("#################################\n");
        for(int i = 0 ; i < fechoBrute.size() ; i ++){
            System.out.println(fechoBrute.get(i).getVertice1().getX()+"," +
                               fechoBrute.get(i).getVertice1().getY() + " ---------> " +
                               fechoBrute.get(i).getVertice2().getX()+"," +
                               fechoBrute.get(i).getVertice2().getY() );
        }*/


 /*for(int i = 0 ; i < lista.size() ; i ++){
            System.out.println(lista.get(i).getVertice1().getX()+"," +
                               lista.get(i).getVertice1().getY() + " ---------> " +
                               lista.get(i).getVertice2().getX()+"," +
                               lista.get(i).getVertice2().getY() );
        }*/

 /* result = hull.fechoConvexo(pontos);
        aux = result;
        System.out.println("#################################\n");
        do {
            Ponto p1 = (Ponto) aux.getItem();
            System.out.println(p1.getX() + " " + p1.getY());
            aux = aux.getNext();
        }while(aux != result);

         System.out.println("#################################\n");

        for(int i = 0; i < pontos.size(); i++ ){
            System.out.println(pontos.get(i).getX() + " " + pontos.get(i).getY());
        }*/