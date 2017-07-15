import java.awt.*;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class JavaApplication33_MarcoTexto extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaApplication33_MarcoTexto marco = new JavaApplication33_MarcoTexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JavaApplication33_MarcoTexto() {
        LaminaTexto lamina = new LaminaTexto();
        add(lamina);
        
        setBounds(100, 100, 900, 600);
        setVisible(true);
        setTitle("MarcoTexto");
        
        
        
        Toolkit icono = Toolkit.getDefaultToolkit();
        Image image = icono.getImage("../icono2.gif");
        setIconImage(image);
    }
    
    //CLASE INTERNA PARA CREAR LAMINA DE DIBUJO
    private class LaminaTexto extends JPanel{
    

        public LaminaTexto() {
          // ---  diferentes tipos de constructores
            //JTextField campo1 = new JTextField();
            //JTextField campo1 = new JTextField(50);
            JTextField campo1 = new JTextField("Primer texto", 20);
            add(campo1);
            
            System.out.println(campo1.getText());
        }
        
        
    }
    
}


