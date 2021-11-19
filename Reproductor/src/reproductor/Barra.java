/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;

/**
 *
 * @author Juand
 */
public class Barra extends JFrame {
    private JButton abrir, reproducir,parar,pausa;
    private Clip clip;
    private File audio;
    private JSlider barra;
    private JLabel etiValor;
    private long tMax;
    private Thread hilo;
    private int tSlider;
     private long vc ; 
    //private Long l;
    
    public Barra(){
        int i=1;
        UIManager.LookAndFeelInfo looks[];
        looks = UIManager.getInstalledLookAndFeels();
        reproducir=new JButton(new ImageIcon(getClass().getResource("..\\imagenes\\play.jpg")));
        pausa=new JButton(new ImageIcon(getClass().getResource("..\\imagenes\\pausa.jpg")));
        parar=new JButton(new ImageIcon(getClass().getResource("..\\imagenes\\parar.jpg")));
        
        hilo=new Thread();
        
        barra=new JSlider(JSlider.HORIZONTAL, 0,100,00);
        etiValor= new JLabel();
        etiValor.setText("      0");
     
        barra.setMajorTickSpacing(20);
        barra.setMinorTickSpacing(5);
        //barra.setMaximum(100);
        barra.setPaintLabels(true);
        barra.setPaintTicks(true);
        barra.setSnapToTicks(true);
        
        //barra.setValue(audio);
        pausa.setEnabled(false);
        reproducir.setEnabled(false);
        parar.setEnabled(false);

        try{
            UIManager.setLookAndFeel(looks[i].getClassName());
                SwingUtilities.updateComponentTreeUI(this);
        } catch(Exception e) {}
            
            setLayout( new FlowLayout());
            abrir= new JButton(new ImageIcon(getClass().getResource("..\\imagenes\\carpeta.jpg")));
        abrir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFileChooser file=new JFileChooser();
                file.showOpenDialog(abrir);
                audio=file.getSelectedFile();

                //l=clip.getMicrosecondPosition();

                try{
                    clip=AudioSystem.getClip();
                    AudioInputStream sound =
                    AudioSystem.getAudioInputStream(audio);
                    
                    pausa.setEnabled(true);
                    reproducir.setEnabled(true);
                    parar.setEnabled(true);
                    
                    //double d = tMax; 
                    //etiValor.setText("   "+d);
                    
                    clip.open(sound);
                    tMax=clip.getMicrosecondLength()/1000000;
                    
                    float tiempo =clip.getMicrosecondLength()/1000000;
                    etiValor.setText(""+tiempo);
                    
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"ERROR\n"+"No hay fichero de audio o no es de"+"audio"+"alerta"+"JOptionPane.ERROR_MESSAGE");}
            }
        });
        
        
        reproducir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    clip.start();
                    pausa.setEnabled(true);
                    reproducir.setEnabled(false);
                    parar.setEnabled(true);
                    play();
            }
        });
        
        
       
        pausa.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                    reproducir.setEnabled(true);
                    parar.setEnabled(true);
                    pausa.setEnabled(false);
                    
                    clip.stop();
                    hilo.interrupt();
                    
                    tSlider = barra.getValue(); 
                    
                    vc = (tSlider*tMax)/100; 
                    etiValor.setText(""+vc);
                            
                    /*float tiempo =clip.getMicrosecondLength()/1000000;
                    etiValor.setText(""+tiempo);*/
                    //hilo.interrupt();
                    
              
            }
        });
        
        
        
        
        parar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    clip.stop();
                    clip.setMicrosecondPosition(0);
                    parar.setEnabled(false);
                    pausa.setEnabled(false);
                    reproducir.setEnabled(true);
                    
                    /*barra.setValue(0);
                    double d = tMax; 
                    etiValor.setText(""+t);*/
                    
                    
        
            }
        });
        
        
        
        
        
        
        add(abrir);
        add(reproducir);
        add(pausa);
        add(parar);
        add(barra);
        add(etiValor);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class MovimientoSlider implements Runnable{
            
            public void run(){
                long tTotal=clip.getMicrosecondLength();
                double t;
                //clip.start();
                do{
                    long v=clip.getMicrosecondPosition();
                    //tSlider=(int)(v*100)/tTotal;
                    barra.setValue(tSlider);
                    t=(tTotal-v)/1000000;
                    etiValor.setText(""+t);
                    
                }while(clip.isRunning());
                
            /*clip.setMicrosecondPosition(0);
            parar.setEnabled(false);
            pausa.setEnabled(false);
            reproducir.setEnabled(true);
            barra.setValue(0);*/
                
            reproducir.setEnabled(true);
            pausa.setEnabled(false);
            parar.setEnabled(true);
            barra.setValue(tSlider);
            etiValor.setText(""+t);
            
            
            }
        }
    
    private void play(){
        hilo= new Thread(new MovimientoSlider());
        hilo.start();
    }
}
    

