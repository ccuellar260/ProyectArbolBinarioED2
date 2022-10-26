
package PackegeArbolBinarioForm;


public class NodoArbol {
    private int elem;
    private NodoArbol hijoIzq;
    private NodoArbol hijoDer;

    public NodoArbol(int e) {
       elem = e;
       hijoDer = null;
       hijoIzq = null;
    }
    
    //setteres y getters
    
    public void setElem(int e){
       elem = e;
    };
    
    public void setHijoDer(NodoArbol p){
       hijoDer = p;
    };
    
    public void setHijoIzq(NodoArbol p){
       hijoIzq = p;
    };
    
    public int getElem(){
       return elem;
    }
    
    public NodoArbol getHijoDer(){
       return hijoDer;
    }
    
    public NodoArbol getHijoIzq(){
       return hijoIzq;
    }
    

};
    
    
    
    
