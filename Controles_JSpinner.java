import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * --- Control JSpinner; con una CLASE INTERNA ANONIMA. Consiste básicamente en que en vez de instanciar un objeto como parametro del 
 * --- constructor, 'JSpinner(new MiModeloJspinner())' ¡¡¡CREAR LA CLASE ENTERA AHÍ DENTRO !!! 
 * --- Te evita tener que crear la clase y el costructor de la instancia que pasas como parámetro.
 * 
 * --- la clave para construir esta CLASE INTERNA ANONIMA esta en la colocacion de dos llaves dentro del constructor;
 *  -- ******** 'JSpinner spinner = new JSpinner(new SpinnerNumberModel(5,0,10,1){ ** CODIGO d clase inter ****      });    ****
 *  
 *          ANONIMA PORQUE NO TIENE NOMBRE.  PERO SI TIENE LLAVE DE APERTURA Y LLAVE DE CIERRE
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

        /*public Lamina() {
        setLayout(new BorderLayout());
        JPanel lamiJSpinner = new JPanel();
        add(lamiJSpinner, BorderLayout.NORTH);

        Dimension valor = new Dimension(100, 20);//-- para dar dimension al JSpinner.

        JSpinner spinner = new JSpinner(new MiModeloJspinner());
        spinner.setMaximumSize(valor);
        spinner.setPreferredSize(valor); // -- valor es un objetoDimension para dar dimension al SPinner.
        lamiJSpinner.add(spinner);
        }*/
        public Lamina() {
            setLayout(new BorderLayout());
            JPanel lamiJSpinner = new JPanel();
            add(lamiJSpinner, BorderLayout.NORTH);

            Dimension valor = new Dimension(100, 20);//-- para dar dimension al JSpinner.

            JSpinner spinner = new JSpinner(new SpinnerNumberModel(5,0,10,1){ // CLASE INTERNA ANONIMA
                        public Object getPreviousValue(){
                            return super.getNextValue();
                        }           

                        public Object getNextValue(){
                            return super.getPreviousValue();                        
                        }
                    });
            spinner.setMaximumSize(valor);
            spinner.setPreferredSize(valor); // -- valor es un objetoDimension para dar dimension al SPinner.
            lamiJSpinner.add(spinner);
        }

        /**
         * Cambiamos el incremento del botón que incrementa para que decremente
         * y viceversa. ,para ello tenemos que crear nuestro propio modelo
         * SpinnerDateModel’ o ‘SpinnerListModel’ o SpinnerNumberModel’ no
         * sirven.
         *
         * Tenemos que crear una clase para este modelo
         */
        /* private class MiModeloJspinner extends SpinnerNumberModel {
        //1º Establecemos en el constructor los valores que tendrá nuestro modelo.            
        public MiModeloJspinner() {
        super(5,0,11,1);
        }            
        //2º Buscamos en la cl SpinnerNumberModel algun mt que nos permita invertir este comportamiento.
        // - getNextValue()' devuelve el valor siguiente que figura en el Spinner,
        // - 'getPreviusValue()' devuelve el valor anterior al que figura en el Spinner

        public Object getPreviousValue(){
        return super.getNextValue();
        }           
        public Object getNextValue(){
        return super.getPreviousValue();                        
        }
        // 3º instanciamos esta clase en la cl Lamina
        }*/
    }
}


