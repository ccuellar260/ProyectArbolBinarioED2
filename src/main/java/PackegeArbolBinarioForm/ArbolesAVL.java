
package PackegeArbolBinarioForm;

public class ArbolesAVL {
    NodoArbol raiz;
    
    public ArbolesAVL(){
        raiz = null;
    }
    
    private boolean esHoja(NodoArbol p) {
        return (p.getHI() == null && p.getHD() == null);
    }
    
    private NodoArbol balancear(NodoArbol p) {
        if (altura2(p.getHI()) - altura2(p.getHD()) == 2) {
            if (altura2(p.getHI().getHI()) - altura2(p.getHI().getHD()) == 1) {
                p = rotacionDer(p);
            } 
            else 
                p = rotacionDerIzq(p);            
        }
        if (altura2(p.getHD()) - altura2(p.getHI()) == 2) {
            if (altura2(p.getHD().getHD()) - altura2(p.getHD().getHI()) == 1) {
                p = rotacionIzq(p);
            } 
            else 
                p = rotacionIzqDer(p);            
        }
        return p;
    }  
}
