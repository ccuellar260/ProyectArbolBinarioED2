/*
Titulo: Implementacion de la clase Arbol Binario
Nombre: Cristian Cuellar SErrano
Fecha: 13/02/2022
Version 1.0
Nombre de proyecto:ProyectArbolBinario 
*/
package PackegeArbolBinarioForm;

import javax.swing.JTextArea;

public class ArbolBinarioF {
   private NodoArbol raiz;
  
   public ArbolBinarioF(){
      raiz = null;
   }
   public ArbolBinarioF(int e){
      raiz = new NodoArbol(e);
   }
   
   //esHoja
   public boolean EsHoja(NodoArbol pt){
       return pt.getHijoDer() == null && pt.getHijoIzq() == null;
   }
   
   //metodos
  
   public void Insertar(int e){
       if (raiz == null){
           raiz = new NodoArbol(e);
       }else{
            NodoArbol padre = null;
            NodoArbol hijo = raiz;
            while (hijo != null){
                padre = hijo;
                if ( e > hijo.getElem())
                    hijo = hijo.getHijoDer();
                else 
                    if (e < hijo.getElem())
                        hijo = hijo.getHijoIzq();       
                    else return;
            }
            
            if ( e > padre.getElem()){
                padre.setHijoDer(new NodoArbol(e));           
            }else 
                if ( e < padre.getElem())
                    padre.setHijoIzq(new NodoArbol(e));
           }
           
   }
   
   //metodos para mostrar
    private void inOrden(JTextArea ta, NodoArbol pt){
        if (pt == null)
           return;
        if ( EsHoja(pt))
            ta.append(Integer.toString(pt.getElem())+" ");
        else{
            inOrden(ta, pt.getHijoIzq());
            ta.append(Integer.toString(pt.getElem())+" ");
            inOrden(ta, pt.getHijoDer());           
            }      
    }
    
    public void inOrden(JTextArea ta){
       inOrden(ta, raiz);
    }
    
    private void preOrden(NodoArbol pt,JTextArea ta){
        if (pt == null)
            return;
        if (EsHoja(pt))
            ta.append(Integer.toString(pt.getElem())+" ");
        else{
            ta.append(Integer.toString(pt.getElem())+" ");
            preOrden(pt.getHijoIzq(), ta);
            preOrden(pt.getHijoDer(), ta);           
            }
        
    }
    
    public void preOrden(JTextArea ta){
        preOrden(raiz, ta);
    }
    
    private void postOrden(NodoArbol pt,JTextArea ta){
        if (pt == null)
            return;
        if (EsHoja(pt))
            ta.append(Integer.toString(pt.getElem())+" ");
        else{
            postOrden(pt.getHijoIzq(), ta);
            postOrden(pt.getHijoDer(), ta);  
            ta.append(Integer.toString(pt.getElem())+" ");
            }
        
    }
    
    public void postOrden(JTextArea ta){
        postOrden(raiz, ta);
    }    
    
    //cuantos elementos hay en el nodo
    private int cantidad(NodoArbol pt){
        if (pt == null)
           return 0;
        else if (EsHoja(pt))
           return 1;
        else{
            int cantIzq = cantidad(pt.getHijoIzq());
            int cantDer = cantidad(pt.getHijoDer());
            return cantIzq + cantDer + 1;
            }  
    }
    
    public int cantidad(){
       return cantidad(raiz);
    }
    
    
    //suma de todos los elementos 
    private int sumaElementos(NodoArbol pt){
        if (pt == null)
            return 0;
        if (EsHoja(pt))
            return pt.getElem();
        else{
            int sumIzq = sumaElementos(pt.getHijoIzq());
            int sumDer = sumaElementos(pt.getHijoDer());
            return sumIzq + sumDer + pt.getElem();
            }
    }
    
    public int sumaElementos(){
        return sumaElementos(raiz);
    }
    
     
   //suma de elementos pares
    private int SumaPares(NodoArbol pt){
        if ( pt == null)
           return 0;
        if (EsHoja(pt)) 
            if (pt.getElem() % 2 == 0 )
                return pt.getElem();              
            else return 0;       
                
        else{                                                  
            int s1 = SumaPares(pt.getHijoIzq());
            int s2 = SumaPares(pt.getHijoDer());
                     
            if (pt.getElem() % 2 == 0 )
                return s1 + s2 + pt.getElem();
            else 
                return s1 + s2;                   
            }     
    }
 
    public int SumaPares(){
         return SumaPares(raiz);
    }
    
    
    //mostrar Padres
    private void mostrarPadres(NodoArbol pr,JTextArea ta){
     if (pr == null){
        return ;
     }else {
          if (EsHoja(pr)){
             return ;        
          }else {
                mostrarPadres(pr.getHijoDer(),ta);
                mostrarPadres(pr.getHijoIzq(),ta);
                    if ((pr.getHijoDer()!= null) || (pr.getHijoIzq()!= null)){             
                       ta.append(String.valueOf(pr.getElem()+ " "));
                       // System.out.println(pr.getElem()+"");
                    } 
                                            
                }     
     
         }
    };
  
    public void mostrarPadres(JTextArea ta){ 
    mostrarPadres(raiz,ta);
    };    
    
    //sacar la altuta contando a la raiz
    private int profundidad(NodoArbol pt){
        if( pt == null)
            return 0;
        if (EsHoja(pt))
            return 1;
        else{
            int altIzq = profundidad(pt.getHijoIzq());
            int altDer = profundidad(pt.getHijoDer());
            if (altIzq > altDer)
                return altIzq + 1;
            else return altDer + 1;
            }
    }
    
    public int profundidad(){
        return altura(raiz);
    }
    
    
    //altura sin contar la raiz
    private int altura(NodoArbol pt){
        if( pt == null)
            return 0;
        if (EsHoja(pt))
            return 0;
        else{
            int altIzq = altura(pt.getHijoIzq());
            int altDer = altura(pt.getHijoDer());
            if (altIzq > altDer)
                return altIzq + 1;
            else return altDer + 1;
            }
    }
    
    public int altura(){
        return altura(raiz);
    }
    
    
    //verificar si existe tal elemento enviado 
    private boolean BuscarElem(NodoArbol pr,int e){
     if ( pr == null ){
        return false;
     }else if ( EsHoja(pr)){
              return pr.getElem()==e;
           }else {
                 boolean ai = BuscarElem(pr.getHijoIzq(), e);
                 boolean ad = BuscarElem(pr.getHijoDer(), e);
                 if ( ai == true  || ad == true || pr.getElem() == e){
                     return true;
                 }else {return false; 
                         }
  
                 }
    }
  
    public boolean BuscarElem(int e){
    return BuscarElem(raiz, e); 
    }
    
    
    // MOSTRAR LOS ELEMENTOS MAYORES QUE X;
    private void mayoresX(NodoArbol pr,int x,JTextArea ta){
     if (pr != null){
         if (EsHoja(pr)){
               if (pr.getElem() > x){
                    ta.append(String.valueOf(pr.getElem()+ " "));
                  
               }
           }else {
                  mayoresX(pr.getHijoIzq(),x,ta);
                  mayoresX(pr.getHijoDer(),x,ta);
                  if (pr.getElem() > x){
                    ta.append(String.valueOf(pr.getElem()+ " "));  
                   
                  }
     
     
                 }
        }
    }
  
     public void mayoresX(JTextArea ta,int x){
      mayoresX(raiz, x,ta);
    }
     
       //pregunta si hay hijo en el hijo xd
    private boolean esHijo(NodoArbol ptr, int hijo){
        if ( ptr == null){
            return false;
        }else if (!EsHoja(ptr)){
                if (ptr.getHijoIzq() != null && ptr.getHijoIzq().getElem()==hijo)
                   return true;
                if (ptr.getHijoDer() != null && ptr.getHijoDer().getElem()==hijo)
                   return true;
            }
     return false;
    }
   
    
     
     //Devolver el elemento del abuelo de x;
    private int devolverAbuelo(NodoArbol pt,int x){
        if (pt == null)
            return 0;
        if (altura(pt) <2)
            return 0;
        else{
            int ai = devolverAbuelo(pt.getHijoIzq(),x);
            int ad = devolverAbuelo(pt.getHijoDer(),x);
            if (pt.getHijoIzq()!=null)
                if (pt.getHijoIzq().getHijoIzq() != null)
                    if(pt.getHijoIzq().getHijoIzq().getElem() == x)
                        return pt.getElem();
            
            if (pt.getHijoIzq()!=null)
                if (pt.getHijoIzq().getHijoDer() != null)
                    if(pt.getHijoIzq().getHijoDer().getElem() == x)
                        return pt.getElem();
            
            if (pt.getHijoDer()!=null)
                if (pt.getHijoDer().getHijoIzq() != null)
                    if(pt.getHijoDer().getHijoIzq().getElem() == x)
                        return pt.getElem();
            
            if (pt.getHijoDer()!=null)
                if (pt.getHijoDer().getHijoDer() != null)
                    if(pt.getHijoDer().getHijoDer().getElem() == x)
                        return pt.getElem();       
            
            if (ai != 0)
               return ai;
            else 
                if (ad != 0)
                    return ad;
                else return 0;
            }      
    } 
    
    public int devolverAbuelo(int x){
        return devolverAbuelo(raiz, x);
    } 
 
     
    //devolver Padre de x
    private int devolverPadre(NodoArbol ptr,int x){
        if (ptr == null)
            return 0;
        if (EsHoja(ptr))
            return 0;
        else{
            int ai = devolverPadre(ptr.getHijoIzq(),x);
            int ad = devolverPadre(ptr.getHijoDer(), x);
            if (ptr.getHijoIzq() != null)
                if (ptr.getHijoIzq().getElem() == x)
                    return ptr.getElem();
            if (ptr.getHijoDer() != null)
                if (ptr.getHijoDer().getElem() == x)
                    return ptr.getElem();
            
            if (ai != 0)
                return ai;
            else if (ad != 0)
                    return ad;
                else return 0;
            }          
    }
    
    public int devolverPadre(int x){
       return devolverPadre(raiz, x);
    };
    
    
    /*
    private void mostrarNietos(NodoArbolBi ptr, int x){
        if ( ptr == null)
           return;
        if (ptr.getElem() == x){
           if (ptr.getHijoDer() != null){
               if (ptr.getHijoDer().getHijoIzq() != null)
                  //ta.append(Integer.toString(ptr.getHijoDer().getHijoIzq().getElem())+" ");
                   System.out.println(ptr.getHijoDer().getHijoIzq().getElem()+"");
               if (ptr.getHijoDer().getHijoDer()!= null)
                  //ta.append(Integer.toString(ptr.getHijoDer().getHijoDer().getElem())+" ");
                   System.out.println(ptr.getHijoDer().getHijoDer().getElem())+" ");
           }
           if (ptr.getHijoIzq()!= null){
               if (ptr.getHijoIzq().getHijoDer()!= null)
                  //ta.append(Integer.toString(ptr.getHijoIzq().getHijoDer().getElem())+" ");
                   System.out.println(ptr.getHijoIzq().getHijoDer().getElem())+" ");
               if (ptr.getHijoIzq().getHijoIzq()!= null)
                  //ta.append(Integer.toString(ptr.getHijoIzq().getHijoIzq().getElem())+" ");
                   System.out.println(ptr.getHijoIzq().getHijoIzq().getElem())+" "); 
            } 
        }//endl if 
        if ( x > ptr.getElem())
            mostrarNietos(ptr.getHijoDer(), x);
        else if ( x > ptr.getElem())
            mostrarNietos(ptr.getHijoIzq(), x);
    }
   
    public void mostrarNietos(int x){
        mostrarNietos(raiz,x);
    }
     */
    
     
    public void eliminar(int x){      
        NodoArbol p = raiz;
        NodoArbol ap = null;
        //buscando la direccion donde se encuentra x
        while ( p != null && p.getElem() != x){
            ap = p;
            if ( x > p.getElem())
                p = p.getHijoDer();
            else p = p.getHijoIzq();
        }
        if ( raiz == null)
            return; //significa que nose encontro el elemento
        if ( EsHoja(p))
            elimCaso1(ap,p);
       else 
           if ((p.getHijoDer() != null && p.getHijoIzq() == null) || 
                   (p.getHijoDer() == null && p.getHijoIzq() != null ))
               elimCaso2(ap,p);
               else elimCaso3(p);              
     
    }  
     
    //igualdad entre 2 nodos
    
    //METODO PARA ELIMINAR
    private void elimCaso1(NodoArbol ap,NodoArbol p){
        if (ap == null)
            raiz = null;
        else{
            if (p == ap.getHijoDer())
                ap.setHijoDer(null);
            else ap.setHijoIzq(null);
            }
    }
    
    private void elimCaso2(NodoArbol ap, NodoArbol p){
        if(ap == null)
            if (p.getHijoDer() != null)
                raiz = p.getHijoDer();
            else raiz = p.getHijoIzq();
        else{
            if ( p == ap.getHijoDer())
                if (p.getHijoDer() != null)
                    ap.setHijoDer(p.getHijoDer());
                else ap.setHijoDer(p.getHijoIzq());
            else 
                if (p.getHijoDer() != null)
                    ap.setHijoDer(p.getHijoDer());
                else ap.setHijoIzq(p.getHijoIzq());
            }   
        
    }
    
    private void elimCaso3(NodoArbol p){
        NodoArbol s = p.getHijoDer();
        NodoArbol as = null;
        while (s.getHijoIzq() != null){
            as = s;
            s = s.getHijoIzq();
        }
        int aux = p.getElem();
        p.setElem(s.getElem());
        s.setElem(aux);
        if ( as == null)
            p.setHijoDer(null);
        else as.setHijoIzq(null);
    } 
    
    
    private int facEquilibrio(NodoArbol ptr,int e){
       //buscar la ubicacion de e
        if (ptr == null || EsHoja(ptr)){
           return 0;
        }else{
            int ai = facEquilibrio(ptr.getHijoIzq(), e);
            int ad = facEquilibrio(ptr.getHijoDer(), e);
            return altura(ptr.getHijoIzq())-altura(ptr.getHijoDer()); 
           }             
    }
    
    public int facEquilibrio(int e){
       return facEquilibrio(raiz,e);
    }
    
    //verificar si un arbol son iguales 
    private boolean IgualdadArbol(NodoArbol a, NodoArbol b){       
        if (a == null && b == null)
           return true;
        if ((a == null && b != null)|| (b == null && a != null))
            return false;
        else{
            boolean ai;
            boolean ad;
             if (a.getElem() == b.getElem()){
                ai = IgualdadArbol(a.getHijoIzq(), b.getHijoIzq());
                ad = IgualdadArbol(a.getHijoDer(), b.getHijoDer());              
            }else return false;
            
            if (ai == true && ad ==true)
                return true;
            else return false;
            } 
        
    }
    
    public boolean IgualdadArbol(ArbolBinarioF b){
        return IgualdadArbol(raiz, b.raiz);
    }
    
    
    //METODO PARA SABER SI ESTA ADENTRO DE OTRO ARBOL
    private boolean IgualdadDentroArbol(NodoArbol a, NodoArbol b){       
        if (a == null && b == null)
           return true; 
        if (a == null && b!=null)
            return false;
        if (a != null && b==null)
            return true;
        else{
            boolean ai;
            boolean ad;
             if (a.getElem() == b.getElem()){
                ai = IgualdadDentroArbol(a.getHijoIzq(), b.getHijoIzq());
                ad = IgualdadDentroArbol(a.getHijoDer(), b.getHijoDer());              
            }else return false;
            
            if (ai == true && ad ==true)
                return true;
            else return false;
            } 
        
    }
    
    public boolean IgualdadDentroArbol(ArbolBinarioF b){
        return IgualdadDentroArbol(raiz, b.raiz);
    }
    
    
    
    
    private boolean verificarSubArbol(NodoArbol a, NodoArbol b){
        if (a == null && b == null)
            return true;
        if ((a == null && b != null)|| (b == null && a != null))
            return false;
        else{
            if (a.getHijoDer()!=null && a.getHijoDer().getElem() == b.getElem())
                return IgualdadDentroArbol(a.getHijoDer(), b);
            if (a.getHijoIzq()!=null && a.getHijoIzq().getElem() == b.getElem())
                return IgualdadDentroArbol(a.getHijoIzq(), b);
            boolean ai = verificarSubArbol(a.getHijoIzq(), b);
            boolean ad = verificarSubArbol(a.getHijoDer(), b);
            
            if (ai == true || ad == true)
                return true;
            else return false;
            }
    }
    
    public boolean verificarSubArbol(ArbolBinarioF b){
        return verificarSubArbol(raiz, b.raiz);
    }
    
    
    
    
    
    //--------------------------------------------------------------------------
    //EXAMENES 
    //Suma todos los elementos en el mismo nivel 
    //sacar el nivel de elemento 
    private int sacarNivel(NodoArbol pt, int e){
        if (pt == null)
            return 0;
        int c = 1;
        while ( pt.getElem() != e ){
            c++;
            if (e > pt.getElem())
                pt = pt.getHijoDer();
            else pt = pt.getHijoIzq();                       
        }
        return c;      
    }
    
    public int sacarNivel(int e){
        return sacarNivel(raiz, e);
    }
    
    private int sumaElemLevel(NodoArbol pt, int nivel){
        if ( pt == null) 
            return 0;
        else{
            int ai = sumaElemLevel(pt.getHijoIzq(), nivel);
            int ad = sumaElemLevel(pt.getHijoDer(), nivel);
            if (sacarNivel(pt.getElem()) == nivel)
                return ai + ad + pt.getElem();
            else return ai + ad;
            
            }        
    }

    public int sumaElemLevel(int nivel){
        return sumaElemLevel(raiz, nivel);
    }    
    
    
    //mostrar elementos que esten debajo de un nivel x
    private void mostrarAbajoNivel(NodoArbol pt, int nivel,JTextArea ta){
        if ( pt == null) 
            return;
        else{
            mostrarAbajoNivel(pt.getHijoIzq(), nivel,ta);
            mostrarAbajoNivel(pt.getHijoDer(), nivel, ta);
            if (sacarNivel(pt.getElem()) >= nivel)
                ta.append(Integer.toString(pt.getElem())+" ");
            }        
    }

    public void mostrarAbajoNivel(int nivel,JTextArea ta){
        mostrarAbajoNivel(raiz, nivel, ta);
    }   
    
    //Mostrar elementos del mismo nivel
     private void mostrarELemNivel(NodoArbol pt, int nivel,JTextArea ta){
        if ( pt == null) 
            return;
        else{
            mostrarELemNivel(pt.getHijoIzq(), nivel,ta);
            mostrarELemNivel(pt.getHijoDer(), nivel, ta);
            if (sacarNivel(pt.getElem()) == nivel)
                ta.append(Integer.toString(pt.getElem())+" ");
            }        
    }

    public void mostrarElemNivel(int nivel,JTextArea ta){
        mostrarELemNivel(raiz, nivel, ta);
    }   
    
    
    
    //Mostrar los ultimos del arbol
    //metodo que devuel la direccion de un metodo
    private NodoArbol buscarDirElemento(NodoArbol pt, int e){
        if (pt == null)
            return null;
        //buscar la direccion 
        while (pt.getElem() != e){
            if (e > pt.getElem())
                pt = pt.getHijoDer();
            else pt = pt.getHijoIzq();
        }
        return pt;
    }
            
    
    public void mostrarHojasX(NodoArbol pt,int e, JTextArea ta){
        if (pt == null)
            return;
        if (EsHoja(pt))
            ta.append(Integer.toString(pt.getElem())+" ");
        else{
            mostrarHojasX(pt.getHijoIzq(), e, ta);
            mostrarHojasX(pt.getHijoDer(), e, ta);
            }
    }
    
    public void mostrarHojasX(int e,JTextArea ta){
        mostrarHojasX(buscarDirElemento(raiz, e),e,ta);
    }
    
    // mostrar sobrinos de x
    //mostrar padres x devuelve nodo
    private NodoArbol mostrarPadreX(NodoArbol pt){
        NodoArbol anterior = null;
        NodoArbol dir = raiz;
        while (dir != pt ){
            anterior = dir;
            if (pt.getElem() > dir.getElem())
                dir = dir.getHijoDer();
            else dir = dir.getHijoIzq();           
        }
        return anterior;
    }
    
    public int mostrarPadresX(int e){
        return mostrarPadreX(buscarDirElemento(raiz, e)).getElem();   
    }
   
    
    //mostrar sobrinos
    private void mostrarSobrinosX(NodoArbol pt,JTextArea ta){
        if (pt == null)
            return;
        NodoArbol Padre = mostrarPadreX(pt);
        if (Padre.getHijoDer() == pt){
            ta.append(Integer.toString(Padre.getHijoIzq().getHijoIzq().getElem())+" ");
            ta.append(Integer.toString(Padre.getHijoIzq().getHijoDer().getElem())+" ");
        }else{
            ta.append(Integer.toString(Padre.getHijoDer().getHijoIzq().getElem())+" ");            
            ta.append(Integer.toString(Padre.getHijoDer().getHijoDer().getElem())+" ");
            }
        
    }
    
    public void mostrarSobrinosX(int e,JTextArea ta){       
        mostrarSobrinosX(buscarDirElemento(raiz, e), ta);
    }

    //mostra hermano
    private NodoArbol devolverHermano(NodoArbol pt){       
        if (pt == null)
            return null;
        NodoArbol padre = mostrarPadreX(pt); 
        if (padre.getHijoDer() == pt )
            return padre.getHijoIzq();
        else return padre.getHijoDer();
    }
    
    public void mostrarTioX(NodoArbol pt, JTextArea ta){
        if (pt == null)
            return;
        NodoArbol padre = mostrarPadreX(pt);
        NodoArbol HrnoPa = devolverHermano(padre);
        ta.append(Integer.toString(HrnoPa.getElem()));
    }
    
    public void mostrarTioX(int e, JTextArea ta){
        mostrarTioX(buscarDirElemento(raiz, e), ta);
    }
    
    
    
    //METODOS DE OSCAR
    private int alturaarbol(NodoArbol pr){
    if (pr==null){
        return 0;
    }
    if(EsHoja(pr)){
       return 1;
    }else{
        int d=alturaarbol(pr.getHijoDer());
        int i=alturaarbol(pr.getHijoIzq());
        if(d>i){
            return d+1;
        }else{
            return i+1;
        }
    }
    }
    
    public int alturaarbol(){
    return alturaarbol(raiz);   
    }
    
    private int alturaNodo(NodoArbol pr, int x){
    int c=0; boolean b=false;
    while(pr!=null &&b==false){
        if(x>pr.getElem()){
            pr=pr.getHijoDer();
        }else
        {
            if(x<pr.getElem()){
           pr= pr.getHijoIzq();
        }else{
                b=true;
            }
            
        }
        c=c+1;
               
    }
    return c;
    }
    
    public int alturaNodo(int x){
        return alturaNodo(raiz, x);
    }
    
private String mostrarultimosnodos(NodoArbol pr,int alt,JTextArea jt,String s){
    if (pr==null){
        return "";
        }
    if(EsHoja(pr)){
        if(alturaNodo(pr.getElem())==alt){
         s=String.valueOf(pr.getElem())+" ";  
         return s;
        }
    }else{
         String d= mostrarultimosnodos(pr.getHijoDer(),alt,jt,s);
         String i=mostrarultimosnodos(pr.getHijoIzq(),alt,jt,s);
         s=d+i;    
         return s; 
    }
    return s;
    
}
public void mostrarultimosnodos(JTextArea jt,String s){
  jt.append(mostrarultimosnodos(raiz,alturaarbol(raiz),jt, s)); ;
}

//prmio de X
    private NodoArbol devolverdir(NodoArbol pt, int x){
        if( pt == null)
            return null;
        else {
             while ( pt.getElem() != x && pt != null)
                 if (x > pt.getElem())
                     pt = pt.getHijoDer();
                 else pt = pt.getHijoIzq();
             }
            return pt;
    };
    
    //mostrar abuelos de x
    private NodoArbol devolverAbue(NodoArbol pt ){
        if (pt == null )
            return null;
        else {
             NodoArbol padre = null;
             NodoArbol aux= raiz;
             while (aux != pt && aux != null  ){
                   padre = aux;
                   if ( pt.getElem() > aux.getElem())
                       aux = aux.getHijoDer();
                   else   aux = aux.getHijoIzq();
             }
            //  padre = devolverAbue( padre);
             return padre;
             }
    }
    
    private void mostrarPrimosX(NodoArbol pt, JTextArea ta){
         if( pt == null)
             return;
         else {
              NodoArbol padre =  devolverAbue(pt);
              NodoArbol abue = devolverAbue(padre);
              //mostrar hijos de hijos
              if (abue.getHijoDer() != padre){ 
                    ta.append(Integer.toString(abue.getHijoDer().getHijoIzq().getElem())+" ");
                    ta.append(Integer.toString(abue.getHijoDer().getHijoDer().getElem())+" ");
              }else {
                    ta.append(Integer.toString(abue.getHijoIzq().getHijoIzq().getElem())+" ");
                    ta.append(Integer.toString(abue.getHijoIzq().getHijoDer().getElem())+" ");
                      }
               
                  //mostrar hiojs 
          }
         
             
    
    }

    public void mostrarPrimosX(int x , JTextArea ta){
       mostrarPrimosX(devolverdir(raiz, x),ta);
       
      
    }
    
    
    //igualdad de nodoa
    private boolean igualdadNodos2(NodoArbol A, NodoArbol B){
         if (A== null && B == null )
            return true;
        if (A != null && B == null || A == null && B != null)
            return false;
        else {
             boolean ai = igualdadNodos2(A.getHijoIzq(), B.getHijoIzq());
             boolean ad = igualdadNodos2(A.getHijoDer(), B.getHijoDer());            
             if ( A.getElem() == B.getElem() ){
                 if (ai == true && ad == true )
                     return true;
                 else return false;
             }else return false;
        }
    }
    
    //comparar si el arbol a es igaula a otro.
    public boolean igualdaArboles2(ArbolBinarioF Al){
        return igualdadNodos2(raiz, Al.raiz);
    }
    
    //1er parcial de ed2 de peinado 
    //mostrar pader, hi, hd 
    
      private boolean ESHijo( NodoArbol pt){
          if ((pt.getHijoIzq() == null)&&(pt.getHijoDer()== null)){
              return true;
            }
          
      return false;}
      
   //metodos para mostrar
    private void Parcial1(JTextArea ta, NodoArbol pt){
        if (pt == null)
           return;
        if ( EsHoja(pt))
              return;
         //   ta.append(Integer.toString(pt.getElem())+" ");
        else{
         //   int padre =    pt.getElem();
       //   ta.append(Integer.toString(pt.getElem())+" ");
            
            Parcial1(ta, pt.getHijoIzq());
           
            Parcial1(ta, pt.getHijoDer());  
            
           if ((pt.getHijoIzq() != null)||(pt.getHijoDer()!= null)){
                ta.append(Integer.toString(pt.getElem())+" ");
               if(pt.getHijoIzq() != null){     
                ta.append(Integer.toString(pt.getHijoIzq().getElem())+" ");
               }
               if(pt.getHijoDer() != null){     
                ta.append(Integer.toString(pt.getHijoDer().getElem())+" ");
               }
               
           }
            //es diferente a hoja elem = pt.getHijoIzq().getElem();
            
            
            //retornas Hi Hd
            
            }      
    }
    
    
    public void Parcial1(JTextArea ta){
        Parcial1(ta, raiz);
    }
    
    
}//endl class
