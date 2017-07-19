import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBox extends JFrame {

    public static void main(String[] args) {
        CheckBox marco = new CheckBox();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public CheckBox() {

        LaminaCheckBox lamina = new LaminaCheckBox();
        add(lamina);

        setBounds(150, 70, 900, 500);
        setVisible(true);
        setTitle("CheckBox.");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);
    }

    public class LaminaCheckBox extends JPanel {

        private JCheckBox negrita, cursiva;
        private JLabel texto;
        private Font miLetra;

        public LaminaCheckBox() {

            setLayout(new BorderLayout());

            miLetra = new Font("Serif", Font.PLAIN, 24);
            texto = new JLabel("Cada noche mi vida es para ti, como un sueño...");
            texto.setFont(miLetra);

            JPanel laminaTexto = new JPanel();
            laminaTexto.add(texto);
            add(laminaTexto, BorderLayout.CENTER);

            JPanel laminaCheck = new JPanel();
            negrita = new JCheckBox("Negrita");
            cursiva = new JCheckBox("Cursiva");
            laminaCheck.add(negrita);
            laminaCheck.add(cursiva);
            add(laminaCheck, BorderLayout.SOUTH);

            ManejaChecks oyente = new ManejaChecks();
            cursiva.addActionListener(oyente);
            negrita.addActionListener(new ManejaChecks());
        }

        private class ManejaChecks implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                //CADA VEZ QUE UN CHECKBOX ES PRESIONADO 'valorFuente' VALE 0. Y EL MT 'isSelected()' CAMBIA SU VALOR
                // true, false, true, false... CUANDO VALE true, entra en el if, y 'valorFuente' CAMBIA DE VALOR, ESTE
                // NUEVO VALOR ES EL QUE LE PASAMOS AL 'new Font("Serif", valorFuente, 24));'
                int valorFuente = 0;
                
                if (negrita.isSelected()) valorFuente += Font.BOLD;
                if (cursiva.isSelected()) valorFuente += Font.ITALIC;
              
                texto.setFont(new Font("Serif", valorFuente, 24));
            }
        }
    }
}
