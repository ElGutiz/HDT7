
/*
 * Jose Abraham Gutierrez Corado 19111
 * 21 de marzo de 2020
 */

import java.util.ArrayList;

public class Diccionario {
    BinaryTree<Association<String, String>> raiz;//raiz padre de todo el arbol genealogico
    
    //constructor para crear el arbol

    public Diccionario(ArrayList<Association<String, String>> arrayAs){
        raiz = new BinaryTree<Association<String, String>>(null, null, null,null);
        raiz.setValue(arrayAs.get(0));
        for(int i=1; i<arrayAs.size();i++){
            addAss(raiz, arrayAs.get(i));
            System.out.print("\n"+arrayAs.get(i));
        }
    }

    /**
     *agrega a una asociacion al arbol binario al compararlo con su raiz para asi colocarlo en su debida posicion
     * @param viejo raiz del arbol
     * @param nuevo asociacion que desea agregar
     */
    public void addAss(BinaryTree<Association<String, String>> viejo, Association<String, String> nuevo){
        //Se obtiene el valor del BTS a modificar y los keys
        Association<String,String> asoc = viejo.value();
        String keyP = asoc.getKey();
        String keyS = nuevo.getKey();
        //Se comparan los tamaños de los keys 
        int resul = keyP.compareToIgnoreCase(keyS);
        if (resul>0 && viejo.left()==null){
            //Si la clave del padre es mayor y no tiene hijo izquierdo se agrega
            viejo.setLeft(new BinaryTree<Association<String,String>>(null, null,null,null));
            viejo.left().setValue(nuevo);
        }else if(viejo.left()!=null){
            //si ya tiene un hijo izquierdo
            addAss(viejo.left(), nuevo);
        }
        if (resul<0 && viejo.right()==null){
            //Si la clave del padre es menor y no tiene hijo derecho se agrega
            viejo.setRight(new BinaryTree<Association<String,String>>(null, null,null,null));
            viejo.right().setValue(nuevo);
        }else if(viejo.right()!=null){
            //si ya tiene un hijo izquierdo
            addAss(viejo.right(), nuevo);
        }
    }
    // 

    /**
     *Busca palabra en el arbol genealogico para hayar su traduccion a espanol
     * @param bts nodo con asociacion
     * @param palabra palabra que esta buscando
     * @return traduccion a espanol
     */
    public String traduccion(BinaryTree<Association<String,String>> bts, String palabra){
        String wTrad = "";
        Association<String,String> asociacion= bts.value();
        String keyBTS=asociacion.getKey();
        int n =keyBTS.compareToIgnoreCase(palabra);
        if(n==0){
            wTrad=bts.value().getValue();
        }
        if(n<0){
            if(bts.right()!=null){
                wTrad=traduccion(bts.right(),palabra);
            }else{
                return ("*"+palabra+"*");
            }
        }
        if(n>0){
                if(bts.left()!=null){
                        wTrad=traduccion(bts.left(),palabra);
                }else{
                        return ("*"+palabra+"*");
                }
        }
        return wTrad;
    }

    /**
     *getter de raiz del arbol
     * @return raiz
     */
    public BinaryTree<Association<String, String>> getRaiz(){
        return raiz;
    }
}
