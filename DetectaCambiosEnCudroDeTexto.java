
import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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

    
    /**
     * DetectaCambiosEnCudroDeTexto
     */
    public static void main(String[] args) {
        DetectaCambiosEnCudroDeTexto marco = new DetectaCambiosEnCudroDeTexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public DetectaCambiosEnCudroDeTexto() {
        LaminaPrincipal lam = new LaminaPrincipal();
        add(lam);

        setBounds(150, 100, 1000, 600);
        setVisible(true);
        setTitle("Usuario");

        Toolkit e = Toolkit.getDefaultToolkit();
        Image icono = e.getImage("../icono2.gif");
        setIconImage(icono);

    }

    private class LaminaPrincipal extends JPanel {

        private JPasswordField c_pasword;// -------definido aquí para que tenga  ambito de clase.
        private int cuentaCaracteres;

        private char[] numCarac;// -------definido aquí para que tenga  ambito de clase.

        public LaminaPrincipal() {

            setLayout(new BorderLayout());

            JPanel lamina_superior = new JPanel();//------------------------LAMINA 1
            lamina_superior.setLayout(new GridLayout(2, 2));
            JLabel dato = new JLabel("Usuario.", JLabel.CENTER);
            lamina_superior.add(dato);

            JTextField c_usuario = new JTextField(20);//--------------CUADRO_T1
            lamina_superior.add(c_usuario);
            JLabel dato2 = new JLabel("Pasword.", JLabel.CENTER);
            lamina_superior.add(dato2);

            c_pasword = new JPasswordField(15);//--------------CUADRO_T2
            lamina_superior.add(c_pasword);

            JPanel lamina2 = new JPanel();//-------------------------LAMINA 2
            JButton boton = new JButton(" ENVIAR ");
            lamina2.add(boton);

            //add lamina1 a laminaPricipal
            add(lamina_superior, BorderLayout.NORTH);
            add(lamina2, BorderLayout.SOUTH);

            // --------- INSTANCIAMOS AL OYENTE
            Comprueba_pass oyente = new Comprueba_pass();
            Document doc = c_pasword.getDocument();
            doc.addDocumentListener(oyente);

        }

        //clase interna
        private class Comprueba_pass implements DocumentListener {

            @Override
            public void insertUpdate(DocumentEvent e) {
                //cuentaCaracteres++;
                comprobarPassword();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                comprobarPassword();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        }
        // ----------- para invocar desde insertUpdate(DocumentEvent e)
        public void comprobarPassword() {
            numCarac = c_pasword.getPassword();
            cuentaCaracteres = numCarac.length;
            if (cuentaCaracteres < 8 || cuentaCaracteres > 12) {
                c_pasword.setBackground(Color.red);
            } else {
                c_pasword.setBackground(Color.white);
            }
        }
    }

}





