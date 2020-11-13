package com.donte.funcionais;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ElementosDistintos {	
	
	private final static String ABSOLUTE_PATH_IN  = System.getProperty("user.dir");
	private final static String SEPARADOR = System.getProperty("file.separator");
	private final static String ABSOLUTE_PATH_OUT = ABSOLUTE_PATH_IN + SEPARADOR + "arquivos_movidos";
	private static int cont  = 0;
	private static int cont1 = 0;

	public static void main(String[] args) {				
		//removeArquivoPastas();
		SimpleDateFormat sdf1= new SimpleDateFormat("HH:mm:ss", new Locale("pt","BR")); //você pode usar outras máscaras veja documentação abaixo
		Date y = new Date();
		System.out.println(sdf1.format(y));
		//System.out.println(new Date());
		System.gc();
	}

	@SuppressWarnings("unused")
	private static void removeArquivoPastas(){
		try{			
			String arquivos[] = new File(ABSOLUTE_PATH_IN).list();			
			File novoDir = new File(ABSOLUTE_PATH_OUT);
			
			if(!novoDir.exists()) novoDir.mkdir();		
			else System.out.println("Diretorio ja existe");					

			for (int i = 0; i < arquivos.length; i++) {                       	            	          
				moveArquivo(arquivos[i],ABSOLUTE_PATH_IN);                                                                                    
			} 
			
			System.out.println("Total de arquivos movidos >>> " + cont);
			System.out.println("Total de arquivos não movidos >>> " + cont1);
			
		}catch(Exception e){
			System.out.println("Ocorreu um erro!" + e.getMessage());
		}
	}

	private static void moveArquivo(String arquivo, String caminhoAtual) {
		String caminhoAbsolutoArquivo = caminhoAtual + SEPARADOR + arquivo;
		String caminho = ABSOLUTE_PATH_OUT + SEPARADOR + arquivo;
		try{
			File filein = new File(caminhoAbsolutoArquivo);				
			if(!filein.isDirectory()){
				
				File fileout = new File(caminho);
				int i = 1;
				
				while(fileout.exists()){
					fileout = new File(caminho + ".old_" + i++);
				}
				
				if(filein.renameTo(fileout)){
					System.out.println("Arquivo movido : " + filein.getAbsolutePath() + "  >>>  " + fileout.getAbsolutePath());
					cont++;
				}else{
					System.out.println("Nao foi possivel mover o arquivo " + caminhoAbsolutoArquivo);
					cont1++;
				}	
				
			}else{
				String subarquivos[] = filein.list();
				for (int i = 0; i < subarquivos.length; i++) 
					moveArquivo(subarquivos[i],caminhoAbsolutoArquivo);	
				filein.delete();
			}
		}catch(Exception e){
			System.out.println("Erro ao mover arquivo " + caminho + ".\n" +e.getMessage());
		}
	}

}