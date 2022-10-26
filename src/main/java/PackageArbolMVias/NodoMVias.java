
package PackageArbolMVias;

import javax.swing.JTextArea;

public class NodoMVias {
    public static int M = 2; //vias
    private int Elemento[];
     private int Elementoxd;
    private NodoMVias Hijo[];
    private boolean Estado[];
    
    public NodoMVias(){
        Elemento = new int[M-1];
        Estado = new boolean[M-1];
        Hijo = new NodoMVias[M];
        for(int i = 1; i<=M-1; i++){
            Estado[i-1] = false;
            Hijo[i-1] = null;
        }
        Hijo[M-1] = null;
    }
    
    public int getElem(int i){
        return Elemento[i-1];
    }
    
    public int getElemxd(){
        return Elementoxd;
    }
    
    public NodoMVias getHijo(int i){
        return Hijo[i-1];
    }
    
    
    //esto es getEstado al igual que vacio()
    public boolean Ocupado(int i){
        return Estado[i-1];
    }
    
    public boolean Vacio(int i){
        return !Estado[i-1];
    }
    
    

    //Cargar Datos
    public void setElem(int elem, int i){
        Elemento[i-1] = elem;
        Estado[i-1] = true;
    }
    
     public void setElemxd(int elem){
        Elementoxd = elem;
       // Estado = true;
    }
    
    public void setHijo(NodoMVias Pt, int i){
        Hijo[i-1] = Pt;
    }
    
    public void setVacio(int i){
        Estado[i-1] = false;
    }
    
    //ejecutar, comprobar 
    //Cantidad de Vacios
    public int CantVacias(){
        int c = 0;
        for(int i = 1; i <= Estado.length; i++){
            if(Estado[i-1] == false)
            c++;         
        }
        return c;
    }
    
    //cantidad de casillas ocupadas
    public int CantOcupados(){
        return (M-1) - CantVacias();
    }
    
    //El estado esta lleno?
    public boolean Lleno(){
        return (CantVacias() == 0);
    }       
  
  
    
   
} //end class Nodo
