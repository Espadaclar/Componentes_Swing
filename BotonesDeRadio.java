import java.awt.*;
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

    public class Lamina_Botones_Radio extends JPanel {

        public Lamina_Botones_Radio() {
            //INSTANCIAS PARA DOS GRUPOS DE BOTONES
            ButtonGroup migrupo1 = new ButtonGroup();
            ButtonGroup migrupo2 = new ButtonGroup();
            
            //EL 2º PARAMETRO INDICA SI EL BOTÓN ESTARA ACTIVADO AL CREARLO.
            JRadioButton b1 = new JRadioButton("B1",false);
            JRadioButton b2 = new JRadioButton("B2",true);
            JRadioButton b3 = new JRadioButton("B3",false);
            
            JRadioButton b4 = new JRadioButton("Masculino",true);
            JRadioButton b5 = new JRadioButton("Femenino",false);
            
            //AÑADE LOS BOTONES AL GRUPO CORRESPONDIENTE.
            migrupo1.add(b1);
            migrupo1.add(b2);
            migrupo1.add(b3);
            //---DATO.    LOS GRUPOS NO SE AÑADEN A LA LAMINA, SE AÑADEN LOS BOTONES.
            add(b1);
            add(b2);
            add(b3);
            
            migrupo2.add(b4);
            migrupo2.add(b5);
            add(b4);
            add(b5);
        }
    }
}