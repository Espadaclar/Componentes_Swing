
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Document;


/**
 * DENTRO DE UN CUADRO DE TEXTO.
 *Para saber cuando el usuario escribe,  borra text, o saber de los cambios que 
 * puedan surgir en el texto. (negrita, cursiva, tamaño, etc)
 * 
 * Despues de crear el cuadro de texto en una lámina.
 * 
 * 1º creamos la clase receptora del evento, la cual implementa una interface- 'EscuchaTexto implements DocumentListener'
 *    --codifico su mt para que cuando escriba texto en el cuadroTxt, indique por pantalla, 'Escrito texto
 *    --y cuando borro texto en el cuadroTxt, indique por pantalla, 'Borrado texto
 * 
 * 2º ponemos al cuadro de texto a la escucha; Pero al cuadro de texto nos se le puede poner a la escucha, necesitamos
 * el mt 'getDocument()' aplicado a la cl 'JTextField' lo que hace es devolvernos el documento donde está el texto
 *    -- un objeto de tipo 'Documento' y a este objeto si se pone a la escucha, le aplicamos el mt ' addDocumentLitsener()´,
 */
public class DetectaCambiosEnCudroDeTexto extends JFrame {

    //DetectaCambiosEnCudroDeTexto()

    public static void main(String[] args) {
        DetectaCambiosEnCudroDeTexto marco = new DetectaCambiosEnCudroDeTexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public DetectaCambiosEnCudroDeTexto() {
       
        LaminaPrueva lamina = new LaminaPrueva();
        add(lamina);

        setBounds(100, 100, 900, 600);
        setVisible(true);
        setTitle("MarcoTexto");

        Toolkit icono = Toolkit.getDefaultToolkit();
        Image image = icono.getImage("../icono2.gif");
        setIconImage(image);
    }

    ////////////////////////////////////////////////////////////////////////////CLASE INTERNA PARA CREAR LAMINA DE DIBUJO
    private class LaminaPrueva extends JPanel {

        public LaminaPrueva() {
            JTextField campo1 = new JTextField();//--- almacena el texto que se escriva en el cuadro de texto.
            campo1 = new JTextField(25);// -----------------------CUADRO DE TEXTO
            //2º ponemos al cuadro de texto a la escucha; el mt 'getDocument()' aplicado a la cl 'JTextField' lo que hace es devolvernos
            //   -- un objeto de tipo 'Documento' y a este objeto le aplicamos el mt ' addDocumentLitsener()´,
            Document midoc = campo1.getDocument();// --almacenamos en 'midoc' el objeto de tipo 'Document'
            // y ahora ponemos a ese documento a la escucha
            EscuchaTexto el_evento = new EscuchaTexto();
            midoc.addDocumentListener(el_evento );
            
            add(campo1);
        }

        // ************ CLASE INTERNA Y OYENTE
        private class EscuchaTexto implements DocumentListener {

            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Escrito texto en CuadroDeTexto.");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                 System.out.println("Borrado texto en CuadroDeTexto.");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               
            }

            

            
        }
    }
}




