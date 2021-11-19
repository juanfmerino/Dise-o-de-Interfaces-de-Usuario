/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.ImageIcon;

/**
 *
 * @author Juand
 */
public class Clase1 extends JFrame {
    private final int w=300;
    private final int h=150;
    private ImageIcon [] imageArray;
    private Timer t;
    private ImageIcon pelota;
    private int x=30;
    private int y=70;
    private int q;
    private String dirHor="izq";
    private String dirVer="nada";
    
    public Clase1() {
        
        setTitle("Movimiento");
        setSize(w,h);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pelota = new ImageIcon(getClass().getResource("..\\imagenes\\pacman.gif"));
        setVisible(true);
        

        t = new Timer(50, new ActionListener () {
        public void actionPerformed(ActionEvent event) {
      
            if (dirHor == "drcha"){
                if(x<w-20){
                    x=x+2;}  
            } 
            if(dirHor =="izq"){
                if(x>0){
                    x=x-2;}
                  }
            if(dirVer =="abajo"){
                if(y<h-20){
                    y=y+2;}
            }
            if(dirVer =="arriba"){
                if(y>20){
                   y=y-2;}
            }
            
        repaint(); }
        });
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                switch(evt.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                    imageArray = new ImageIcon[4];
                    imageArray[0] = new ImageIcon(getClass().getResource("../imagenes/pacman.gif"));
                    imageArray[1] = new ImageIcon(getClass().getResource("../imagenes/left1.gif"));
                    imageArray[2] = new ImageIcon(getClass().getResource("../imagenes/left2.gif"));
                    imageArray[3] = new ImageIcon(getClass().getResource("../imagenes/left3.gif"));
                    
                    dirHor="izq";
                    dirVer="nada";
                   
                    break;
                    case KeyEvent.VK_RIGHT:
                    imageArray = new ImageIcon[4];
                    imageArray[0] = new ImageIcon(getClass().getResource("../imagenes/pacman.gif"));
                    imageArray[1] = new ImageIcon(getClass().getResource("../imagenes/right1.gif"));
                    imageArray[2] = new ImageIcon(getClass().getResource("../imagenes/right2.gif"));
                    imageArray[3] = new ImageIcon(getClass().getResource("../imagenes/right3.gif"));
       
                    dirHor="drcha";
                    dirVer="nada";
                    
                    break;
                    case KeyEvent.VK_UP:
                    imageArray = new ImageIcon[4];
                    imageArray[0] = new ImageIcon(getClass().getResource("../imagenes/pacman.gif"));
                    imageArray[1] = new ImageIcon(getClass().getResource("../imagenes/up1.gif"));
                    imageArray[2] = new ImageIcon(getClass().getResource("../imagenes/up2.gif"));
                    imageArray[3] = new ImageIcon(getClass().getResource("../imagenes/up3.gif"));
                    
                    dirVer="arriba";
                    dirHor="nada";
                    
                    break;
                    case KeyEvent.VK_DOWN:
                    imageArray = new ImageIcon[4];
                    imageArray[0] = new ImageIcon(getClass().getResource("../imagenes/pacman.gif"));
                    imageArray[1] = new ImageIcon(getClass().getResource("../imagenes/down1.gif"));
                    imageArray[2] = new ImageIcon(getClass().getResource("../imagenes/down2.gif"));
                    imageArray[3] = new ImageIcon(getClass().getResource("../imagenes/down3.gif"));
                   
                    dirVer="abajo";
                    dirHor="nada";
                    break;
                } }
            });
    }
    public void init() {
    t.start();
    }

    public void paint (Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,300,300);
        if (q<3){
        q=q+1;}
        else {q=0;}
        pelota.paintIcon(this,g,0,0);
        imageArray[q].paintIcon(this, g, x, y);
    }
}
    

