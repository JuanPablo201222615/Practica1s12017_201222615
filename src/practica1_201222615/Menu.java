package practica1_201222615;
import java.util.List;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
/**
 *
 * @author jp_gm
 */
public class Menu extends javax.swing.JFrame {
    
    ListaSimple_Palabras meterDatos = new ListaSimple_Palabras();

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnLeerArchivo = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        btnLeerArchivo.setText("LEER ARCHIVO");
        btnLeerArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerArchivoActionPerformed(evt);
            }
        });

        btnJugar.setText("JUGAR");
        btnJugar.setEnabled(false);
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnLeerArchivo)
                .addGap(18, 18, 18)
                .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeerArchivo)
                    .addComponent(btnJugar))
                .addGap(40, 40, 40))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("MENÚ PRINCIPAL ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLeerArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerArchivoActionPerformed
    try {
     	JFileChooser chooser = new JFileChooser();
    	chooser.showOpenDialog(new JFrame());
    	File fXmlFile=chooser.getSelectedFile();

    
    
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);
    doc.getDocumentElement().normalize();

    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

    NodeList nList = doc.getElementsByTagName("scrabble");

    System.out.println("----------------------------");

    for (int temp = 0; temp < nList.getLength(); temp++) {

        Node nNode = nList.item(temp);

        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            org.w3c.dom.Element eElement = (org.w3c.dom.Element) nNode;

            System.out.println("Dobles: Valor X y Y : " + eElement.getElementsByTagName("dobles").item(0).getTextContent());
            System.out.println("Triles: Valor X y Y : " + eElement.getElementsByTagName("triples").item(0).getTextContent());
            System.out.println("Diccionario : " + eElement.getElementsByTagName("diccionario").item(0).getTextContent());
            
    
         Node etiquetaHija = (Node)(XPathFactory.newInstance().newXPath().evaluate("/diccionario/palabra", doc, XPathConstants.NODE));  
if (etiquetaHija!=null){  
    meterDatos.ingresarNodo(etiquetaHija.getTextContent());
   System.out.println(etiquetaHija.getTextContent());  
}  
           
            meterDatos.ingresarNodo(eElement.getElementsByTagName("palabra").item(0).getTextContent());
            meterDatos.ingresarNodo(eElement.getElementsByTagName("palabra").item(1).getTextContent());
            meterDatos.ingresarNodo(eElement.getElementsByTagName("palabra").item(2).getTextContent());
            meterDatos.ingresarNodo(eElement.getElementsByTagName("palabra").item(3).getTextContent());
            meterDatos.ingresarNodo(eElement.getElementsByTagName("palabra").item(4).getTextContent());
            meterDatos.ingresarNodo(eElement.getElementsByTagName("palabra").item(5).getTextContent());
            meterDatos.ingresarNodo(eElement.getElementsByTagName("palabra").item(6).getTextContent());
            meterDatos.ingresarNodo(eElement.getElementsByTagName("palabra").item(7).getTextContent());
            meterDatos.ingresarNodo(eElement.getElementsByTagName("palabra").item(8).getTextContent());
            meterDatos.ingresarNodo(eElement.getElementsByTagName("palabra").item(9).getTextContent());
            meterDatos.ingresarNodo(eElement.getElementsByTagName("palabra").item(10).getTextContent());

            
          

            
            meterDatos.MostrarLista();

        }
    }
    
   
    } catch (Exception e) {
    e.printStackTrace();
    }
    
    btnJugar.setEnabled(true);

    }//GEN-LAST:event_btnLeerArchivoActionPerformed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        Menu menu = new Menu();
        menu.setVisible(false);
        Usuarios frm = new Usuarios();
       
       frm.setVisible(true);
    }//GEN-LAST:event_btnJugarActionPerformed


 /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnLeerArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
