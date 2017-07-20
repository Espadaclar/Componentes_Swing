import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *franciscoJavier
 */
public class BotonesDeRadio extends JFrame{

    public static void main(String[] args) {
        BotonesDeRadio marco = new BotonesDeRadio();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public BotonesDeRadio() {
    
        Lamina_Botones_Radio lamina = new Lamina_Botones_Radio();
        add(lamina);

        setBounds(150, 70, 900, 500);
        setVisible(true);
        setTitle("Botones de radio");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);
    }

    public final class Lamina_Botones_Radio extends JPanel {

        private JRadioButton boton;
        private ButtonGroup grupoBotones;
        private JLabel texto;
        private Font asigna;
        private JPanel laminaBotones;

        public Lamina_Botones_Radio() {

            setLayout(new BorderLayout());

            texto = new JLabel("MOKU YOKU SHIN TAY, SHIN YI MOKU TO GAN SHU HO, NAYGUEY KU KETSHU");
            asigna = new Font("Serif", Font.PLAIN, 13);
            texto.setFont(asigna);

            laminaBotones = new JPanel();
            add(texto, BorderLayout.CENTER);// --------------------pega la el texto a la lamina.
            add(laminaBotones, BorderLayout.SOUTH);// -------------pega la laminaBotones a la lamina.

            colocarBotones("little size", false, Font.PLAIN, 10);
            colocarBotones("mediun size", true, Font.PLAIN, 14);
            colocarBotones("big size", false, Font.PLAIN, 20);
            colocarBotones("Negrita", true, Font.BOLD, 13);
            colocarBotones("Cursiva", false, Font.ITALIC, 13);
        }
        // ------------ CADA VEZ QUE SE INVOCA SE CREA UN NUEVO BOTON QUE INCORPORA LA INTERFACE ActionListener
        // ------------ Los dos ultimos parametros son para codificar el mt de la interface.
        public void colocarBotones(String name, boolean activado, int style, int size) {
            grupoBotones = new ButtonGroup();// -----------grupo al que pertenece el boton.
            boton = new JRadioButton(name, activado);// ---caracteristicas del boton, pasadas por parametro.
            grupoBotones.add(boton);// --------------------anade el boton al grupoDeBotones.
            laminaBotones.add(boton);// -------------------anade el boton a la lamina de botones.

            ActionListener evento = new ActionListener() {// -instamcia de un objeto interface ActionListener

                @Override
                public void actionPerformed(ActionEvent e) {// cada vez que presiona el boton se ejecuta el codigo del mt.
                    texto.setFont(new Font(name, style, size));
                }
            };
            boton.addActionListener(evento);// -------------- interface a la escucha de cuado es presionado el boton.
        }
    }
}
