/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.event.KeyListener;

/**
 *
 * @author Juand
 */
public class Clase1 extends JFrame{
    private final int w=300;
    private final int h=150;
    private Timer t;
    private ImageIcon pelota;
    private int x=30;
    private int y=70;
    private String dirHor="izq";
    private String dirVer="nada";
    
    public Clase1() {
        setTitle("Movimiento");
        setSize(w,h);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pelota = new ImageIcon(getClass().getResource("..\\imagen\\pacman.gif"));
        setVisible(true);

        t = new Timer(50, new ActionListener () {
        public void actionPerformed(ActionEvent event) {
            if (dirHor == "drcha"){
                if (x<w-20){ x=x+2;
                } else {
                    x=x-2;
                    dirHor="izq";}
            } 
            if(dirHor =="izq"){
                if (x>20)
                    x=x-2;
                else {
                    x=x+2;
                    dirHor="drcha";}
                  }
            if(dirVer =="abajo"){
                if(y<h-20){
                y=y+2;
                }else{y=y-2;
                      dirVer="arriba";}
            }
            if(dirVer =="arriba"){
                if(y>20)
                   y=y-2;
                else{y=y+2;
                    dirVer="abajo";}
            }
            
        repaint(); }
        });
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                switch(evt.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                    x -= 10;
                    dirHor="izq";
                    dirVer="nada";
                   // pelota.repaint();
                    break;
                    case KeyEvent.VK_RIGHT:
                    x += 10;
                    dirHor="drcha";
                    dirVer="nada";
                    //pelota.repaint();
                    break;
                    case KeyEvent.VK_UP:
                    y -= 10;
                    dirVer="arriba";
                    dirHor="nada";
                    //pelota.repaint();
                    break;
                    case KeyEvent.VK_DOWN:
                    y += 10;
                    dirVer="abajo";
                    dirHor="nada";

                    //pelota.repaint();
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
        pelota.paintIcon(this, g, x, y);
    }
}
