package com.donte.funcionais;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class GeradorArquivos {
	public static String dominio = "";
	public final static String sistema = "s2gpi";
	public final static String dirpages = "resultado/pages";
	
	private static  Map<String, String> mapa = new HashMap<String, String>();
	
	public static void main(String[] args) throws IOException {		
		carregaArquivos();
	}	
	
	
	@SuppressWarnings("unused")
	private static void loadArquivosNoClasspath(){		
		try {
			InputStream is = ClassLoader.getSystemResource("dao.arq").openStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(is));						
			processaArquivoTeste(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private static void carregaArquivos(){
		File dir = new File("C:\\Programacao\\workspace\\s2gpi\\src\\br\\gov\\ma\\emap\\s2gpi\\container\\dominio");  
	    
		for(File f: dir.listFiles()) {  
            if(f.isFile()) {  
            	mapa.clear();
                dominio = f.getName().substring(0, f.getName().length() - 5);
                processar();
            }  
        }  		
	}
		
	private static void processar(){
		try{
			carregarParametros();
			criaArquivoDao();
			criaArquivoDaoImpl();
			criaArquivoService();
			criaArquivoServiceImpl();
			criaArquivoBean();
			criaArquivoPages();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void criaArquivoPages() throws IOException { 			
		File file = new File(dirpages+"/" + mapa.get("@OBJDOMPASTA@"));
		boolean flag = file.mkdir();
		if(flag){
			BufferedReader inMain = new BufferedReader(new FileReader("template/pagedominio.arq"));				
			BufferedWriter outMain = new BufferedWriter(new FileWriter(dirpages+"/"+mapa.get("@OBJDOMPASTA@")+"/"+mapa.get("@OBJDOMPASTA@")+".xhtml"));
			processaArquivo(inMain, outMain);
			
			BufferedReader inList = new BufferedReader(new FileReader("template/list.arq"));				
			BufferedWriter outList = new BufferedWriter(new FileWriter(dirpages+"/"+mapa.get("@OBJDOMPASTA@")+"/list.xhtml"));
			processaArquivo(inList, outList);
			
			BufferedReader inForm = new BufferedReader(new FileReader("template/form.arq"));				
			BufferedWriter outForm = new BufferedWriter(new FileWriter(dirpages+"/"+mapa.get("@OBJDOMPASTA@")+"/form.xhtml"));
			processaArquivo(inForm, outForm);
		}
	}


	private static void criaArquivoDao() throws IOException { 		
		BufferedReader in = new BufferedReader(new FileReader("template/dao.arq"));				
		BufferedWriter out = new BufferedWriter(new FileWriter("resultado/dao/"+mapa.get("@INTERFACE_DAO@")+".java"));
		processaArquivo(in, out);
	}

	private static void criaArquivoDaoImpl() throws IOException { 
		BufferedReader in = new BufferedReader(new FileReader("template/daoImpl.arq"));				
		BufferedWriter out = new BufferedWriter(new FileWriter("resultado/dao/"+mapa.get("@CLASSE_DAO@")+".java"));
		processaArquivo(in, out);
	}

	private static void criaArquivoService() throws IOException { 
		BufferedReader in = new BufferedReader(new FileReader("template/service.arq"));				
		BufferedWriter out = new BufferedWriter(new FileWriter("resultado/service/"+mapa.get("@INTERFACE_SERVICE@")+".java"));
		processaArquivo(in, out);		
	}
	
	private static void criaArquivoServiceImpl() throws IOException { 
		BufferedReader in = new BufferedReader(new FileReader("template/serviceImpl.arq"));				
		BufferedWriter out = new BufferedWriter(new FileWriter("resultado/service/"+mapa.get("@CLASSE_SERVICE@")+".java"));
		processaArquivo(in, out);		
	}
	
	private static void criaArquivoBean() throws IOException { 
		BufferedReader in = new BufferedReader(new FileReader("template/bean.arq"));				
		BufferedWriter out = new BufferedWriter(new FileWriter("resultado/bean/"+mapa.get("@BEAN@")+".java"));
		processaArquivo(in, out);		
	}
	
	private static void processaArquivoTeste(BufferedReader in) throws IOException {
		String str = "";
		while (in.ready())
			str += in.readLine() + "\n";
		System.out.println(str);           		
		in.close();			
	}
	
	private static void processaArquivo(BufferedReader in, BufferedWriter out) throws IOException {
		String str = "";
		while (in.ready())
			str += in.readLine() + "\n";
		for (String chave : mapa.keySet()) 
			str = str.replace(chave, mapa.get(chave));	                
		out.write(str);
		out.close();
		in.close();			
	}
	
	public static String nomearObjeto(String param){
		String firstLetter = param.charAt(0) + "";			
		return firstLetter.toLowerCase() + param.substring(1);
	}	
						
	private static void carregarParametros() {
		mapa.put("@SISTEMA@", sistema);
		mapa.put("@DOMINIO@", dominio);
		mapa.put("@INTERFACE_DAO@", dominio + "Dao");
		mapa.put("@CLASSE_DAO@", dominio + "DaoImpl");
		mapa.put("@INTERFACE_SERVICE@", dominio + "Service");
		mapa.put("@CLASSE_SERVICE@", dominio + "ServiceImpl");
		mapa.put("@BEAN@", dominio + "Bean");	
		mapa.put("@OBJ_DOMINIO@",nomearObjeto(dominio));
		mapa.put("@OBJDOMPASTA@", dominio.toLowerCase());
		mapa.put("@OBJ_BEAN@",nomearObjeto(dominio)+"Bean");
	}		
}





