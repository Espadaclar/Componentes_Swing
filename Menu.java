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
            configuraMenu("Arial", "fuent", "Arial", 9, 1);// solo tiene que modificar el tipo de letra.
            configuraMenu("Bell MT", "fuent", "Bell MT", 9, 1);
            configuraMenu("Lucida Handwriting", "fuent", "Lucida Handwriting", 9, 1);

            configuraMenu("Negrita", "stilo", " ", Font.BOLD, 1);// solo tiene que modificar el stilo.
            configuraMenu("Cursiva", "stilo", " ", Font.PLAIN, 1);

            configuraMenu("14", "tamano", " ", 9, 14);           
            configuraMenu("18", "tamano", " ", 9, 18);// solo tiene que modificar el tamano.
            configuraMenu("22", "tamano", " ", 9, 22);
            configuraMenu("28", "tamano", " ", 9, 28);//  el 9 e nada
        } 

        /**
         * @param rotulo   ----nombre de subclase del elemento de la barra
         * @param menu    -----nombre del elemento de la barra
         * @param nameFont   - Nombre del tipo de letra que se asigna al texto.
         * @param stilo      - Estilo que toma cada tipo de letra, negrita, cursiva etc
         * @param size       - Tamano de la letra. 
         */
        public void configuraMenu(String rotulo, String menu, String tipo_letra, int estilo, int tam){

            JMenuItem elemento_menu = new JMenuItem(rotulo);
            // -- 'elemento_menu' SE ASINA A LA PESTANA DE LA BARRA ESPECIFICADA EN EL 2º PARAMETRO.
            if(menu == "fuent"){
                fuent.add(elemento_menu);
            }else if(menu == "stilo"){
                stilo.add(elemento_menu);
            }else if(menu == "tamano"){
                tamano.add(elemento_menu);
            }

            //// la pasamos los mismos parametros con los que se crea el mt, y esta instancia 
            // a su vez pasa el valor de sus atributos a la cl interna
            elemento_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilo, tam));                    
        }

        // -------------- CLASE INTERNA PARA GESTIONAR LOS EVENTOS.
        private class Gestiona_Eventos implements ActionListener{

            //1º tenemos que conseguir que los parametros del objeto 'Font' vallan cambiando en función
            // del elemento de la barra que pulsemos y los otros se conserven. Para que se conserven 
            //    declaramos atributos
            private String tipo_texto; //----tipo de letra, Arial, Verdana...
            private String menu; //-- el menu que pulsamos, Arial, Cursiva, 20, 14 ...
            private int estilo_letra; // -- para especificar el estilo de letra con 'Font.PLAIN'
            private int tamagno_letra; // --- para el tamaño de la letra

            /**
             * ESTE CONS MAS QUE NADA ES PARA DETECTAR CUAL ES EL MENU EN EL QUE HEMOS PULSADO
             * CUANDO INSTACIEMOS ESTA CL, EN LA CL PADRE,
             * @param elemento --elemento que hemos pulsado, arial, negrita, 13, 23 ...
             * @param texto2   --almacena el nombre del boton pulsado. Arial, Negrita ...
             * @param estilo2  --almacena el estilo que hayamos pulsado en cada momento.
             * @param tam_letra -almacen el tamano de la letra que hayamos pulsado. 
             */
            public Gestiona_Eventos(String elemento, String texto2, int estilo2, int tam_letra) {

                //4º damos valor a los atributos con el valor que demos a los parametros del cons
                //   cuando instanciemos la cl en la cl padre.
                tipo_texto = texto2;
                menu = elemento;
                estilo_letra = estilo2;
                tamagno_letra = tam_letra;
            }

            //2º sustituimos los parametros 'new Font("Arial", Font.PLAIN, 22)' por los atributos
            // --------------MT PARA CAMBIAR EL TIPO DE LETRA.
            @Override
            public void actionPerformed(ActionEvent e) {
                Font letra = texto.getFont();

                String valor = e.getActionCommand();

                fuente = texto.getFont();
                if (valor == "Negrita" || valor == "Cursiva") {
                    if(fuente.getStyle() == 1 || fuente.getStyle() == 2 ){
                        estilo_letra = 3;
                    }
                    tipo_texto = fuente.getFontName();
                    tamagno_letra = fuente.getSize();
                } else if (valor == "Lucida Handwriting" || valor == "Bell MT" || valor == "Arial") {
                    tamagno_letra = fuente.getSize();
                    estilo_letra = fuente.getStyle();
                } else if (valor == "14" || valor == "18" || valor == "22" || valor == "28") {
                    tipo_texto = fuente.getFontName();
                    estilo_letra = fuente.getStyle();
                }

                texto.setFont(new Font(tipo_texto, estilo_letra, tamagno_letra));  
                System.out.println("TIPO. " +tipo_texto+ ".  -----TAMAÑO " +tamagno_letra+
                    ". ----ESTILO " +estilo_letra);
            }

            //3º tenemos que almacenar en los atributos el menu correspondiente al tipo de texto
            //   ,estilo de letra y tamano de letra.
            //  tenemos que conseguir pasar los valores de la clase padre a la clase hijo, y para conseguir
            // esto, utilizamos el constructor de la cl 'Gestiona_Eventos'

            //5º en el mt 'configuraMenu(....)' ponemos a la escucha a los objetos que vamos creando,
            // y es hay donde instaciamos la cl Gestiona_Eventos 
            //elemento_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilo, tam));
            // la pasamos los mismos parametros con los que se crea el mt

            // 1, 2, 3 4,  y 5 EXPLICADO --> cuando para crear un objeto incocamos el mt
            // 'configuraMenu("Arial", "fuent", "Arial", Font.PLAIN, 1);' cada uno de sus atri 
            // viaja a los atri del mt; 'configuraMenu(String rotulo, String menu, 
            //                                              String tipo_letra, int estilo, int tam)

            // de igual modo, 4 de estos atributos se almacenan en los param, que utilizamos
            //        para instanciar al oyente, dentro del mismo mt..'configuraMenu("...)
            // -----elemento_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilo, tam));
            //
            // y el valor de estos parametros se almacena en los argumentos del cons de la clase
            //  'Gestiona_Eventos(String elemento, String texto2, int estilo2, int tam_letra)' que a su vez
            // le pasa el valor a sus atributos donde queda almacenado el valor
        }     
    }
}
