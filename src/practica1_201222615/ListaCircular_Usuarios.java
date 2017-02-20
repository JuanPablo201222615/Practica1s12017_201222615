/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201222615;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author jp_gm
 */
public class ListaCircular_Usuarios 
{
    NodoListaCircular_Usuarios primero;
    NodoListaCircular_Usuarios ultimo;
    NodoListaSimple_FichasJugador union;
   
    
    
    public ListaCircular_Usuarios()
    {
     NodoListaCircular_Usuarios circular = new NodoListaCircular_Usuarios();
    NodoListaSimple_FichasJugador simple = new NodoListaSimple_FichasJugador();
     circular.union = simple;
     primero = null;
     ultimo = null;
     union = null;
    }
    
    public void IngresarUsuario (String usuario)
    {
        NodoListaCircular_Usuarios nuevoNodo = new NodoListaCircular_Usuarios();
        nuevoNodo.usuario = usuario;
        if (primero == null)
        {
         primero = nuevoNodo;//primer nodo de la lista, primero va a apuntar al nuevoNodo
         ultimo = primero;// ultimo va a ser al nuevoNodo ingresado
         primero.siguiente = ultimo; //se apunta a si mismo
        }else//si la lista ya no es null
        {
        ultimo.siguiente = nuevoNodo;
        nuevoNodo.siguiente = primero;
        ultimo = nuevoNodo;
        }
    }
   public void graficarLista ()
    {
       NodoListaCircular_Usuarios actual = new NodoListaCircular_Usuarios();
        actual = primero;
        do{
      System.out.println("-> " + actual.usuario);
      actual = actual.siguiente;
        }
          while(actual != primero);
}
   
   
       public int MostrarLista()            {
             FileWriter Fichero = null;
            PrintWriter Lapicero = null;
            int conta = 0;
            try{
                Fichero = new FileWriter("C:\\Users\\jp_gm\\Desktop\\practica1_201222615\\ListaC.txt");
                Lapicero = new PrintWriter(Fichero);
               NodoListaCircular_Usuarios actual = new NodoListaCircular_Usuarios();
               NodoListaCircular_Usuarios circular = new NodoListaCircular_Usuarios();
    NodoListaSimple_FichasJugador simple = new NodoListaSimple_FichasJugador();
     simple = union;
               actual = primero;
            
                Lapicero.println("digraph{");
                Lapicero.println("rankdir = LR;");
                Lapicero.println("node [shape=record,color=lightblue];     subgraph clusterListaCircular1 {");
                        
                Lapicero.println("label = \"LISTA CIRCULAR DE USUARIOS \";");
                Lapicero.println("color=lightgrey;");     
                    
                
                
                do{
        Lapicero.println(actual.usuario); 
         Lapicero.println("->"+ actual.siguiente.usuario); 
        Lapicero.println("->"+ actual.siguiente.union); 
        Lapicero.println("->"+ simple.siguiente.ficha); 
        
        
        actual = actual.siguiente;
    
        }
          while(actual != primero);
                    
                    
    
        
              Lapicero.println(";"); 
                //Pie del Archivo
                Lapicero.println("}");
                Lapicero.println("}");  
            }catch(Exception e){
                return 2;  //Significa que hubo un error al escribir el archivo
            }finally{
                try{
                    //Cerrando el Archivo
                    if(null!= Fichero){
                    Fichero.close();
                    }
                    Runtime Ejecutor = Runtime.getRuntime();
                    Ejecutor.exec("C:\\Users\\jp_gm\\Downloads\\graphviz-2.38\\release\\bin\\dot.exe -Tjpg C:\\Users\\jp_gm\\Desktop\\practica1_201222615\\ListaC.txt -o C:\\Users\\jp_gm\\Desktop\\practica1_201222615\\ListaC.jpg"); 
                }catch(Exception e){
                   return 3; //Significa que hubo un error al Cerrar el archivo
                }
            }
            return 1;   //Significa que la lista si tiene elementos
    }
}

