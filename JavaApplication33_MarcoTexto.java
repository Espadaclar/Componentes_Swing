import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class JavaApplication33_MarcoTexto extends JFrame {

    private JTextField campo1;//--- almacena el texto que se escriva en el cuadro de texto.
    private int cont;// ----------- cuenta las @ en la direccion  email.
    private boolean validaDentroFrame;// ------ facilita comentario sobre la validez de la direcció email.
    private String textoParaValidar;

    JLabel dato2 = new JLabel();

    public static void main(String[] args) {
        JavaApplication33_MarcoTexto marco = new JavaApplication33_MarcoTexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JavaApplication33_MarcoTexto() {
        textoParaValidar = "";

        LaminaTexto lamina = new LaminaTexto();
        add(lamina);

        setBounds(100, 100, 900, 600);
        setVisible(true);
        setTitle("MarcoTexto");

        Toolkit icono = Toolkit.getDefaultToolkit();
        Image image = icono.getImage("../icono2.gif");
        setIconImage(image);
    }

    ////////////////////////////////////////////////////////////////////////////CLASE INTERNA PARA CREAR LAMINA DE DIBUJO
    private class LaminaTexto extends JPanel {

        public LaminaTexto() {
            //asignamos el tipo de Layout a la lamina.
            setLayout(new BorderLayout());

            //***************************************************************************
            JPanel laminaPegada = new JPanel();// ----------------1º LAMINA PARA PEGAR, ZONA NORTE, DE LaminaTexto()
            JLabel dato = new JLabel("Direccion email.-");// ------ETIQUETA
            laminaPegada.add(dato);
            campo1 = new JTextField(25);// -----------------------CUADRO DE TEXTO
            laminaPegada.add(campo1);
            JButton boton = new JButton("Validar_Direccion."); // ------------BOTON
            laminaPegada.add(boton);

            Oyente oyente = new Oyente();// -----------------------INSTANCIA OBJETO OYENTE
            boton.addActionListener(oyente);// ------------------- OB.OYENT A LA ESCUCHA
            //***************************************************************************
            
            JPanel laminaPegada2 = new JPanel();// ----------------2º LAMINA PARA PEGAR, ZONA SUR, DE LaminaTexto()          
            laminaPegada2.add(dato2);//cuadro de texto declarado como atributo.

            add(laminaPegada, BorderLayout.NORTH);// ------------- PEGAMOS laminaPegada SOBRE LaminaTexto()
            add(laminaPegada2, BorderLayout.EAST);// ------------- PEGAMOS laminaPegada2 SOBRE LaminaTexto()
        }

        // ************ CLASE INTERNA Y OYENTE
        private class Oyente implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                comprobarDireccionEmail();
            }

            public void comprobarDireccionEmail() {
                String aux = campo1.getText();
                cont = 0;
                char[] valor = aux.toCharArray();
                for (int i = 0; i < valor.length; i++) {
                    if (valor[i] == '@') {
                        cont++;
                    }
                }
                if (cont == 0 || cont > 1) {
                    dato2.setText("Dirección incorrecta, " + cont + " @.");

                } else {
                    dato2.setText("Direccion correcta.");
                }

            }
        }
    }
}

