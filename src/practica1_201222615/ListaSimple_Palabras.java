/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201222615;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

/**
 *
 * @author jp_gm
 */
public class ListaSimple_Palabras {
    NodoListaSimple_Palabras primero;
    NodoListaSimple_Palabras ultimo;
    static int elementos;
    public ListaSimple_Palabras ()
    {
        elementos = 0;
        primero = null;//esto nos dice que cuando no exista nada en la lista el puntero de tipo nodoListaSimple no a apuntar a nada.
        ultimo = null;//esto nos dice que cuando no exista nada en la lista el puntero de tipo nodoListaSimple no a apuntar a nada.
        
    }
    
    public void ingresarNodo(String palabra)
    {
    NodoListaSimple_Palabras nodoNuevo = new NodoListaSimple_Palabras();
    nodoNuevo.dato = palabra;
    if (primero == null)//el nodoNuevo que estamos ingresando va a ser nuestra cabezera ya que no hay ningun otro nodo existente
    {
        primero = nodoNuevo;// el nodo que  acabamos de ingresar sea la cabezera de nuestra lista
        primero.siguiente = null;// que el nodo ingresado o nodo cabezera apunte a siguiente y por ende apunte a nada.
        ultimo = primero;//el nodo sea el primero y sea el ultimo ya que es el unico nodo existente
    }else // si ya hay un nodo existente
    {
        ultimo.siguiente = nodoNuevo;// el nodo existente apunte al nodoNuevo
        nodoNuevo.siguiente = null;// el nodo nuevo apunte a siguiente y por ende a nada
        ultimo = nodoNuevo;//este nodoNuevo va a ser el ultimo de la lista
    }
    }
    
  
    
    public void graficarLista ()
    {
        NodoListaSimple_Palabras actual = new NodoListaSimple_Palabras();
        actual = primero;
        while(actual != null)
        {
        System.out.println(actual.dato);
        actual = actual.siguiente;
        }
    }
    
    
    
    public int MostrarLista(){
             FileWriter Fichero = null;
            PrintWriter Lapicero = null;
            try{
                Fichero = new FileWriter("C:\\Users\\jp_gm\\Desktop\\practica1_201222615\\ListaS.txt");
                Lapicero = new PrintWriter(Fichero);
               NodoListaSimple_Palabras actual = new NodoListaSimple_Palabras();
               actual = primero;
              int conta = 0;
                int i=0;
                //Escribiendo en el fichero
                //Inicio del archivo
                Lapicero.println("digraph{");
                Lapicero.println("rankdir = LR;");
                Lapicero.println("node [shape=record,color=lightblue];     subgraph clusterListaSimple1 {");
                        
                Lapicero.println("label = \"LISTA SIMPLE ENLAZADA DE PALABRAS \";");
                Lapicero.println("color=lightgrey;");
        while(actual != null)
        {
        if(conta == 0)
        {
        Lapicero.println("\"id:"+ actual.dato + "\"");
        actual= actual.siguiente;
        conta++;
        }
        else
        {
        Lapicero.println("->" + "\"id:"+ actual.dato + "\"");
        actual= actual.siguiente;
        conta++;
        }
        }
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
                    //Ejecutando el archivo .dot para crear la imagen
                                             
                    Runtime Ejecutor = Runtime.getRuntime();
                    Ejecutor.exec("C:\\Users\\jp_gm\\Downloads\\graphviz-2.38\\release\\bin\\dot.exe -Tjpg C:\\Users\\jp_gm\\Desktop\\practica1_201222615\\ListaS.txt -o C:\\Users\\jp_gm\\Desktop\\practica1_201222615\\ListaS.jpg"); 
                }catch(Exception e){
                   return 3; //Significa que hubo un error al Cerrar el archivo
                }
            }
            return 1;   //Significa que la lista si tiene elementos
    }

}







