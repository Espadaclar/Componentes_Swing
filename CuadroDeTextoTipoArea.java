import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.Document;
/**
 * CREA UNA VENTANA, UNA INTERFACE GRAFICA DE USUARIO.
 */
public class CuadroDeTextoTipoArea extends JFrame
{

    public static void main(String[] args) {
        CuadroDeTextoTipoArea marco = new CuadroDeTextoTipoArea();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Constructor for objects of class CradroDeTextoTipoArea
     */
    public CuadroDeTextoTipoArea()
    {
        LaminaPrincipal lam = new LaminaPrincipal();
        add(lam);

        setBounds(150, 100, 1000, 600);
        setVisible(true);
        setTitle("  MARCOS && AREAS_DE_TEXTO  ");

        Toolkit e = Toolkit.getDefaultToolkit();// ---------    elimina el icono que java pone por defecto y pone miIcono.
        Image icono = e.getImage("../icono2.gif");
        setIconImage(icono);
    }

    /**
     * CREA UNA LAMINA DONDE PODER DIBUJAR COMPONENTES,
     */
    private class LaminaPrincipal extends JPanel {
        // -- ATRIBUTOS PARA CUADROS DE TEXTO CON AMBITO DE CLASE.
        private JTextArea cua_norte_1 = new JTextArea(9, 18);
        private JTextArea cua_norte_2 = new JTextArea(9, 18);
        // -- ALMACENA EL CONTENIDO QUE SE ESCRIBA EN UN DOCUMENT0.
        private String contenido_Documento;
        
        public LaminaPrincipal() {
            
            setLayout(new BorderLayout());//------------------------LAMINA ORIGEN.

            JPanel lamina_Norte = new JPanel();
            lamina_Norte.setLayout(new GridLayout(1, 4));//---------LAMINA CON 4 COLUMNAS PEGADA A LAMINA ORIGEN.
            
            JPanel lam_norte_1 = new JPanel();//--------------------1º LAMINA PEGADA A LA LAMINA CON 4 COLUMNAS.
            JLabel eti_norte_1 = new JLabel("Documento.");
            lam_norte_1.add(eti_norte_1);
            lamina_Norte.add(lam_norte_1);
                        
            JPanel lam_norte_2 = new JPanel();//--------------------2º LAMINA PEGADA A LA LAMINA CON 4 COLUMNAS.
            
            cua_norte_1.setLineWrap(true);//------------------------SALTO DE LINEA PARA QUE AL LLEGAR AL BORDE PASE AL SIGUIENTE RENGLON
            JScrollPane barra = new JScrollPane(lam_norte_2);//---- Y LA PEGAMOS A UNA LAMINA CON BARRA DE SCROLL
            lam_norte_2.add(cua_norte_1);
            lamina_Norte.add(barra);
            
            JPanel lam_norte_3 = new JPanel();//--------------------3º LAMINA PEGADA A LA LAMINA CON 4 COLUMNAS.
            JLabel eti_norte_2 = new JLabel("Copia_de documento.");
            lam_norte_3.add(eti_norte_2);
            lamina_Norte.add(lam_norte_3);
            
            JPanel lam_norte_4 = new JPanel();//--------------------4º LAMINA PEGADA A LA LAMINA CON 4 COLUMNAS.
            
            //cua_norte_2.setLineWrap(true);//------------------------SALTO DE LINEA PARA QUE AL LLEGAR AL BORDE PASE AL SIGUIENTE RENGLON
            JScrollPane barra2 = new JScrollPane(lam_norte_4);//--- Y LA PEGAMOS A UNA LAMINA CON BARRA DE SCROLL
            lam_norte_4.add(cua_norte_2);
            lamina_Norte.add(barra2);

            JButton boton = new JButton(" COPIAR && PEGAR,  ");
            Oyente oyente = new Oyente(); // ---------------------- instamcia de la clase Oyente.
            boton.addActionListener(oyente);// -------------------- pone a la escucha al objeto Oyente.
            // -- --------------------------------------------------SE ANADE TODOS LOS COMPONENTES A LAMINA ORIGEN.
            add(lamina_Norte, BorderLayout.NORTH);
            add(boton, BorderLayout.SOUTH);            
        }
        // CLASE INTERNA Y CLASE OYENTE.
        private class Oyente implements ActionListener{
        
            public void actionPerformed(ActionEvent e){
                contenido_Documento = cua_norte_1.getText();// -ALMACENA EL CONTENIDO DEL DOCUMENTO.
                cua_norte_2.setText(contenido_Documento);// ----COPIA EL CONTENIDO DEL DOCUMENTO.
            }
        }
    }
}
















