package com.donte.funcionais;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class OrganizaArquivos
{

    public OrganizaArquivos()
    {
    }

    public static void main(String args[])
    {
        String diretorioAtual = (new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append(System.getProperty("file.separator")).toString();
        String arquivos[] = (new File(System.getProperty("user.dir"))).list();
        String img[] = {
            "bmp", "png", "jpg", "jpeg", "gif", "tif"
        };
        String vdo[] = {
            "wmv", "avi", "mpeg", "mpg", "rm", "rmvb", "3gp", "vga", "mp4", "mov"
        };
        Set<String> imagens = new TreeSet<String>();
        Set<String> videos = new TreeSet<String>();
        carregaConjunto(imagens, img);
        carregaConjunto(videos, vdo);
        for(int i = 0; i < arquivos.length; i++)
        {
            String arquivo = arquivos[i];
            File entrada = new File((new StringBuilder(String.valueOf(diretorioAtual))).append(arquivo).toString());
            if(entrada.isFile())
            {
                String tipoArquivo = arquivo.substring(arquivo.lastIndexOf(".") + 1, arquivo.length());
                if(imagens.contains(tipoArquivo))
                    tipoArquivo = "imagens";
                else
                if(videos.contains(tipoArquivo))
                    tipoArquivo = "videos";
                File novoDiretorio = new File((new StringBuilder(String.valueOf(diretorioAtual))).append("Arquivo(s)_").append(tipoArquivo).toString());
                if(!novoDiretorio.exists())
                    novoDiretorio.mkdir();
                File saida = new File((new StringBuilder(String.valueOf(novoDiretorio.getAbsolutePath()))).append("\\").append(arquivo).toString());
                entrada.renameTo(saida);
            }
        }

    }

    private static void carregaConjunto(Set<String> obj, String str[])
    {
        int len = str.length;
        for(int i = 0; i < len; i++)
            obj.add(str[i]);

        System.out.println(obj.size());
    }
}
