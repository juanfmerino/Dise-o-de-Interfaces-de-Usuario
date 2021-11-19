
package practicabuscatoposdefinitiva;

import javax.swing.JButton;

public class Casilla extends JButton {
    private boolean bomba; 
    private int valor; //sumatorio de todas las topos(bombas) que tiene alrededor la casilla
    private boolean visitado; 
    private boolean marcado; 
    
    public Casilla(){
        
    }
    
    public Casilla(boolean bomba){
        this.bomba = bomba; 
        this.valor = -1; 
        visitado = false; 
        marcado = false; 
    }
    
    public boolean isBomba(){
        return bomba; 
    }

    public void setBomba(boolean bomba) {
        this.bomba = bomba;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    } 

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }
    
}
