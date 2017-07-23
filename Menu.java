import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 *------------ Menus  elemento fundamentas de una interface gráfica  -------
 *1º crear barra, sera el soporte, utilizamos la cl ,JMenuBar, 
 *2º  los elementos que forman el menu,  cl ,JMenu,  cada vez que instancias esta cl, creas un elemento
 *      de menu, que estarán dentro de la barra de menú.
 *3º de algunos de estos elementos de menu colgaran algunas opciones, para ello está la cl ,JMenuItem, 
 *    cada vez que instancias esta cl creas un elemento.
 *franciscoJavier
 */
public class Menu extends JFrame
{
    public static void main(String[] args) {
        Menu marco = new Menu();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Menu() {
        Lamina lamina = new Lamina();
        add(lamina);

        setBounds(150, 70, 900, 500);
        setVisible(true);
        setTitle("46_Menus");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);
    }

    public class Lamina extends JPanel {
        JPanel laminaN = new JPanel();//     para colocar la barra del menu.
        JMenuBar barraM = new JMenuBar();//  barra del menu
        JMenu fuent, tamano, stilo;
        JTextPane texto = new JTextPane();// cuadro de texto
        Font fuente = new Font(null);//      da formato al texto

        public Lamina() {

            setLayout(new BorderLayout());
            add(laminaN, BorderLayout.NORTH);
            add(texto, BorderLayout.CENTER);
            //texto.setFont(new Font("Arial", Font.PLAIN, 22));
            laminaN.add(barraM);// -------------pone la barra dentro de una lamina.

            fuent = new JMenu("Fuente");           
            stilo = new JMenu("Stilo");
            tamano = new JMenu("Tamaño");

            barraM.add(fuent);
            barraM.add(stilo);
            barraM.add(tamano);
            configuraMenu("Arial", "fuent", "Arial", Font.PLAIN, 15);
            configuraMenu("Bernard MT Condensed", "fuent", "Bernard MT Condensed", Font.PLAIN, 15);
            configuraMenu("Lucida Handwriting", "fuent", "Lucida Handwriting", Font.PLAIN, 15);

            configuraMenu("Negrita", "stilo", "Bernard MT Condensed", Font.BOLD, 15);
            configuraMenu("Normal", "stilo", "Lucida Handwriting", Font.PLAIN, 15);

            configuraMenu("18", "tamano", "Arial", Font.PLAIN, 18);
            configuraMenu("25", "tamano", "Bernard MT Condensed", Font.PLAIN, 25);
            configuraMenu("10", "tamano", "Lucida Handwriting", Font.PLAIN, 10);
        } 

        /**
         * @param rotulo   ----nombre de subclase del elemento de la barra
         * @param menu    -----nombre del elemento de la barra
         * @param nameFont   - Nombre del tipo de letra que se asigna al texto.
         * @param stilo      - Estilo que toma cada tipo de letra, negrita, cursiva etc
         * @param size       - Tamano de la letra. 
         */
        public void configuraMenu(String rotulo, String menu, String nameFont, int stil, int size){

            JMenuItem elemento_menu = new JMenuItem(rotulo);
            // -- 'elemento_menu' SE ASINA A LA PESTANA DE LA BARRA ESPECIFICADA EN EL 2º PARAMETRO.
            if(menu == "fuent"){
                fuent.add(elemento_menu);
            }else if(menu == "stilo"){
                stilo.add(elemento_menu);
            }else if(menu == "tamano"){
                tamano.add(elemento_menu);
            }
            elemento_menu.addActionListener(new ActionListener() { // ----- CLASE INTERNA ANONIMA.
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        texto.setFont(new Font(nameFont, stil, size));
                    }
                });                    
        }
    }
}
