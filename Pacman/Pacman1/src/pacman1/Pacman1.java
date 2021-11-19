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

/**
 *
 * @author Juand
 */
public class Pacman1 {

    public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable(){
    public void run(){
    new Clase1().init();
       }
   });
 }
}

