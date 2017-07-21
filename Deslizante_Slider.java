
import java.awt.*;
import javax.swing.*;

/**
 *franciscoJavier
 */
public class Deslizante_Slider  extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
     Deslizante_Slider  marco = new Deslizante_Slider ();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Deslizante_Slider() {
        
        Lamina lamina = new Lamina();
        add(lamina);
        
        setBounds(150, 70, 900, 500);
        setVisible(true);
        setTitle("Deslizantes_Sliders.");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);
    }

    public class Lamina extends JPanel {

        public Lamina() {
            setLayout(new BorderLayout());
            // --   PARA INDICAR LA ORIENTACION DEL Slaider EN EL CONS. UTILIZAR LA INTERFACE SwingConstants.
            // -- 2º para indica el comienzo, 3º para indica el final, 4º indica dode se situa el indicador.
            JSlider desliza = new JSlider(SwingConstants.VERTICAL, 0, 50, 22);
            // -- CAMBIAMOS  LA FUENTE DEL Slider.
            desliza.setFont(new Font("Arial", Font.ITALIC, 12));
            
            // --  PARA PONER MARCAS EN EL Slider, 1º se dice cada cuanto van
            desliza.setMajorTickSpacing(10);// --  MARCA MAYOR
            desliza.setMinorTickSpacing(2);// --  MARCA MAYOR
            
            desliza.setPaintTicks(true);// ---  LE DECIMOS QUE IMPRIMA ESAS MARCAS.
            desliza.setPaintLabels(true);// --- LE DECIMOS QUE IMPRIMA LOS Nº.
            desliza.setSnapToTicks(true);// --- SI SOLTAMOS EL 'Slider' ENTRE DOS MARCAS SE VA AUTOMATICAMENTE
                                         //---------A LA QUE MÁS CERCA LE QUEDE.
            JPanel laminaJs = new JPanel();
            laminaJs.add(desliza);
            add(laminaJs, BorderLayout.WEST);
        }
    }
}