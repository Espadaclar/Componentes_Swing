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

    public class Lamina_Botones_Radio extends JPanel {

        private JLabel texto; 
        private Font asigna;
        
        public Lamina_Botones_Radio() {
            
            setLayout(new BorderLayout());
            
            JPanel laminaBotones = new JPanel();
            add(laminaBotones, BorderLayout.SOUTH);
            JPanel laminaTexto = new JPanel();
            add(laminaTexto, BorderLayout.NORTH);
           
            
            texto = new JLabel("MOKU YOKU SHIN TAY, SHIN YI MOKU TO GAN SHU HO, NAYGUEY KU KETSHU");
             asigna = new Font("Serif", Font.PLAIN, 12);
            texto.setFont(asigna);
            
            laminaTexto.add(texto);
            add(laminaTexto, BorderLayout.NORTH);
            //INSTANCIAS PARA DOS GRUPOS DE BOTONES
            ButtonGroup migrupo1 = new ButtonGroup();
            ButtonGroup migrupo2 = new ButtonGroup();
            
            //EL 2º PARAMETRO INDICA SI EL BOTÓN ESTARA ACTIVADO AL CREARLO.
            JRadioButton b1 = new JRadioButton("little size",false);
            JRadioButton b2 = new JRadioButton("mediun size",true);
            JRadioButton b3 = new JRadioButton("big size",false);
            
            JRadioButton b4 = new JRadioButton("Negrita",true);
            JRadioButton b5 = new JRadioButton("Cursiva",false);
            
            //AÑADE LOS BOTONES AL GRUPO CORRESPONDIENTE.
            migrupo1.add(b1);
            migrupo1.add(b2);
            migrupo1.add(b3);
            //---DATO.    LOS GRUPOS NO SE AÑADEN A LA LAMINA, SE AÑADEN LOS BOTONES.
            laminaBotones.add(b1);
            laminaBotones.add(b2);
            laminaBotones.add(b3);
            
            migrupo2.add(b4);
            migrupo2.add(b5);
            laminaBotones.add(b4);
            laminaBotones.add(b5);
            
            b1.addActionListener(new Oyente());
            b2.addActionListener(new Oyente());
            b3.addActionListener(new Oyente());
            b4.addActionListener(new Oyente());
            b5.addActionListener(new Oyente());
            
            
        }
        
        private class Oyente implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                String nameBoton = e.getActionCommand();

                if(nameBoton.equals("little size")){ texto.setFont(new Font("Serif", Font.PLAIN, 9));}                
                else if ((nameBoton.equals("mediun size"))) texto.setFont(new Font("Serif", Font.PLAIN, 14));
                else if ((nameBoton.equals("big size"))) texto.setFont(new Font("Serif", Font.PLAIN, 24));
                else if ((nameBoton.equals("Negrita"))) texto.setFont(new Font("Serif", Font.BOLD, 14));
                else if ((nameBoton.equals("Cursiva"))) texto.setFont(new Font("Serif", Font.ITALIC, 14));
            }
        
        }
    }
}

