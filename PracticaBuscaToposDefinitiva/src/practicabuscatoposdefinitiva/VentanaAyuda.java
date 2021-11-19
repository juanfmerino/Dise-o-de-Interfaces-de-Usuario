
package practicabuscatoposdefinitiva;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VentanaAyuda extends JFrame {
    private JLabel titulo; 
    private JLabel descripcion; 
    private JPanel panelAyuda; 
    private JButton volver;
    
    public VentanaAyuda(){

    }
    
    public void configurarVentana(){
        String texto1 = "Menú de Ayuda del juego BUSCATOPOS"; 
        String texto2 = "<html><p>BuscaTopos es un juego que consiste en un tablero con casillas en las que hay escondidos algunos topos.<br>Tu objetivo es no encontrarte con ningún topo porque en ese caso perderás.<br>Las casillas pueden clickarse con botones izquierdo y derecho del ratón: <br> -El botón izquierdo del ratón descubre la casilla. <br> -El botón derecho del ratón se usa para marcar una casilla en la que creas que hay un topo escondido. <br>Así que ten cuidado y no te encuentres con los topos si quieres ganar la partida."; //Uso de etiquetas HTML para imprimir los saltos de línea
       
        titulo = new JLabel(); 
        titulo.setForeground(Color.RED); 
        Font auxFont = titulo.getFont(); 
        titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 40));
        titulo.setText(texto1); 
        
        descripcion = new JLabel();
        descripcion.setForeground(Color.BLUE); 
        auxFont = descripcion.getFont(); 
        descripcion.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        descripcion.setText(texto2); 
        
        volver = new JButton("Volver"); 
        
        this.setLayout(new BorderLayout());
        panelAyuda = new JPanel();
        panelAyuda.setLayout(new BorderLayout(0, 20));
        panelAyuda.add(titulo, BorderLayout.NORTH);
        panelAyuda.add(descripcion, BorderLayout.SOUTH);
        panelAyuda.setBackground(Color.YELLOW);
        add(panelAyuda, BorderLayout.NORTH);
        add(volver, BorderLayout.SOUTH);
       
        volver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose(); 
                VentanaInicio ventanaInicio = new VentanaInicio(); 
                ventanaInicio.configurarVentana();
            }
        });
       
        setTitle("Ayuda");
        setBounds(500, 200, 1000, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    } 
    
}
