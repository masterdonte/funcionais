package com.donte.funcionais;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class EscritaArquivo {  
	

	public void metodo(Integer i){
		i = i + i;
	}

	public static void main(String[] args) {	
		escreveFimArquivo2("JONATHAS.PIMENTA", "26");
		escreveFimArquivo2("THIAGO.BALANCA", "30");
		escreveFimArquivo2("BRUNO.CARVALHO", "100");
		escreveFimArquivo2("AILA.FERREIRA", "50");
		escreveFimArquivo2("SARAH.HELENA", "20");		
	}
	
	public static void escreveFimArquivo2(String nome, String idade){
		boolean flag = false;
		try {
			File arquivo = new File("../print.txt");
			flag = arquivo.exists();			
			FileWriter fw = new FileWriter(arquivo, true);				  
			PrintWriter pw = new PrintWriter(fw);			
			if(!flag)escreve("NOME","IDADE",pw);	
			escreve(nome, idade, pw);
			pw.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	private static void escreve(String nome, String idade, PrintWriter pw){
		pw.printf("%-20s | %-5s | %-20s" , nome, idade, idade.equals("IDADE")? "DATA": new Date());
		pw.println();
		pw.println("---------------------------------------------------------------------");
	}

	public static void escreveFimArquivo(String[] args) {
		File arquivo = new File("C:\\Users\\JONATHAS\\Desktop\\print.txt");
		try{
			String cliente = "JONATHAS";
			String idade = "22";
			BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo,true)); 
			if(arquivo.canWrite()){
				bw.newLine();
				bw.write("-----------------------------------------------------------"); 
				bw.newLine(); 
				bw.write("Usuario: "+cliente+" ; Idade: "+idade+" ; Data Hora :" + new Date()); 			
				bw.flush(); 
				bw.close(); 
			} 
		}catch (IOException e){
			System.out.println(e.getMessage());
		} 
	} 

}  