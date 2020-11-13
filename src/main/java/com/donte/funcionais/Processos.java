package com.donte.funcionais;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Processos {
	public static void main(String[] args) {
		try {  
			InputStream in = Runtime.getRuntime().exec("tasklist /FI \"IMAGENAME eq PanGPS.exe\"").getInputStream();  
            BufferedInputStream reader = new BufferedInputStream(in);  
            boolean isRunning = true;
            Scanner sc = new Scanner(reader);             
            if(sc.hasNext()){
            	if(sc.nextLine().startsWith("INFO")) 
            		isRunning = false;            
            }            
            sc.close();
            if(isRunning){
            	System.out.println("RODANDO");
            	//Runtime.getRuntime().exec("taskkill /IM calc.exe");
            	Runtime.getRuntime().exec("net stop PanGPS");            	
            }else{
            	System.out.println("PARADO");
            	//Runtime.getRuntime().exec("calc.exe"); 
            	Runtime.getRuntime().exec("net start PanGPS");
            }
        } catch (Exception e) {  
              System.err.println(e.getMessage());
        }  
	}
}
