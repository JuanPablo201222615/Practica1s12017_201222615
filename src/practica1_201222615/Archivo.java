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
   private String dimension;
   private String valorX;
   private String valorY;
   private String palabra;

    public Archivo() {
        
        
        
        
        
    }
/////////////////////////////////////////////Getters y Setters/////////////////////////////////////////////////////
    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getValorX() {
        return valorX;
    }

    public void setValorX(String valorX) {
        this.valorX = valorX;
    }

    public String getValorY() {
        return valorY;
    }

    public void setValorY(String valorY) {
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
