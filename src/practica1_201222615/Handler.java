/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201222615;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author jp_gm
 */
public class Handler extends DefaultHandler{
private ArrayList<Archivo> archivos = new ArrayList();
private Archivo archivo;
private StringBuilder buffer = new StringBuilder();

    public ArrayList<Archivo> getArchivos() {
        return archivos;
    }



    @Override
    public void characters(char[] ch, int start , int length) throws SAXException {
   buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName ) throws SAXException {
     switch(qName)
   {
       case "dimension":
          archivo.setDimension(buffer.toString());
           break;
       case "x":
           archivo.setValorX(buffer.toString());
           break;
       case "y":
           archivo.setValorY(buffer.toString());
           break;
       case "palabra":
           archivo.setPalabra(buffer.toString());
           break;
           
       
   }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atrbts) throws SAXException {
   switch(qName)
   {
       case "dimension":
           buffer.delete(0,buffer.length());
           break;
       case "x":
           buffer.delete(0,buffer.length());
           break;
       case "y":
           buffer.delete(0,buffer.length());
           break;
       case "palabra":
            buffer.delete(0,buffer.length());
           break;
           
       
   }
    }
    
}
