 package PackegeGrafos;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;


//Grafos no dirigidos, matriz de adyacencia

public class Grafo {
    private static int max=10;
    private int M[][];
    private String Nombre[];
    private int Peso[][];
    private int n; //??
    private boolean marcado[]; //Esta marcado
    
    
    
    //camino mas corto
    private boolean tachado[];
    private static int infinito= 999999999;;
   // int VecFinal[];
 //   int VecTemporal[];

    public Grafo(){
        M = new int[max][max];
        for(int i =0; i<max; i++){
            for(int j=0; j<max; j++){
                M[i][j] = 0;
            }
        } 
        Nombre = new String[max];      
        Peso = new int[max][max];
        
        n = -1;
        marcado = new boolean[max+1];
    }
    
    
    public void crearVertice(String cad){
        if (n == max){
            JOptionPane.showMessageDialog(null, "Numero de vertice igual a" + max+1);
            return;
        }
        n++;
        Nombre[n]= cad;
        
    }
    
    public int cantVertices(){ 
        return n+1; 
    }
    
    public boolean esVerticeValido(int v){
        return (v>=0 && v<=n); 
    }
    
    public void insertarArco(int u, int v,int p){ //p =pedir peso
        if (!esVerticeValido(u) || !esVerticeValido(v)){
            JOptionPane.showMessageDialog(null, "No es un vertice valido"); return ;
        }
        M[u][v] = 1;
     //   M[v][u] = 1;
        Peso[u][v] = p;
    //    Peso[v][u] = p;
    }
    
    public void eliminarArco(int u, int v){
        if (!esVerticeValido(u) || !esVerticeValido(v))
            return; //No existe el vertice u o el vertice v.
        M[u][v] = 0;
        M[v][u] = 0;
    }

    private void desmarcarTodos(){
        for (int i = 0; i <= n; i++) {
            marcado[i] = false;
        }
    }
    
    private void marcar(int u){
        if (esVerticeValido(u))
            marcado[u] = true;
    }
    
    private void desmarcar(int u){
        if (esVerticeValido(u))
            marcado[u] = false;
    }
    
    private boolean esMarcado(int u){ //Devuelve true, si el vertice u está marcado.
        return marcado[u];
    }
    
    public int getArco(int i, int j){
        return M[i][j];
    }
    
    public void mostrar(JTextArea ta){
        ta.append("    ");
        for (int i=0; i <= n;i++)
             ta.append(i+"   ");
        ta.append("\n");
        
        for (int i=0; i <= n;i++){ 
             ta.append(i+" ");
            for (int j=0; j <=n ;j++){
                ta.append("["+Integer.toString(M[i][j]) +"] ");             
            }
            ta.append("\n");
        }
    
    }
    
    public int NumDepartamento(String A){
        for (int i = 0 ; i <= n;i++){
            if (Nombre[i].equals(A)){
               return i;
            }
        }
        return -1;
    
    }
    
    public void Mostrardistancia(String A,String B, JTextArea ta){
        int DepaA= NumDepartamento(A);
        int DepaB= NumDepartamento(B);
        if (DepaA != -1 && DepaB != -1)
            ta.append(A+" --> "+ B + " hay una distancia de: "
                    +Peso[DepaA][DepaB]+" Kilometos");
        else ta.append("No se encontro tal ciudad");
        
            
    }
    
    private void inicializarVectorAuxiliares(int[] A,int[] B){   
        //inicio vectores 
        for (int i=0; i <= n;i++ ){
            A[i]=infinito;
            B[i]=infinito;      
            tachado[i] = false;
        }
    }
    
    public void CaminoCorto(String A, String B,JTextArea ta){
        tachado = new boolean [max];
        int VecFinal[] = new int [max];
        int VecTemporal[] = new int [max];
        inicializarVectorAuxiliares(VecFinal,VecTemporal);
        int i = NumDepartamento(A);
        VecFinal[i]=0;
        VecTemporal[i]=0;
        while (i<=n){
            VecFinal[i]=VecTemporal[i];
            tachado[i] = true;
            //recorrer los arcos 
            for (int j= 0; j <= n; j++){
                if (M[i][j] == 1 && !tachado[j])//para verifcar sus arcos
                   // if (VecTemporal[j]==infinito)
                    //    VecTemporal[j] = 0;       
                    if((VecFinal[i] + Peso[i][j])<VecTemporal[j])
                        VecTemporal[j] = VecFinal[i] + Peso[i][j];         
            }
            i = CualEsMenor(VecTemporal);           
        }
       
        //mostrar ruta
        
        i = NumDepartamento(A);
        int k = NumDepartamento(B);        
        String Cad = Nombre[k];
        while (i != k){
            int l=0;
            //recorrer los arcos de k
            while (l<=n){
                if (M[k][l] == 1)
                    if (VecFinal[k] - Peso[k][l] == VecFinal[l]){
                        k = l;
                        Cad = Nombre[k]+ ", "+Cad;
                        mostarPeso(k,l,ta);
                       
                        break;
                    }
            l++;
            }
        }
        
        ta.append("Es Camino mas corto entre "+ A +" y "+B+" es: "+
                Cad);
        ta.append("\nY tiene una distancia de "+Integer
                .toString(VecFinal[NumDepartamento(B)])+"kilometros");
        
    
    }
    
    
     //dinujar peso entre cad a y cad B
    public void mostarPeso(int a,int b,JTextArea ta){
        String A = Nombre[a];
        String B = Nombre[b];
        ta.append(A+" --> " +B+ " = "+Integer.toString(Peso[a][b])+"\n");

    }
         
    private int CualEsMenor(int[] VecTemporal){
        int menor = infinito;
        int aux = infinito;
        for (int i=0; i <= n;i++ ){
            if ( !tachado[i] && VecTemporal[i] < menor)   {      
                menor = VecTemporal[i];
                aux = i;
            }
        }
        return aux;
    }
    
    public int mostarPeso(int a,int b){
        return Peso[a][b];
    }
    
    
    
    //mostrar todos los caminos que de A a B mostrando su costo total 
    
    
    
    //verificar si un arbol es ternario 
    public boolean EsTernario(String A){
         int i = NumDepartamento(A); //saco la posicion de A
         int c= 0;
        
         for (int j = 0; j <= n;j++)
            if(M[i][j] == 1)          
                c++;
          boolean ban = true;
         if (c <= 3){
             if (c==0){
                 return true;
             }else { for (int j = 1; j <= n;j++){
                          if(M[i][j] == 1)          
                                ban = EsTernario(Nombre[j]);    
                        }
                     

                     return ban;
                    }
         }else return false;    
    };
    
    
}//the end