/*
 * Jose Abraham Gutierrez Corado 19111
 * 21 de marzo de 2020
 */

/**
 * @param <K> puede aceptar cualquier tipo de dato por ser generico
 * @param <V>
 */
public class Association <K,V>  {
    private K key ;//palabra en ingles
    private V value;//palabra en espanol
    
    /**
     *constructor
     * @param clave palabra en ingles
     * @param valor palabra en espanol
     */
    public Association (K clave, V valor){
        this.key = clave;
        this.value = valor;
    }
    //funcion to string para mostrar palabra guardada con su traduccion (asociacion)
    public String toString(){
        return "Guardando: Ingles: " + key +"-> Español: " + value;
    }
    
    /**
     *retorna palabra en ingles
     * @return String de palabra
     */
    public K getKey(){
        return key;
    }

    /**
     *retorna palabra en espanol
     * @return String de palabra
     */
    public V getValue(){
        return value;
    }
    
    /**
     *
     * @param otro objeto (en este caso son strings)
     * @return true o false de si son iguales o no
     */
    public boolean comparar(Object otro)
    {
        Association otroAsso = (Association)otro;
        boolean resul = getKey().equals(otroAsso.getKey());
        return resul;
    }
   
    /**
     *cambio de valor de una palabra
     * @param valor nueva palabra en espanol
     * @return vieja palabra
     */
    public V setValue(V valor)
    {
        V oldValue = value;
        this.value = valor;
        return oldValue;
    }
      
      
    
    
    
}
