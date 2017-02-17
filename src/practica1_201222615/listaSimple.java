/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201222615;

/**
 *
 * @author jp_gm
 */
public class listaSimple {
    nodoListaSimple primero;
    nodoListaSimple ultimo;
    public listaSimple ()
    {
        primero = null;//esto nos dice que cuando no exista nada en la lista el puntero de tipo nodoListaSimple no a apuntar a nada.
        ultimo = null;//esto nos dice que cuando no exista nada en la lista el puntero de tipo nodoListaSimple no a apuntar a nada.
        
    }
    
    public void ingresarNodo(String palabra)
    {
    nodoListaSimple nodoNuevo = new nodoListaSimple();
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
        nodoListaSimple actual = new nodoListaSimple();
        actual = primero;
        while(actual != null)
        {
        System.out.println(actual.dato);
        actual = actual.siguiente;
        }
    }
    
}
