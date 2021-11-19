
package practicabuscatoposdefinitiva;

import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;

public class Vista implements Observer {
    private Modelo modelo; 
    private Controlador controlador; 
    
    public Vista(Modelo m, Controlador c){
        modelo = m; 
        controlador = c; 
    }
    
    public void update(Observable obs, Object obj){
        int valorFila, valorColumna, valor; 
        valorFila = modelo.getFila();
        valorColumna = modelo.getColumna(); 
        Casilla aux = controlador.getBoton(valorFila, valorColumna); 
        
        if(modelo.getOpcion().equals("Marcar")){
            if(aux.isMarcado() == true){
                aux.setIcon(new ImageIcon(getClass().getResource("../imagenes/martillo_opt.png")));
            }
            if(aux.isMarcado() == false){
                aux.setIcon(null);
            }
        }
        
        if(modelo.getOpcion().equals("Descubrir")){ 
                valor = aux.getValor(); 

                switch(valor){
                    case 0: aux.setIcon(new ImageIcon(getClass().getResource("../imagenes/0_opt.jpg")));
                        break;  
                    case 1: aux.setIcon(new ImageIcon(getClass().getResource("../imagenes/1_opt.jpg")));
                        break; 
                    case 2: aux.setIcon(new ImageIcon(getClass().getResource("../imagenes/2_opt.jpg")));
                        break; 
                    case 3: aux.setIcon(new ImageIcon(getClass().getResource("../imagenes/3_opt.jpg")));
                        break;  
                    case 4: aux.setIcon(new ImageIcon(getClass().getResource("../imagenes/4_opt.jpg")));
                        break; 
                    case 5: aux.setIcon(new ImageIcon(getClass().getResource("../imagenes/5_opt.jpg")));
                        break;  
                    case 6: aux.setIcon(new ImageIcon(getClass().getResource("../imagenes/6_opt.jpg")));
                        break;  
                    case 7: aux.setIcon(new ImageIcon(getClass().getResource("../imagenes/7_opt.jpg")));
                        break; 
                    case 8: aux.setIcon(new ImageIcon(getClass().getResource("../imagenes/8_opt.jpg")));
                        break;
                    case -1: aux.setIcon(new ImageIcon(getClass().getResource("../imagenes/topo_opt.jpg")));
                        break; 
                }
                
        }
        
    } 
}
