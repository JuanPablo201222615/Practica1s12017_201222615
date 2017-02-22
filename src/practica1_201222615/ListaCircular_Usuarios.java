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
   
     primero = null;
     ultimo = null;
    }
    
    public void IngresarUsuario (String usuario)
    {
        NodoListaCircular_Usuarios nuevoNodo = new NodoListaCircular_Usuarios();
        nuevoNodo.siguiente=null;
        nuevoNodo.union=null;
        nuevoNodo.usuario=usuario;
        
        
        
        ListaSimple_FichasJugador listFichas = new ListaSimple_FichasJugador();
        listFichas.primero=null;
        listFichas.ultimo=null;
   
        
        ListaCircular_Usuarios circular = new ListaCircular_Usuarios();
        circular.primero=null;
        circular.ultimo=null;
        circular.union=null;
        
        
       
    
     
     
        
        for (int i = 1; i < 8; i++)
        {
            NodoListaSimple_FichasJugador nodoFichas=new  NodoListaSimple_FichasJugador();
            nodoFichas.ficha=i;
            nodoFichas.siguiente=null;
          if(listFichas.primero==null)
          {
              listFichas.primero=nodoFichas;
              listFichas.ultimo=nodoFichas;
          }else
          {
              listFichas.ultimo.siguiente=nodoFichas;
              listFichas.ultimo=nodoFichas;
          }
        }
        
        nuevoNodo.union=listFichas;
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
   
   
       public int MostrarLista()   
      {
          String nivel;
          nivel = " ";
          
             FileWriter Fichero = null;
            PrintWriter Lapicero = null;
            int conta = 0;
            try{
                Fichero = new FileWriter("C:\\Users\\jp_gm\\Desktop\\practica1_201222615\\ListaC.txt");
                Lapicero = new PrintWriter(Fichero);
               NodoListaCircular_Usuarios actual = new NodoListaCircular_Usuarios();
               ListaSimple_FichasJugador simple = new ListaSimple_FichasJugador();
               actual = primero;
           
            
                Lapicero.println("digraph{");
                Lapicero.println("rankdir = LR;");
                Lapicero.println("node [shape=record,color=lightblue];     subgraph clusterListaCircular1 {");
                        
                Lapicero.println("label = \"LISTA CIRCULAR DE USUARIOS \";");
                Lapicero.println("color=lightgrey;");     
                    
                    
                
                do{
        Lapicero.println("node"+actual.usuario+"[label = \" " + actual.usuario + "\"];\n"); 
        nivel = nivel +" node"+  actual.usuario;
        if(actual.union != null)
        {
            
           NodoListaSimple_FichasJugador aux = actual.union.primero;
             while(aux!=null)
            {       
                Lapicero.println("node"+actual.usuario+ aux.ficha + "[label = \" " + aux.ficha + "\"];\n");             
                if(aux.siguiente!=null)
                {
                    Lapicero.println("node"+actual.usuario+aux.siguiente.ficha +"[label = \" " + aux.siguiente.ficha + "\"];\n");
                    Lapicero.println("node"+actual.usuario + aux.ficha+"->"+"node"+actual.usuario+aux.siguiente.ficha+";\n");
                }
                aux=aux.siguiente;
            }    
            Lapicero.println("node"+actual.usuario+ "->"+ "node"+ actual.usuario+actual.union.primero.ficha); 
        }
        Lapicero.println("node"+actual.siguiente.usuario+"[label = \" " + actual.siguiente.usuario + "\"];\n");
         Lapicero.println("node"+actual.usuario+ "->"+ "node" +actual.siguiente.usuario); 
        
        
        actual = actual.siguiente;
        }
           
          while(actual != primero);
          Lapicero.println("{rank = same" + nivel + "} \n");         
                    
    
              
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

