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

        public Lamina() {
            setLayout(new BorderLayout());           
            JPanel lamiMenu = new JPanel();
            add(lamiMenu, BorderLayout.NORTH);

            JMenuBar barraMenu = new JMenuBar();// ------- BARRA PARA COLOCAR LOS ELEMENOS DE MENU.
            JMenu archivo = new JMenu("Archivo");// -------ELEMENTO PARA COLOCAR EN LA BARRA.
            JMenu edicion = new JMenu("Edicion");
            JMenu insertar = new JMenu("Insertar");
            JMenu herramientas = new JMenu("Herramientas");
            JMenu opciones = new JMenu("Opciones");// ----- creado para formar una subclase detro del 'elemento' Archivo 
            // - que cuelgan de los elementos que forman la barra
            opciones.add(new JMenuItem("Opcion_1"));//---------------forma parte de la subclase "Opciones"
            opciones.add(new JMenuItem("Opcion_2"));//---------------forma parte de la subclase "Opciones"

            JMenuItem nuevo = new JMenuItem("Nuevo");// ---- OPCIONES PARA EL ELEMENTO ARCHIVO
            JMenuItem abrir = new JMenuItem("Abrir");
            JMenuItem guardar = new JMenuItem("Guardar");
            JMenuItem guardarComo = new JMenuItem("Guardar como");

            barraMenu.add(archivo);// -------------------- ANADE  ELEMENTOS A LA BARRA.
            barraMenu.add(edicion);
            barraMenu.add(insertar);
            barraMenu.add(herramientas);

            archivo.add(nuevo);// ------- ANADE OPCIONES AL ELEMENTO ARCHIVO.
            archivo.add(abrir);
            archivo.add(guardar);
            archivo.add(guardarComo);
            archivo.addSeparator();// ------------para que aparecca una linea separando a 'opiones'
            archivo.add(opciones);// ---------------------- lleva asociado una subclase 'menu que agrega otro menu.

            insertar.add(new JMenuItem("Imagen"));// ------- ANADE OPCIONES AL ELEMENTO INSERTAR.
            insertar.add(new JMenuItem("Tabla"));
            insertar.add(new JMenuItem("Formas"));

            lamiMenu.add(barraMenu);//  ------------------- AGREGA LA BARRA A LA LAMINA.
        }
    }
}