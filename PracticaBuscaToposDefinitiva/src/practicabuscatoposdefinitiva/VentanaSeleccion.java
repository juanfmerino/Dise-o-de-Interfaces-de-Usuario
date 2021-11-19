
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaSeleccion extends JFrame {
    private JPanel panelNombre; 
    private JPanel panelTopos;
    private JPanel panelFilas;
    private JPanel panelColumnas;
    private JPanel panelBotones;
    private JPanel panelSeleccion; 
    private JLabel nombre; 
    private JLabel topos;
    private JLabel filas;
    private JLabel columnas;
    private JTextField numTopos;
    private JTextField numFilas;
    private JTextField numColumnas;
    private JButton aceptar;
    private JButton volver;
    private Controlador controlador; 
    private int numeroTopos, numeroFilas, numeroColumnas; 
    private static final int maxFilas = 25; 
    private static final int maxColumnas = 25; 
    private static final int minFilas = 2; 
    private static final int minColumnas = 2;
    
    public VentanaSeleccion(){
          
    }
    
    public void configurarVentana(){
        panelNombre = new JPanel(); 
        panelNombre.setLayout(new GridBagLayout());
        nombre = new JLabel("SELECCIONANDO VALORES");
        Font auxFont = nombre.getFont(); 
        nombre.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        nombre.setForeground(Color.RED);
        panelNombre.setBackground(Color.ORANGE);
        panelNombre.add(nombre);
        
        panelTopos = new JPanel();
        topos = new JLabel("¿Cuántos topos escondidos habrá?     ");
        panelFilas = new JPanel();
        filas = new JLabel("¿Cuántas filas tendrá el tablero?           ");
        panelColumnas = new JPanel();
        columnas = new JLabel("¿Cuántas columnas tendrá el tablero?  ");
        panelBotones = new JPanel();
        panelSeleccion = new JPanel();

        numTopos = new JTextField(10);
        numFilas = new JTextField(10);
        numColumnas = new JTextField(10);
        aceptar = new JButton("Aceptar");
        volver = new JButton("Volver");
        
        panelTopos.setBackground(Color.YELLOW);
        panelTopos.setLayout(new GridBagLayout());
        panelTopos.add(topos);
        panelTopos.add(numTopos);
        
        panelFilas.setBackground(Color.ORANGE);
        panelFilas.setLayout(new GridBagLayout());
        panelFilas.add(filas);
        panelFilas.add(numFilas);
        
        panelColumnas.setBackground(Color.YELLOW);
        panelColumnas.setLayout(new GridBagLayout());
        panelColumnas.add(columnas);
        panelColumnas.add(numColumnas);
        
        panelBotones.setLayout(new GridBagLayout());
        panelBotones.setBackground(Color.ORANGE);
        panelBotones.add(aceptar);
        panelBotones.add(volver);
        
        panelSeleccion.setLayout(new GridLayout(3, 1));
        panelSeleccion.add(panelTopos, 0);
        panelSeleccion.add(panelFilas, 1);
        panelSeleccion.add(panelColumnas, 2);
        
        setLayout(new GridLayout(3, 1));
        add(panelNombre, 0);
        add(panelSeleccion, 1);
        add(panelBotones, 2);
        
        aceptar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean flag = true; 
                String textoTopos = numTopos.getText(); 
                if(textoTopos.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Primer campo de texto vacío. Debes introducir algún número","Error en la introducción",JOptionPane.ERROR_MESSAGE);       
                    flag = false; 
                }
                
                if(flag == true){
                    if(isInteger(numTopos.getText())){ 
                        numeroTopos = Integer.parseInt(textoTopos);
                        if(numeroTopos <= 0){
                            JOptionPane.showMessageDialog(null,"Primer campo de texto incorrecto. Debes introducir un número positivo de topos","Error en la introducción",JOptionPane.ERROR_MESSAGE);                 
                            flag = false; 
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Primer campo de texto incorrecto. Debes introducir algún número","Error en la introducción",JOptionPane.ERROR_MESSAGE);       
                        flag = false; 
                    }
                }
                
                String textoFilas = numFilas.getText(); 
                if(textoFilas.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Segundo campo de texto vacío. Debes introducir algún número","Error en la introducción",JOptionPane.ERROR_MESSAGE);       
                    flag = false; 
                }
                if(flag == true){
                    if(isInteger(numFilas.getText())){ 
                        numeroFilas = Integer.parseInt(textoFilas);
                        if((numeroFilas > maxFilas) || (numeroFilas < minFilas)){
                            JOptionPane.showMessageDialog(null,"Segundo campo fuera del rango permitido. El número máximo de filas es "+maxFilas+" y el número mínimo: "+minFilas,"Error en la introducción",JOptionPane.ERROR_MESSAGE);       
                            flag = false; 
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Segundo campo de texto incorrecto. Debes introducir algún número","Error en la introducción",JOptionPane.ERROR_MESSAGE);
                        flag = false; 
                    }  
                }

                String textoColumnas = numColumnas.getText(); 
                if(textoColumnas.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Tercer campo de texto vacío. Debes introducir algún número","Error en la introducción",JOptionPane.ERROR_MESSAGE);       
                    flag = false; 
                }
                if(flag == true){
                    if(isInteger(numColumnas.getText())){ 
                        numeroColumnas = Integer.parseInt(textoColumnas);  
                        if((numeroColumnas > maxColumnas) || (numeroColumnas < minColumnas)){
                            JOptionPane.showMessageDialog(null,"Tercer campo fuera del rango permitido. El número máximo de Columnas es "+maxColumnas+" y el número mínimo: "+minColumnas,"Error en la introducción",JOptionPane.ERROR_MESSAGE);       
                            flag = false; 
                        }                    
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Tercer campo de texto incorrecto. Debes introducir algún número","Error en la introducción",JOptionPane.ERROR_MESSAGE);
                        flag = false; 
                    } 
                }                

                if((flag == true) && (numeroTopos > (numeroFilas*numeroColumnas))){
                    flag = false; 
                    JOptionPane.showMessageDialog(null,"El número de topos no puede ser mayor que el de casillas. Debes introducir algún número","Error en la introducción",JOptionPane.ERROR_MESSAGE);       
                }
                
                if(flag == true){
                    dispose(); 
                    controlador = new Controlador(numeroTopos, numeroFilas, numeroColumnas);  
                    controlador.configurarControlador();   
                }
            }
            
        });
        
        volver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose(); 
                VentanaInicio vi = new VentanaInicio(); 
                vi.configurarVentana();
            }
        
        });        
        
        setTitle("Menú de Selección");
        setBounds(500, 200, 1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public boolean isInteger(String texto){ //Método para saber si el valor introducido por el usuario es un número
        try{
            Integer.parseInt(texto);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    /*public int devolverNumTopos(){
        return numeroTopos;  
    }
    
    public int devolverNumFilas(){
        return numeroFilas;  
    }
    
    public int devolverNumColumnas(){
        return numeroColumnas;  
    }*/ 
    
}
