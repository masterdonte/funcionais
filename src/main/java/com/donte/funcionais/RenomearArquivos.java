package com.donte.funcionais;

import java.io.File;


public class RenomearArquivos {
	
	public void metodo1(){
		String caminho = "G:\\Dragon Ball\\DB2";
		String saida   = "C:\\Users\\Jonathas\\Videos\\DGBBR";
		File diretorio = new File(caminho);
		String  novoNome, nomeAtual;
		File[] lista;
		try{
		if(diretorio.isDirectory()){
			lista = diretorio.listFiles();
			for (int i = 0 ; i < lista.length; i ++ ){
				nomeAtual = lista[i].getName();
				novoNome = "DBBR" + nomeAtual.substring(nomeAtual.length() - 7, nomeAtual.length());
				File  novoArquivo = new File(saida + "\\" + novoNome);
				lista[i].renameTo(novoArquivo);
			}
		}
		System.out.println("Terminou");
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("porra");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void metodo2(){
		String caminho = "F:\\Documentos\\Downloads";
		File diretorio = new File(caminho);
		String  novoNome, nomeAtual;
		File[] lista;
		try{
		if(diretorio.isDirectory()){
			lista = diretorio.listFiles();
			for (int i = 0 ; i < lista.length; i ++ ){
				nomeAtual = lista[i].getName();
				novoNome = "Dbz" + nomeAtual.substring(nomeAtual.length() - 7, nomeAtual.length());
				File  novoArquivo = new File(diretorio.getAbsolutePath() + "\\" + novoNome);
				lista[i].renameTo(novoArquivo);
			}
		}
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("porra");
		}
		
	}

}

