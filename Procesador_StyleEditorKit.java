import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Procesador_StyleEditorKit extends JFrame
{
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

        private int z;
        
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
            configuraMenu("Arial", "fuent", "Arial", 9, z);// solo tiene que modificar el tipo de letra.
            configuraMenu("Bell MT", "fuent", "Bell MT", 9, z);
            configuraMenu("Lucida Handwriting", "fuent", "Lucida Handwriting", 9, z);

            configuraMenu("Negrita", "stilo", " ", Font.BOLD, z);// solo tiene que modificar el stilo.
            configuraMenu("Cursiva", "stilo", " ", Font.ITALIC, z);

            configuraMenu("18", "tamano", " ", 9, 18);
            configuraMenu("25", "tamano", " ", 9, 25);// solo tiene que modificar el tamano.
            configuraMenu("30", "tamano", " ", 9, 30);//  el 9 e nada
            configuraMenu("35", "tamano", " ", 9, 35);//  el 9 e nada
            
        } 

        /**
         * @param rotulo   ----nombre de subclase del elemento de la barra
         * @param menu    -----nombre del elemento de la barra
         * @param tipo_letra   - Nombre del tipo de letra que se asigna al texto.
         * @param est      - Estilo que toma cada tipo de letra, negrita, cursiva etc
         * @param tam       - Tamano de la letra. 
         */
        public void configuraMenu(String rotulo, String menu, String tipo_letra, int est, int tam){
            z = tam;
            JMenuItem elemento_menu = new JMenuItem(rotulo);
            // -- 'elemento_menu' SE ASINA A LA PESTANA DE LA BARRA ESPECIFICADA EN EL 2º PARAMETRO.
            if(menu == "fuent"){
                fuent.add(elemento_menu);
                if(tipo_letra == "Lucida Handwriting"){
                    elemento_menu.addActionListener(new StyledEditorKit.FontFamilyAction("adfaa", "Lucida Handwriting"));
                }else if(tipo_letra == "Arial"){
                    elemento_menu.addActionListener(new StyledEditorKit.FontFamilyAction("gagaga", "Arial"));
                }else if(tipo_letra == "Bell MT"){
                    elemento_menu.addActionListener(new StyledEditorKit.FontFamilyAction("gagaga", "Bell MT"));
                }
            }else if(menu == "stilo"){
                  stilo.add(elemento_menu);             
                if(est == Font.BOLD){                    
                    elemento_menu.addActionListener(new StyledEditorKit.BoldAction());
                }
                else if(est == Font.ITALIC){
                    elemento_menu.addActionListener(new StyledEditorKit.ItalicAction());
                }
                 
            }else if(menu == "tamano"){
                tamano.add(elemento_menu);
            }
            elemento_menu.addActionListener(new  StyledEditorKit.FontSizeAction("adfaa", z));
        }
    }
}
