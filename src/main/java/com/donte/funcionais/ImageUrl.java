package com.donte.funcionais;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



public class ImageUrl {
	
	public static void main(String[] args) {
		
     try{
		
		File file = new File("C:/Desenv/outros/temp/test1.gif");
		OutputStream out = new FileOutputStream(file, false);
		
		//URL url = new URL("http://3.bp.blogspot.com/-A4XhQzHkRNo/T-Y-LL7lroI/AAAAAAAAs7A/2u-oKnADwSI/s1600/cade+a+xoxota+-+blogdeklau.jpg");
		
		URL url = new URL("http://www.aondefica.com/paisesecap/p_cap_camaroes.gif");
		
		URLConnection conn = url.openConnection();
								
		InputStream in = conn.getInputStream();
		
		int i=0;
		while ((i = in.read()) != -1){
			out.write(i);
		}
		in.close();
		out.close();
		System.out.println("Gravacao efetuada com sucesso");
														
	}
	
	catch (FileNotFoundException e){
		System.out.println("Arquivo nao encontrado. Causa: " + e.getMessage());
	}
	catch (MalformedURLException e){
		System.out.println("Erro na formacao da URL. Causa: " + e.getMessage()); 
	}
	catch (IOException e){
		System.out.println("Erro de entrada/saida de dados. Causa: " + e.getMessage());
	}	
		
//	try{
//			BufferedImage  img = ImageIO.read(new URL("http://www.aondefica.com/paisesecap/p_cap_camaroes.gif"));
//			ImageIO.write(img, "gif", new File("C:/teste.gif"));
//	}catch(Exception e){
//			
//	}


}


//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		
//		byte[] bytes = blob.getBytes(1, (int)blob.length());   
//		  
//		BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));   
//		ImageIO.write(img, "jpeg", new File("C:/teste.jpg"));  
//		
//
//	}
	
//	public static Image getImageFromUrl(String url) {
//        Image img = null;
//        
//        try
//        {            
//          String imageData = getDataFromUrl(url);
//          img = Image.createImage(imageData.getBytes(), 0, 
//    imageData.length() );          
//        }
//        catch(Exception e1) {
//            e1.printStackTrace();
//        }
//        
//        return img;
//    }
//
//    public static String getDataFromUrl(String url) 
//          throws IOException {
//
//        StringBuffer b = new StringBuffer();
//        InputStream is = null;
//        HttpConnection c = null;
//        
//        long len = 0 ;
//        int ch = 0;
//        c = (HttpConnection)Connector.open(url);
//        is = c.openInputStream();
//        len = c.getLength();
//        if( len != -1) {
//            // Read exactly Content-Length bytes
//            for(int i =0 ; i < len ; i++ )
//                if((ch = is.read()) != -1) {
//                b.append((char) ch);
//                }
//        } else {
//            //Read until the connection is closed.
//            while ((ch = is.read()) != -1) {
//                len = is.available() ;
//                b.append((char)ch);
//            }
//        }
//        
//        is.close();
//        c.close();
//        return b.toString();
//    } 

}
