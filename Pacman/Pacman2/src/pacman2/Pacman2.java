/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.ImageIcon;
/**
 *
 * @author Juand
 */
public class Pacman2 {
 public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable(){
    public void run(){
    new Clase1().init();
       }
   });
 }
    
}
