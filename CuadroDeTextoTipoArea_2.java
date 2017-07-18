import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

/**
 *------------------------------------ HACEMOS TODO EL CODIGO DENTRO DE LA CLASE DEL MARCO VD-91
 * @author Usuario
 */
public class CuadroDeTextoTipoArea_2 extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CuadroDeTextoTipoArea_2 marco = new CuadroDeTextoTipoArea_2();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel laminaBotones;
    private JButton botonInsertar, botonSaltoLinea;
    private JTextArea areaTexto;
    private JScrollPane laminaConBarra;

    public CuadroDeTextoTipoArea_2() {
         //------------ESTABLECEMOS DIRECTAMENTE EL LAYOUT EN EL PROPIO MARCO
        this.setLayout(new BorderLayout());

        laminaBotones = new JPanel();
        botonInsertar = new JButton("Insertar");
        botonSaltoLinea = new JButton("Salto Línea");
        
        laminaBotones.add(botonInsertar);        
        laminaBotones.add(botonSaltoLinea);
        add(laminaBotones, BorderLayout.SOUTH);
 
        areaTexto = new JTextArea(8, 20);
        laminaConBarra = new JScrollPane(areaTexto);
        add(laminaConBarra, BorderLayout.CENTER);
        
        //------------ PROPIEDADES DEL MARCO.
        setBounds(150, 100, 1000, 600);
        setVisible(true);
        setTitle("Cuadro Texto_TipoArea."); 
        
        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);
        
        botonInsertar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    areaTexto.append("Cada noche mi vida es para tí, como un sueños cualquiera y naaaada más.  ");
                }
            });

        botonSaltoLinea.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean saltar = !areaTexto.getLineWrap();
                    areaTexto.setLineWrap(saltar);

                    if(saltar){
                        botonSaltoLinea.setText("Quitar salto");
                    }
                    else{
                        botonSaltoLinea.setText("Poner Salto Linea");
                    }
                }
            });
            
           
            
    }
}







