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
 import java.util.Scanner; //Importación de la clase Scanner desde la biblioteca Java

public class EntradaDeTeclado {  // Definimos la clase EntradaDeTeclado aprenderaprogramar.com

    private String entradaTeclado; //Variable de instancia (campo) del método

 

    //Constructor

    public EntradaDeTeclado ()  {

        entradaTeclado=""; } //Cierre del constructor

 

    public void pedirEntrada ()  {  //Método de la clase          

        Scanner entradaEscaner = new Scanner (System.in);

        entradaTeclado = entradaEscaner.nextLine ();

    } //Cierre del método pedirEntrada

 

    public String getEntrada () {

        return entradaTeclado;

 } //Cierre del método getEntrada

} //Cierre de la clase
