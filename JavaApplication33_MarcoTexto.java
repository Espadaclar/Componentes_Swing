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
 //almacena el texto que se escriva en el cuadro de texto.
    private JTextField campo1;

    public static void main(String[] args) {
        JavaApplication33_MarcoTexto marco = new JavaApplication33_MarcoTexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JavaApplication33_MarcoTexto() {
        LaminaTexto2 lamina = new LaminaTexto2();
        add(lamina);

        setBounds(100, 100, 900, 600);
        setVisible(true);
        setTitle("MarcoTexto");

        Toolkit icono = Toolkit.getDefaultToolkit();
        Image image = icono.getImage("../icono2.gif");
        setIconImage(image);
    }

    //CLASE INTERNA PARA CREAR LAMINA DE DIBUJO
    private class LaminaTexto2 extends JPanel {

        public LaminaTexto2() {
            //asignamos el tipo de Layout a la lamina.
            setLayout(new BorderLayout());
            LaminaTexto lamina = new LaminaTexto();
            add(lamina, BorderLayout.NORTH);

        }

        private class LaminaTexto extends JPanel {

            public LaminaTexto() {
                //asinamos el tipo de Layout a la lamina.
                setLayout(new GridLayout(1, 3, 93, 9));

                JLabel email = new JLabel("Direccion de correo");
                add(email);
                campo1 = new JTextField(20);
                add(campo1);
                JButton boton = new JButton("Validar dirección");
                add(boton);
                OyenteTexto oyente = new OyenteTexto();
                boton.addActionListener(oyente);

            }

            //CLASE INTERNA PARA CREAR UN  OBJTO OYENTE
            private class OyenteTexto implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    comprobarDireccionEmail();
                }

                public void comprobarDireccionEmail() {
                    String aux = campo1.getText();
                    int cont = 0;
                    char[] valor = aux.toCharArray();
                    for (int i = 0; i < valor.length; i++) {
                        if (valor[i] == '@') {
                            cont++;
                        }
                    }
                    if (cont == 0 || cont > 1) {
                        System.out.println("Dirección incorrecta, fallan las @");
                    } else {
                        System.out.println("Direccion correcta");
                    }
                }
            }
        }

    }
}


