import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.*;
/**
 * -------Atajos de Teclado,  la cl ’JmenuIten’ dispone del mt,  ‘setAccelerator(KeyStroke keyStrokd)’  para realizar 
 * acciones  de teclado.  Pide como parámetro un objeto de tipo ‘KeyStroke’. y en esta cl tenemos el mt; 
 * 'getKeyStroke(int keyCode, int modifiers)'   El parámetro KeyCode - especifica el código numérico para una clave
 * del teclado, cada tecla tiene un nº asignad.
 * El parám Modificadores - una combinación de cualquier modificador (Ctrl, Alt, Ins …) tiene un nº asignado.
 * 
 * Para ver la informacion de estas variables tenemos que ver la información que aporta el mt, getKeyStroke al final.
 * En  " See Also " 
 * -----------------------Codigo en líneas 101 y 106.
 */
public class Procesador_StyleEditorKit extends JFrame
{
    private Image image;
    private Toolkit icon;
    public static void main(String[] args) {
        Procesador_StyleEditorKit marco = new Procesador_StyleEditorKit();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Procesador_StyleEditorKit() {
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

        private int z; // --almacena el tamano de la letra.
        private ButtonGroup group;
        private JRadioButtonMenuItem radio;
        private ButtonGroup group2;
        private JRadioButtonMenuItem radio2;

        private JPopupMenu emerge;
        public Lamina() {

            emerge = new JPopupMenu();
            group = new ButtonGroup();
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

            creaFuenteJRadioButtonMenuItem("Arial", "../iconos/copiar.gif");
            creaFuenteJRadioButtonMenuItem("Bell MT", "../iconos/copiar.gif");
            creaFuenteJRadioButtonMenuItem("Lucida Handwriting", "../iconos/copiar.gif");

            configuraMenu("Negrita", "stilo", " ", Font.BOLD, z, "");// solo tiene que modificar el stilo.
            configuraMenu("Cursiva", "stilo", " ", Font.ITALIC, z, "");

            creaTamanoJRadioButtonMenuItem("18", "../iconos/cortar.gif", 18 );
            creaTamanoJRadioButtonMenuItem("25", "../iconos/cortar.gif", 25 );
            creaTamanoJRadioButtonMenuItem("30", "../iconos/cortar.gif", 30 );
            creaTamanoJRadioButtonMenuItem("35", "../iconos/cortar.gif", 35 );

            etiquetaEmergente("Negrita");
            etiquetaEmergente("Cursiva");
        } 

        /**
         * @param rotulo   ----nombre de subclase del elemento de la barra
         * @param menu    -----nombre del elemento de la barra
         * @param tipo_letra   - Nombre del tipo de letra que se asigna al texto.
         * @param est      - Estilo que toma cada tipo de letra, negrita, cursiva etc
         * @param tam       - Tamano de la letra. 
         */
        public void configuraMenu(String rotulo, String menu, String tipo_letra, int est, int tam, String icon){
            z = tam;
            JMenuItem elemento_menu = new JMenuItem(rotulo, new ImageIcon(icon));

            if(menu == "stilo"){
                stilo.add(elemento_menu);             
                if(est == Font.BOLD){  
                    // --- atajo de teclado para poner en negrita el texto seleccionado.
                    elemento_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
                    elemento_menu.addActionListener(new StyledEditorKit.BoldAction());
                }
                else if(est == Font.ITALIC){
                    // --- atajo de teclado para poner en cursiva el texto seleccionado.
                    elemento_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
                    elemento_menu.addActionListener(new StyledEditorKit.ItalicAction());
                }                
            }
        }

        public void creaTamanoJRadioButtonMenuItem(String text, String icono, int tam){
            z = tam;
            radio = new JRadioButtonMenuItem(text, new ImageIcon(icono));
            radio.addActionListener(new  StyledEditorKit.FontSizeAction("adfaa", z));
            tamano.add(radio);
            group.add(radio);
        }

        public void creaFuenteJRadioButtonMenuItem(String TipoLetra, String icono){
            radio = new JRadioButtonMenuItem(TipoLetra, new ImageIcon(icono));
            radio.addActionListener(new StyledEditorKit.FontFamilyAction("adfaa", TipoLetra));
            fuent.add(radio);
            group.add(radio);
        }

        /**
         * Crea etiquetas para menuEmergente, tambien gestiona el evento que realiza.
         * @param name nombre de la etiqueta. 
         */
        public void etiquetaEmergente(String name){

            JMenuItem element = new JMenuItem(name); // ELEMENTO QUE APARECE EN EL MENU EMERGENTE.
            emerge.add(element); // ----------------LO ANADIMOS A 'emerge = new JPopupMenu();'
            texto.setComponentPopupMenu(emerge);//  APLICAMOS EL MT set..(..) al objeto en el que actuará
            if(name.equals("Negrita")){ // --------- APLICAMOS EL GESTOR DE EVENTOS
                element.addActionListener(new StyledEditorKit.BoldAction());
            }else if(name.equals("Cursiva")){
                element.addActionListener(new StyledEditorKit.ItalicAction());
            }
        }
    }
}
