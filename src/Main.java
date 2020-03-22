/*
 * Jose Abraham Gutierrez Corado 19111
 * 21 de marzo de 2020
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // VARIABLES Y OBJETOS
        ArrayList arr = new ArrayList();
        ArrayList<String> a = new ArrayList<>(), b = new ArrayList<>();
        String linea = "";
        String str= "                      "; 
        Diccionario dicc;
        int num = 1;
        ArrayList<Association<String, String>> arrayAs = new ArrayList<>();
        int char_a_string;
        
        //Lectura del archivo que contiene las palabras a traducir.
        try {
            FileReader lector = new FileReader("diccionario.txt");
            BufferedReader buff = new BufferedReader(lector);
            while ((linea = buff.readLine()) != null){
                arr.add(linea);
                String [] p1=linea.split(",");
                String in=p1[0];
                in = in.replace("(","");
                String es=p1[1];
                es = es.replace(")","");
                Association h=new Association (in, es);
                arrayAs.add(h);
            }
            buff.close();
        }catch (IOException ex){ 
            System.out.println("ERROR");
        }
        dicc = new Diccionario(arrayAs);

        //Lectura del texto para traducirlo
        try {
            FileReader lect = new FileReader("texto.txt");
            BufferedReader bf = new BufferedReader(lect);
            String concatenador = "";
            while ((linea = bf.readLine()) != null){
                String [] texto =linea.split(" ");
                for(int n=0;n<texto.length;n++){
                    String palabra = texto[n];
                    String trd = dicc.traduccion(dicc.getRaiz(), palabra);
                    concatenador += " " + trd + " ";
                }
                System.out.print("\n"+concatenador);
            }
            bf.close();
        }catch (IOException ex){ 
            System.out.println("ERROR");
        }
      
    }
    
}
