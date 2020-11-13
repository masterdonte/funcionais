package com.donte.funcionais;
import java.util.Scanner;
//h é o dia da semana (0 = sábado, 1 = domingo, 2 = segunda, …)
//q é o dia do mês
//m é o mês (3 = março, 4 = abril, 5 = maio, …)
//K é o ano do século (ano mod 100)
//J é o século (ano / 100) (por exemplo, para 1995 o século seria 19, ainda que na realidade o século seria XX)

public class GerarCalendario {

	public static void main(String[] args) {
		String [] diaSemana = {"SÁBADO", "DOMINGO", "SEGUNDA", "TERÇA", "QUARTA","QUINTA","SEXTA"}; 		
		int h, ano;		
		Scanner sc = new Scanner(System.in);				
		ano = sc.nextInt();
		sc.close();
		int qtdDiasFev = (bissexto(ano) == 1)? 29 : 28;
		int [] meses = new int[] {31,qtdDiasFev,31,30,31,30,31,31,30,31,30,31};	
		int [][] diames = new int [6][7];		
		h = calculaDiaSemana(1,1,ano);					
		System.out.println(diaSemana[h]);				
		for(int j = 0 ; j < 12 ; j ++){
			preencheMatriz(diames, h);
			imprimeMes(diames, meses[j], j);
			h = (h + meses[j]) % 7;
		}
	}
	
	private static void imprimeMes(int[][] diames, int qtdDiasMes, int mes) {
		String [] meses = {"JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL","MAIO","JUNHO","JULHO","AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO","DEZEMBRO"};
		String [] diaSemanaCal = {"DOM", "SEG", "TER", "QUA","QUI","SEX","SAB"};
		boolean flag = false;
		System.out.println("  " + meses[mes]+"\n");		
		for(int i = 0 ; i < 7 ; i ++)System.out.printf("%5s",diaSemanaCal[i]);	
		System.out.println();
		for(int i = 0 ; i < 6 ; i ++){
			for(int j = 0 ; j < 7 ; j ++ ){
				if(diames[i][j] == -1) System.out.printf("%5s","-");
				else System.out.printf("%5d",diames[i][j]);
				if(diames[i][j] >= qtdDiasMes){
					flag = true;
					break;
				}
			}
			System.out.println();
			if (flag == true) break;
		}
		System.out.println("\n-------------------------------------------\n");		
	}

	private static void preencheMatriz(int[][] diames, int h) {
		int dia = 1;
		int pos = h - 1;
		if (pos < 0) pos = pos + 7;
		for (int i = 0 ; i < 6 ; i ++)
			for (int j = 0 ; j < 7 ; j ++){
				if(i == 0){
					diames[i][j] = (j < pos)? -1 : dia++;									
				}else{
					diames[i][j] = dia++;
				}
			}
	}

	private static int calculaDiaSemana(int q, int m, int ano){
		int h, K, J;						
		if(m < 3) m = m + 12;		
		if(m > 12) ano --;
		K = ano % 100;
		J = ano / 100;			
		h = (int)Math.floor((q + Math.floor(((m+1)*26)/10) + K + Math.floor(K/4) + Math.floor(J/4) + 5*J)) % 7;					
		return h;
	}
	
	private static int bissexto(int ano){		
		if((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0)return 1;
		else return 0;
	}
	
	
}
