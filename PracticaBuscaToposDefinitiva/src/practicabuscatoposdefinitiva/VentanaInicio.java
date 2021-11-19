
package practicabuscatoposdefinitiva;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VentanaInicio extends JFrame {
    private JLabel nombre; 
    private JPanel panelNombre; 
    private JPanel panelBotones; 
    private JPanel panelAyuda; 
    private JButton nuevaPartida; 
    private JButton salir; 
    private JButton ayuda; 
    
    public VentanaInicio(){

    } 
    
    public void configurarVentana(){
        this.setLayout(new GridLayout(3, 1));

        panelNombre = new JPanel(); 
        panelNombre.setLayout(new GridBagLayout()); //Para centrar el JLabel dentro del JPanel
        panelNombre.setBackground(Color.ORANGE); //Cambiando el color de fondo del JPanel
        nombre = new JLabel("BUSCATOPOS"); 
        nombre.setForeground(Color.RED); //Cambiando el color de la letra del JLabel
        Font auxFont = nombre.getFont(); 
        nombre.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 40)); //Definiendo una nueva fuente de texto
        
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        panelBotones.setBackground(Color.YELLOW);
        
        panelAyuda = new JPanel();
        panelAyuda.setLayout(new GridBagLayout());
        panelAyuda.setBackground(Color.ORANGE);
        
        nuevaPartida = new JButton("Nueva Partida");
        salir = new JButton("Salir");
        ayuda = new JButton("Ayuda");
        
        nuevaPartida.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose(); 
                VentanaSeleccion ventanaSeleccion = new VentanaSeleccion();
                ventanaSeleccion.configurarVentana(); 
            }
        });
        
        salir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0); 
            }
        });
        
        ayuda.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose(); 
                VentanaAyuda ventanaAyuda = new VentanaAyuda();
                ventanaAyuda.configurarVentana();
            }
        });
        nuevaPartida.setBackground(Color.GREEN);
        salir.setBackground(new Color(255, 160, 140)); //Definiendo un nuevo color instanciando un objeto de la clase Color con valores rgb
        ayuda.setBackground(Color.CYAN);
        panelNombre.add(nombre);
        panelBotones.add(nuevaPartida);
        panelBotones.add(salir);
        panelAyuda.add(ayuda);        
        
        add(panelNombre, 0);
        add(panelBotones, 1);
        add(panelAyuda, 2);

        setTitle("Menú Principal");
        setBounds(500, 200, 1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    /*public void activarVentana(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }*/
    
    /*public void establecerTexto(String texto){
        nombre.setText(texto);
    }*/ 
}
