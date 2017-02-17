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
public class ListaCircular_Usuarios 
{
    NodoListaCircular_Usuarios primero;
    NodoListaCircular_Usuarios ultimo;
    
    public ListaCircular_Usuarios()
    {
     primero = null;
     ultimo = null;
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
      System.out.println(" " + actual.usuario);
      actual = actual.siguiente;
        }
          while(actual != primero);
}
}

