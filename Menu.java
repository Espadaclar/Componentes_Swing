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

        private JTextArea texto;
        private JScrollPane barra;
        private Font fuente;
        private JPanel lamiTexto;
        
        public Lamina() {
            
            setLayout(new BorderLayout()); 
            JPanel lamiMenu = new JPanel();   
            lamiTexto = new JPanel();
            barra = new JScrollPane(lamiTexto);
            
            
            add(lamiMenu, BorderLayout.NORTH);
            add(barra, BorderLayout.SOUTH);
            
            
          
            texto = new JTextArea(25, 50);
            fuente = new Font("Serif", Font.BOLD, 13);
            //texto.setFont(fuente);
            lamiTexto.add(texto);
            
            
            JMenuBar barraMenu = new JMenuBar();// ------- BARRA PARA COLOCAR LOS ELEMENOS DE MENU.
            JMenu fuente = new JMenu("Fuente");// -------ELEMENTO PARA COLOCAR EN LA BARRA.
            JMenu estilo = new JMenu("Estilo");
            JMenu size = new JMenu("Size");

            JMenuItem arial = new JMenuItem("Arial");
            JMenuItem serif = new JMenuItem("Serif");
            JMenuItem verdana = new JMenuItem("Verdana");
         
            barraMenu.add(fuente);// -------------------- ANADE  ELEMENTOS A LA BARRA.
            barraMenu.add(estilo);
            barraMenu.add(size);
 
            fuente.add(arial);// ------- ANADE OPCIONES AL ELEMENTO FUENTE.
            fuente.add(serif);
            fuente.add(verdana);
            //fuente.addSeparator();// ------------para que aparecca una linea separando a 'opiones'

            JMenuItem negrita = new JMenuItem("Negrita");
            JMenuItem normal = new JMenuItem("Normal");
            estilo.add(negrita);// ------- ANADE OPCIONES AL ELEMENTO INSERTAR.
            estilo.add(normal);
            
            JMenuItem diez = new JMenuItem("10");
            JMenuItem catorce = new JMenuItem("14");
            JMenuItem diezYocho = new JMenuItem("18");
            size.add(diez);
            size.add(catorce);
            size.add(diezYocho);
           
            lamiMenu.add(barraMenu);//  ------------------- AGREGA LA BARRA A LA LAMINA
            
            Oyente oyente = new Oyente();
            arial.addActionListener(oyente);
            serif.addActionListener(oyente);
            verdana.addActionListener(oyente);
            
           // negrita.addActionListener(oyente);
            negrita.addActionListener(new ActionListener() {// ---CLASE ANONIMA EN VEZ DE LA CLASE INTERNA OYENTE
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    texto.setFont(new Font("Arial", Font.BOLD, 13));
                }
            });
            
            normal.addActionListener(oyente);
            
            diez.addActionListener(oyente);
            catorce.addActionListener(oyente);
            diezYocho.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    texto.setFont(new Font("Arial", Font.PLAIN, 18));
                }
            });
        }
        
        private class Oyente implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                String valor = e.getActionCommand();
                
                if(valor.equals("Arial")){
                    texto.setFont(new Font("Arial", Font.PLAIN, 13));
                }else if(valor.equals("Serif")){
                    texto.setFont(new Font("Serif", Font.PLAIN, 13));
                }else if(valor.equals("Verdana")){
                    texto.setFont(new Font("Verdana", Font.PLAIN, 13));
                }
                
               /* else if(valor.equals("Negrita")){
                    texto.setFont(new Font("Arial", Font.BOLD, 13));
                }*/
                else if(valor.equals("Normal")){
                    texto.setFont(new Font("Arial", Font.PLAIN, 13));
                }else if(valor.equals("10")){
                    texto.setFont(new Font("Arial", Font.PLAIN, 10));
                }else if(valor.equals("14")){
                    texto.setFont(new Font("Serif", Font.PLAIN, 14));
                }
                
                /*else if(valor.equals("18")){
                    texto.setFont(new Font("Arial", Font.PLAIN, 18));
                }*/
                
                    
                
               // texto.setFont(new Font("Arial", Font.PLAIN, 13));
                System.out.println(valor);
            }      
        }
    }
}

