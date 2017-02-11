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
public class Archivo {
   private double dimension;
   private double valorX;
   private double valorY;
   private String palabra;

    public Archivo() {
        
        
        
        
        
    }
/////////////////////////////////////////////Getters y Setters/////////////////////////////////////////////////////
    public double getDimension() {
        return dimension;
    }

    public void setDimension(double dimension) {
        this.dimension = dimension;
    }

    public double getValorX() {
        return valorX;
    }

    public void setValorX(double valorX) {
        this.valorX = valorX;
    }

    public double getValorY() {
        return valorY;
    }

    public void setValorY(double valorY) {
        this.valorY = valorY;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
/////////////////////////////////////////////Getters y Setters/////////////////////////////////////////////////////
    
/////////////////////////////////////////////To String/////////////////////////////////////////////////////
    @Override
    public String toString() {
        return "Archivo{" + "dimension=" + dimension + ", valorX=" + valorX + ", valorY=" + valorY + ", palabra=" + palabra + '}';
    }
/////////////////////////////////////////////To String/////////////////////////////////////////////////////  
}
