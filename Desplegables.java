import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 *
 * @author Usuario
 */
public class Desplegables extends JFrame{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Desplegables marco = new Desplegables();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Desplegables() {

        LaminaCombo lamina = new LaminaCombo();
        add(lamina);
        setBounds(150, 70, 900, 500);
        setVisible(true);
        setTitle("JavaApplication37_CuadroDeTextoTipoArea_2.");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);
    }

    public class LaminaCombo extends JPanel {

        private  JLabel tex;
        private Font fuente;
        private JComboBox desple;// --- Objeto desplegable
        private JPanel laminaCom;

        public LaminaCombo() {
            setLayout(new BorderLayout());

            desple = new JComboBox();
            desple.setEditable(true);
            desple.addItem("tamaño de letra grande.");
            desple.addItem("tamaño de letra mediano.");
            desple.addItem("tamaño de letra pequeño.");
            desple.addItem(" letra negrita.");
            desple.addItem(" letra cursiva.");
            desple.addItem(" Monospaced.");
            desple.addItem(" Dialog.");
            desple.addItem(" Arial.");
            laminaCom = new JPanel();
            laminaCom.add(desple);
            add(laminaCom, BorderLayout.NORTH);

            tex = new JLabel();
            tex.setText("MOKU YOKU SHIN THAY, SHIN YIN MOKU, TO GAN SHU, DAN HO BONNO, KURIO YAKU METSU");
            fuente = new Font("Serif", Font.PLAIN, 13);
            tex.setFont(fuente);            
            add(tex, BorderLayout.CENTER);

            Oyente oyente = new Oyente();
            desple.addActionListener(oyente);
        }

        private class Oyente implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                Object dato = new Object();
                // ---getSelectedItem() devuelve un objeto de tipo Object, hacemos casting para pasarlo a String.
                String tipoFuente = (String)desple.getSelectedItem();
                int valor = desple.getSelectedIndex();
                if (valor == 0) tex.setFont(new Font("Serif", Font.PLAIN, 20));
                if (valor == 1) tex.setFont(new Font("Serif", Font.PLAIN, 14));
                if (valor == 2) tex.setFont(new Font("Serif", Font.PLAIN, 9));
                if (valor == 3) tex.setFont(new Font("Serif", Font.BOLD, 14));
                if (valor == 4) tex.setFont(new Font("Serif", Font.ITALIC, 14));
                if(tipoFuente.equals(" Monospaced.")) tex.setFont(new Font("Monospaced", Font.PLAIN, 14)); 
                if(tipoFuente.equals(" Dialog.")) tex.setFont(new Font("Dialog", Font.PLAIN, 14)); 
                if(tipoFuente.equals(" Arial.")) tex.setFont(new Font("Arial", Font.PLAIN, 14));                 
            }        
        }        
    }
}
