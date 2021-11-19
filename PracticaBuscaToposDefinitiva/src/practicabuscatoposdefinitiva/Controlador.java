
package practicabuscatoposdefinitiva;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Controlador extends JFrame {
    private Vista vista; 
    private Modelo modelo; 
    private Casilla[][] botones; 
    private JButton reiniciar; 
    private JButton nuevosValores; 
    private JButton salir; 
    private JLabel titulo; 
    private JPanel panelTitulo;
    private JPanel panelBotones;
    private JPanel panelOpciones;
    private int numTopos; 
    private int numFilas; 
    private int numColumnas; 
    private final int intervalo = 1000;
    private Timer t;
    private int seg = 0;
    private int min = 0;
    
    public Controlador(int topos, int filas, int columnas){
        numTopos = topos; 
        numFilas = filas; 
        numColumnas = columnas; 
    }

    public void configurarControlador(){
        modelo = new Modelo(); 
        vista = new Vista(modelo, this);

        setLayout(new BorderLayout());
        
        panelTitulo = new JPanel(); 
        titulo = new JLabel("JUGANDO AL BUSCATOPOS");
        Font auxFont = titulo.getFont(); 
        titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        titulo.setForeground(Color.RED);
        panelTitulo.setBackground(Color.ORANGE);
        panelTitulo.add(titulo);
        
        panelBotones = new JPanel();      
        inicializarJuego(numTopos, numFilas, numColumnas);        

        panelOpciones = new JPanel(); 
        panelOpciones.setBackground(Color.ORANGE);
        reiniciar = new JButton("Reiniciar Partida"); 
        nuevosValores = new JButton("Jugar Con Nuevos Valores"); 
        salir = new JButton("Salir de la Partida"); 
        panelOpciones.add(reiniciar);
        panelOpciones.add(nuevosValores);
        panelOpciones.add(salir);        
        
        modelo.addObserver(vista);
        
        for(int i=0;i<numFilas;i++){
            for(int j=0;j<numColumnas;j++){
                botones[i][j].setToolTipText("<html><p>Click Izquierdo: descubrir casilla<br/>Click Derecho: marcar casilla</p></html>"); //Añadir un texto explicativo al botón 
                botones[i][j].addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent evt){ //Escuchador para los eventos de ratón
                        if(evt.isMetaDown()){ //Si pulsa el click derecho 
                            modelo.setOpcion("Marcar");                                
                            for(int i=0;i<numFilas;i++){
                                for(int j=0;j<numColumnas;j++){
                                    if(evt.getSource() == botones[i][j]){
                                        modelo.marcarCasilla(i, j);
                                    }
                                }
                            }
                        }
                        else{ //Si pulsa el click izquierdo 
                            modelo.setOpcion("Descubrir");
                            for(int i=0;i<numFilas;i++){
                                for(int j=0;j<numColumnas;j++){
                                    if(evt.getSource() == botones[i][j]){
                                        modelo.descubrirCasillasDefinitivo(i, j);
                                        if(modelo.comprobarMatriz()== true){ //Has ganado
                                            t.stop();
                                            if(modelo.devolverValorCasilla(i, j) != -1){
                                                JOptionPane.showMessageDialog(null,"Fin de la Partida. Has ganado en: "+min+" minutos y "+seg+" segundos","Fin de la Partida",JOptionPane.INFORMATION_MESSAGE);  
                                            }
                                            dispose();
                                            VentanaInicio ventanaInicio = new VentanaInicio(); 
                                            ventanaInicio.configurarVentana();
                                        }
                                        if(modelo.devolverValorCasilla(i, j) == -1){ //Has perdido
                                            t.stop(); 
                                            JOptionPane.showMessageDialog(null,"Fin de la Partida. Has perdido en: "+min+" minutos y "+seg+" segundos","Fin de la Partida",JOptionPane.INFORMATION_MESSAGE); 
                                            dispose();
                                            VentanaInicio ventanaInicio = new VentanaInicio(); 
                                            ventanaInicio.configurarVentana();
                                        }
                                    }
                                }
                            }
                        }

                    }
                
                });
            }
        }
        
        reiniciar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t.stop();
                dispose(); 
                Controlador c = new Controlador(numTopos, numFilas, numColumnas);
                c.configurarControlador();
            }
        
        });
        
        nuevosValores.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t.stop();
                dispose(); 
                VentanaSeleccion vs = new VentanaSeleccion(); 
                vs.configurarVentana();
            }
        
        });

        salir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t.stop();
                dispose(); 
                VentanaInicio vi = new VentanaInicio();
                vi.configurarVentana();
            }
        
        });
        
        add(panelTitulo, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(panelOpciones, BorderLayout.SOUTH); 
        
        setTitle("Menú Principal"); 
        setBounds(500, 200, 900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public void inicializarJuego(int numBombas, int filas, int columnas){
        this.numFilas = filas;
        this.numColumnas = columnas; 
        
        panelBotones.setLayout(new GridLayout(numFilas, numColumnas));
        modelo.inicializarMatriz(numBombas, numFilas, numColumnas);

        botones = new Casilla[numFilas][numColumnas];
        
        for(int i=0;i<numFilas;i++){
            for(int j=0;j<numColumnas;j++){
                botones[i][j] = new Casilla(); 
                botones[i][j] = modelo.devolverCasilla(i, j); 
            }
        }
            
        for(int i=0;i<numFilas;i++){
            for(int j=0;j<numColumnas;j++){
                panelBotones.add(botones[i][j]);
            }
        } 
        
        t = new Timer(intervalo, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                seg++; 
                
                if(seg == 60){
                    seg = 0;
                    min++;
                }
            }
        
        }); 
        
        this.init(); 
    }
    
    public Casilla getBoton(int numFila, int numColumna){
        return botones[numFila][numColumna];
    }

    public void init(){ //Activa el objeto de tipo Timer para que empiece a contar
        t.start();
    }
}
