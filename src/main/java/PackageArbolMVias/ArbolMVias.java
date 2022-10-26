
package PackageArbolMVias;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ArbolMVias {
    private NodoMVias raiz;
    
    //constructor
    public ArbolMVias(){
    raiz = null;
    }
    
    private boolean esHoja(NodoMVias P){
        for(int i=1; i<=P.M; i++){
            if(P.getHijo(i) != null)
                return false;
        }
        return true;
    }
    
    //devolver el hijo descendiene, en que direccion[i]
    private int getHijoDesc(NodoMVias P, int x){
        int i = 1;
        while (i < P.M){
            if ( x < P.getElem(i))
                return i;
            if ( x == P.getElem(i))
                return -1;
            i++;           
        }
        return P.M;
    }
    
    //metodo insertar Ordenado
    private void InsertaOrd(NodoMVias P, int x){
        for(int i = 1; i<P.M; i++){
            if(P.Vacio(i)){
                P.setElem(x,i);
            return;
            }else{
                if(x==P.getElem(i))
                    return;
                else{
                    if(x < P.getElem(i)){
                        Recorrer(P,i);
                        P.setElem(x,i);
                        return;
                    }
                    }
                }
        }
    }
    
    private void Recorrer(NodoMVias P, int i){
        int num1 = P.getElem(i);     int num2=0;
        int c = P.CantOcupados();
        while(i <= c){
           if(P.Ocupado(i+1))
                num2 = P.getElem(i+1);
            P.setElem(num1,i+1);
            num1 = num2;
            i++;
        }
    }
    
    
    public void Insertar(int x){
        if (raiz == null){
            raiz = new NodoMVias();
            raiz.setElem(x, 1);
        }else{
            NodoMVias P = raiz;
            NodoMVias AP = null;
            int i = 0; //contador 
            //encontrar direccion
            while ( P != null){
                AP = P;
                //p esta lleno
                if (!P.Lleno()){
                    InsertaOrd(P, x);
                    return;
                }
                i = getHijoDesc(P,x);
                if ( i == -1)
                    return;
                P = P.getHijo(i);
            }
            NodoMVias Q = new NodoMVias();
            Q.setElem(x, 1);
            AP.setHijo(Q, i);         
        }
        
    }
    
     
    public void Insertarzxd(int x){
        if (raiz == null){
            raiz = new NodoMVias();
            raiz.setElemxd(x);
        }else{
            NodoMVias P = raiz;
            NodoMVias AP = null;
            int i = 0; //contador 
            //encontrar direccion
            while ( P != null){
                AP = P;
                //p esta lleno
                if (!P.Lleno()){
                    InsertaOrd(P, x);
                    return;
                }
                i = getHijoDesc(P,x);
                if ( i == -1)
                    return;
                P = P.getHijo(i);
            }
            NodoMVias Q = new NodoMVias();
            Q.setElemxd( 1);
            AP.setHijo(Q, i);         
        }
        
    }
    
    
    private void InOrden(NodoMVias P,JTextArea ta){
        if ( P == null)
            return;
        else{
            if (esHoja(P)){
                int i = 1; //muestra todos los elementos de nodo P
                while ( i <= P.CantOcupados()){
                    ta.append(String.valueOf(P.getElem(i)+" "));
                    i++;
                }
            }else{
                for (int i = 1; i <= P.M-1;i++){
                    InOrden(P.getHijo(i),ta);
                    ta.append(String.valueOf(P.getElem(i)+" "));
                }
                InOrden(P.getHijo(P.M), ta);
            }
            }
    }
    
    public void InOrden(JTextArea ta){
        InOrden(raiz,ta);
    }
    
    private void PreOrden(NodoMVias pt, JTextArea ta){
        if (pt == null)
            return;
        else{
            for (int i=1; i<=pt.M;i++){
                if (i<=pt.CantOcupados())
                    ta.append(Integer.toString(pt.getElem(i))+" ");
                PreOrden(pt.getHijo(i), ta);             
            }
            }
    }
    
    public void PreOrden(JTextArea ta){
        PreOrden(raiz, ta);
    };
    
    //avr
     private void PostOrden(NodoMVias pt, JTextArea ta){
        if (pt == null)
            return;
        else{
            for (int i=1; i<=pt.M;i++){
                PostOrden(pt.getHijo(i), ta);  
                if (i<=pt.CantOcupados())
                    ta.append(Integer.toString(pt.getElem(i))+" ");
                            
            }
            }
    }
    
    public void PostOrden(JTextArea ta){
        PreOrden(raiz, ta);
    };
    
    //suma de elementos desde una posiscion ELem
    private int CantidadElem(NodoMVias pt){
        if (pt == null)
            return 0;
        else{
            int C = 0;
            for (int i = 1; i <= pt.M; i++)
                C = C + CantidadElem(pt.getHijo(i));
            
            return C + pt.CantOcupados();
        }
           
    }
    
    public int CantidadElem(){
        return CantidadElem(raiz);
            
    }
    
    
    //suma de elementos desde una posiscion ELem
    private int SumaElem(NodoMVias pt){
        if (pt == null)
            return 0;
        else{
            int sum = 0;
            for (int i = 1; i <= pt.M; i++)
               sum = sum+ SumaElem(pt.getHijo(i));
            
           // return sum + pt.CantOcupados();
           for (int j = 1; j<= pt.CantOcupados();j++)
               sum = sum + pt.getElem(j);
           return sum;    
        }
           
    }
    
    public int SumaElem(){
        return SumaElem(raiz);
            
    }
    
    //buscar direccion donde se encuenter el elemento
    private NodoMVias BuscarDirElem(NodoMVias pt,int x){
        if (pt == null)
            return null;
        else{
            NodoMVias dir = null;
            for (int i=1; i <=pt.M; i++)
                if (dir == null)
                    dir = BuscarDirElem(pt.getHijo(i), x);
                else return dir;    
            
            if (dir == null ){
                for (int i=1; i<=pt.CantOcupados();i++)
                    if (pt.getElem(i) == x)
                       return pt;
                return null;
            }else return dir;            
        }
    } 
    
    //buscar direccion donde se encuenter el elemento
    private String BuscarDirElemxd(NodoMVias pt,int x){
        if (pt == null)
            return "";
        else{
            //aqui deberia ser cad
            String dir = "";
            for (int i=1; i <=pt.M; i++)//recorrer todos los hijos
                if (dir == "")
                    dir = BuscarDirElemxd(pt.getHijo(i), x);
                else return Integer.toString(pt.getElem(0))+"/"+dir ;     
            
            if (dir == "" ){
                for (int i=1; i<=pt.CantOcupados();i++)//recorriendo
                    if (pt.getElem(i) == x)
                       return Integer.toString(pt.getElem(i)); 
                
                return "";
            }else return dir; //return Integer.toString(pt.getElem(1))+"-"+dir ;            
        }
    } 
    
    public String BuscarDirElemxd(int x){
       return BuscarDirElemxd(raiz,x);
    }

                    

    
    //cantidad de nodo desde X // direccion es 
    private int CantidadNodos(NodoMVias pt){
        if( pt == null)
            return 0;
        if (esHoja(pt))
            return 1;
        else {
              int c = 0;
              for (int i = 1; i <= pt.M; i++) {
                 c = c + CantidadNodos(pt.getHijo(i));               
            }
             
              return c+1;
             }
    }
    
    public int cantidadNodos(){
        return CantidadNodos(raiz);
    }
    
    
    
    //mostrar los hijos de X
    private void mostrarHijosX(NodoMVias pt, JTextArea ta){
        if (pt == null)
            return;
        else {
             for (int i = 1; i <=pt.CantOcupados();i++)
                 ta.append(Integer.toString(pt.getElem(i))+" ");
             }
            
    }
    
    public void mostrarHijosX(int X ,JTextArea ta){
         mostrarHijosX(devolverDir(raiz, X),ta);
    }
    
    //encontrar la direccion exacta de X
    private NodoMVias devolverDir(NodoMVias pt, int x){
       if (pt == null)
           return null;
       else {
             while (pt != null){
                 int i = 1;
                 while (i <= pt.CantOcupados()){
                      if (pt.getElem(i) == x)
                          return pt;
                      i++;
                 }
                 i = getHijoDesc(pt, x);
                 pt = pt.getHijo(i);
             }
            return null;     
            }
    }
    
    public void mostrarHermanosX(int x, JTextArea ta){
        NodoMVias pt = devolverDir(raiz, x);
        mostrarHijosX(pt, ta);
    }

    
    
    
    
    //cantidad de todos elementos que se encuentra en el arbol
    private int cantidadTodosELem(NodoMVias pt){
         if (pt == null)
             return 0;
         if (esHoja(pt))
             return pt.CantOcupados();
         else {
             int c = 0;
              for (int i = 1; i <= pt.M; i++) {
                 c = c + cantidadTodosELem(pt.getHijo(i));
             }
              return c + pt.CantOcupados();
             }
    }
    
    public int cantidadTodosELem(){
        return cantidadTodosELem(raiz);
    
    }
    
    
    
    //altura de nodo de X
    private int alturaX(NodoMVias pt){
        if (pt == null)
            return 0;
        if(esHoja(pt))
            return 1;
        else{
            int c = 0;
            for (int i = 1; i <= pt.M; i++){
                int alt = alturaX(pt.getHijo(i));
                if (c < alt)
                    c = alt;
            }
                
            return c = c+1;
           }
    }
    
    public int alturaX(int x){
        return alturaX(devolverDir(raiz, x));
    };
    
    
    //esta en ese nodo
    private boolean EstaEnDir(NodoMVias pt, int x){
        if (pt == null)
            return false;
        for (int i = 1; i<=pt.CantOcupados();i++)
            if (pt.getElem(i) == x)
                return true;
        
        return false;
    }  
    
    //sacar nivel 
    private int nivelX(NodoMVias pt,int x){
        if (pt == null)
            return 0;
        else{
           // NodoMVias aux  = raiz;
           int c = 1;
            while (!EstaEnDir(pt, x) && pt != null){
                c++;
               int i = getHijoDesc(pt, x);
               pt = pt.getHijo(i);
            }
            if (pt == null)
                JOptionPane.showMessageDialog(null,"no se pillo X");          
            return c;
                  
            }
    }
    
    
    public int nivelX(int x){
        return nivelX(raiz,x);
    }
    
    
    //mostrar dir de padre de x
    private NodoMVias dirPadreX(NodoMVias pt, int x){
        if (pt == null)
            return null;
        else {
            NodoMVias aux = raiz;
            NodoMVias padre = null;
            while (!EstaEnDir(pt, x)){
                padre = pt;               
                pt= pt.getHijo(getHijoDesc(pt, x));
            }   
            return padre;
             }    
    }
    
    public void PadreX(int x, JTextArea ta){
        NodoMVias padre = dirPadreX(raiz, x);
        for (int i = 1; i <= padre.CantOcupados(); i++) {
            ta.append(Integer.toString(padre.getElem(i))+" ");
            
        }
    }
    
    
    
    
    
    
    
    
            
            
            
            
            
            
            
    
    
    
    /*
    private int altura(NodoMVias p){
        if (p == null)
            return 0;
        else{
            if (esHoja(p)){
                return 1;
            }else{
                int m = 0;
                for ( int i = 1; i <p.M;i++){
                    int a = altura(p.getHijo(i));
                    if ( a > m)
                        m = a;
                    }
                return m++;
                }
                
            }      
    }    */   
    
    private int mayoresX(NodoMVias pt,int x){
        int c = 0;
        for (int i = 1; i < pt.M;i++){
            if ( pt.getElem(i) > x)
                c++;
        }
        return c;
    }
    
    //cantidadMayoresX
    private int cantidadMayoresX(NodoMVias pt, int x){
        if (pt == null)
            return 0;
        if (esHoja(pt))
            return mayoresX(pt,x);
        else{
            int c = 0;
            for (int i=1; i <= pt.M; i++){
                c= cantidadMayoresX(pt.getHijo(i), x);
            }
            return c + mayoresX(pt, x);    
            }
    
    }
    
    public int cantidadMayoresX(int x){
        return cantidadMayoresX(raiz, x);
    }
        


    //
    
    //mostrar todos los pares
     private void mostrarPares(NodoMVias pt,JTextArea ta){
        if (pt == null)
            return ;
        if (esHoja(pt)){
            //metodo para mostrar pares en una direccion
            for (int i=1; i <= pt.CantOcupados();i++)
                if (pt.getElem(i)%2==0)
                    ta.append(Integer.toString(pt.getElem(i))+" ");
            }
        else{
        
            for (int i=1; i <= pt.M; i++)
                mostrarPares(pt.getHijo(i), ta);
           
            
            for (int i=1; i <= pt.CantOcupados();i++)
                if (pt.getElem(i)%2==0)
                    ta.append(Integer.toString(pt.getElem(i))+" ");
       
            
            }
    
    }
    
    public void mostraraPares(JTextArea ta){
        mostrarPares(raiz,ta);
    }
    
    
    //igual a tal elemento
    private boolean existe(NodoMVias pt,int x){
        if (pt == null)
            return false;
        else{
            boolean ban = false;
            for (int i = 1; i <= pt.M;i++){
                ban = existe(pt.getHijo(i), x);
            }
            if (ban == false)
                for (int i = 1; i <= pt.CantOcupados();i++){
                    if (pt.getElem(i) == x)
                        ban = true;
                }
            return ban;
            }
    }
   
    public boolean existe(int x){
        return existe(raiz, x);
    }
    
    //mostrar hijos de un nodo X
    //buscar direccion del elemento X;
    private NodoMVias MostrarDireccion(NodoMVias pt,int x){
        if ( pt == null)
            return null;  
        else{
            NodoMVias dir=null;
            for (int i = 1; i <= pt.M;i++)
                dir = MostrarDireccion(pt.getHijo(i), x);            
            
            for (int j = 1; j<= pt.CantOcupados(); j++)
                if (pt.getElem(j) == x)
                    dir = pt;
            
            return dir;
            }       
    }
    
    //public mostrarDireccion()
    /*
    private void nombre(NodoMVias pt, JTextArea ta){
        
    }
    
    public  void nombre(NodoMVias pt, JTextArea ta){
        
    }
    
    
    
    
    
    
    //mostrar el nicvel en donde se encuentr el nive de dir
    
    private int nivelXdir(NodoMVias pt){
          if (pt == null)
              return 0;
          else {
               
               }
    }
    
    public  int nivelXdir(NodoMVias pt, int x){
         //buscar dir e enviar pt on tal direccion 
    }
    
    */
    
    //dadno un arbol n-vias verificar si un arbol es dub arbol de otro
    //esta dentro
    private boolean EstaDentro(NodoMVias A, NodoMVias B){
        if (A== null && B == null )
            return true;
        if (A != null && B == null )
            return true;
        if (A == null && B != null) 
             return false;
        else { 
            boolean ban = true;   
            for (int i = 1; i <= A.M;i++){
                if (ban != false)
                    ban = EstaDentro(A.getHijo(i),B.getHijo(i));
            }
            //igual pt A B
            if (A.CantOcupados() == B.CantOcupados()){
                for (int i = 1; i <= A.CantOcupados();i++) 
                    if (A.getElem(i) != B.getElem(i))
                        return false;                
            }else return false;
            
            if (ban == true ){ 
                return true;
            }else return false;
        }
    }
    
     //
     public boolean subArbol(NodoMVias A,NodoMVias B){
         if (A== null )
            return false;
         else {
             boolean ban = false;
             for (int i = 1; i <= A.M;i++){
                 
                 if (ban != true)
                ban =  subArbol(A.getHijo(i),B);           
             }
              if(sonIguales(A, B))
                  ban = EstaDentro(A,B);      
            return ban;
            
         }
         
     }
    
    public  boolean subArbol(ArbolMVias B){
        //recorrer a y comparar con b   
        return subArbol(raiz,B.raiz);
    }
    
    //A y B son iguales
    private boolean sonIguales(NodoMVias A, NodoMVias B){
        if (A.CantOcupados() == B.CantOcupados()){
            for (int i = 1; i <= A.CantOcupados(); i++) {
                if (A.getElem(i)!=B.getElem(i))
                    return false;
                
            }
            return true;
        }else return false;
    }
    
     public boolean sonIguales(ArbolMVias B){
        return sonIguales(raiz,B.raiz);
     }
     
    //
    
}//end class


