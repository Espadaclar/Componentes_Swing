import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * --- Control JSpinner; es un cuadro de texto con dos botones a la derecha,
 * normalmente tiene datos de tipo número, para con estos botones incrementar o
 * disminuir esos valores numéricos. Utilizamos la cl Jspiner.
 *
 * @author Usuario
 */
public class Controles_JSpinner extends JFrame {

    public static void main(String[] args) {
        Controles_JSpinner marco = new Controles_JSpinner();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Controles_JSpinner() {

        Lamina lamina = new Lamina();
        add(lamina);

        setBounds(150, 70, 900, 500);
        setVisible(true);
        setTitle("JavaApplication37_CuadroDeTextoTipoArea_2.");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);
    }

    public class Lamina extends JPanel {

        public Lamina() {
            setLayout(new BorderLayout());
            JPanel lamiJSpinner = new JPanel();
            add(lamiJSpinner, BorderLayout.NORTH);

            Dimension valor = new Dimension(100, 20);//-- para dar dimension al JSpinner.

            //SpinnerNumberModel model = new SpinnerNumberModel(5, 3, 11, 2);

            // -------------------  CONSTRUCTOR PARA  representar valores de tipo fecha.
            // JSpinner spinner = new JSpinner(new SpinnerDateModel());
            
            // ------------------- CONSTRUCTOR PARA  representar valores de tipo lista.
            // Array para anadir como para al 
            //String[] lista ={"lunes ", "martes  ", "miercoles   ", "jueves  ", "viernes "};
            //JSpinner spinner = new JSpinner( new SpinnerListModel(lista));
            // ------ si el parametro de cons, es de tipo 'SpinnerNumberModel()' se puede ponerle limites.
            
            // ------------------- CONSTRUCTOR PARA  representar valores de tipo nuero.
            // 1º parametro -> valorInicio, 2º parametro -> valorMinimo del SPinner,
            // 3º parametro -> valorMaximo, 4º parametro -> nº de unidades que avanza.
            JSpinner spinner = new JSpinner(new SpinnerNumberModel(5, 3, 11, 2));
            spinner.setMaximumSize(valor);
            spinner.setPreferredSize(valor); // -- valor es un objetoDimension para dar dimension al SPinner.
            lamiJSpinner.add(spinner);
        }
    }
}
