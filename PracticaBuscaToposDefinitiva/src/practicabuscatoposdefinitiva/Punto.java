//Clase utilizada para almacenar las posiciones en las que se colocan los topos
package practicabuscatoposdefinitiva;

public class Punto {
    private int x;
    private int y; 
    
    public Punto(int x, int y){
        this.x = x;
        this.y = y; 
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public boolean equals(Punto x){
        if((this.x == x.getX()) && (this.y == x.getY())){
            return true; 
        }
        return false; 
    }
}
