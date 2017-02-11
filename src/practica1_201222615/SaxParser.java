/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201222615;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author jp_gm
 */
public class SaxParser {
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
     SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
     SAXParser saxParser = saxParserFactory.newSAXParser(); 
     File leer = new File("version.xml");
     Handler handler = new Handler();
     saxParser.parse(leer, handler);
     
     ArrayList<Archivo> archivos = handler.getArchivos();
     for(Archivo ar : archivos)
     {
         System.out.println(ar);
     }
    }
    
}
