
package practicabuscatoposdefinitiva;

import java.util.Observable;
import java.util.Random;

public class Modelo extends Observable {
    private int numFilas;
    private int numColumnas;
    private int numDescubiertas; 
    private int numBombas; 
    private int fila; //Coordenada x
    private int columna; //Coordenada y
    private String opcion; 
    private Casilla[][] matriz;  

    
    public Modelo(){
        
    }
    
    public Casilla devolverCasilla(int fila, int columna){
        return matriz[fila][columna];
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    

    public void inicializarMatriz(int numBombas, int numFilas, int numColumnas){
        numDescubiertas = 0; 
        Punto[] puntos = new Punto[numBombas];
        
        Random aleatorio = new Random(System.currentTimeMillis());
        matriz = new Casilla[numFilas][numColumnas];
        
        this.numBombas = numBombas;
        this.numFilas = numFilas; 
        this.numColumnas = numColumnas; 
        
        for(int i=0;i<numFilas;i++){
            for(int j=0;j<numColumnas;j++){
                matriz[i][j] = new Casilla(false);
            }
        }
        
        int cont = 0;
        boolean flag;
        int aleatorioFila;
        int aleatorioColumna; 
        
        do{ 
            do{
                flag = false; 
                aleatorioFila = aleatorio.nextInt(numFilas); //Genera un número aleatorio entre 0 y numFilas-1
                aleatorioColumna = aleatorio.nextInt(numColumnas); //Genera un número aleatorio entre 0 y numColumnas-1 
                Punto puntoAux = new Punto(aleatorioFila, aleatorioColumna);    
                for(int i=0;i<cont;i++){ //Con este bucle aseguramos que las bombas "caigan" en distintas posiciones y éstas no se puedan repetir 
                    if(puntos[i].equals(puntoAux) == true){
                        flag = true; 
                    }   
                }
                
           }while(flag == true);
           puntos[cont] = new Punto(aleatorioFila, aleatorioColumna);
           cont++; 
           matriz[aleatorioFila][aleatorioColumna].setBomba(true);
        }while(cont < numBombas);
        
        for(int i=0;i<numFilas;i++){
            for(int j=0;j<numColumnas;j++){
                calcularValor(i, j);
            }
        }
   
    }
    
    public void calcularValor(int numFila, int numColumna){
        int valor = 0;

        if(! matriz[numFila][numColumna].isBomba()){
            if((numFila > 0) && (numFila < this.numFilas-1)){
                if((numColumna > 0) && (numColumna < this.numColumnas-1)){

                    for(int i=numFila-1;i<=numFila+1;i++){
                        for(int j=numColumna-1;j<=numColumna+1;j++){
                            if((i != numFila) || (j != numColumna)){
                                if(matriz[i][j].isBomba()){
                                    valor++; 
                                }
                            }
                        }
                    }
  
                }
            }

            if((numFila > 0) && (numFila < this.numFilas-1)){
                if((numColumna == 0)){

                    for(int i=numFila-1;i<=numFila+1;i++){
                        for(int j=numColumna;j<=numColumna+1;j++){
                            if((i != numFila) || (j != numColumna)){
                                if(matriz[i][j].isBomba()){
                                    valor++; 
                                }
                            }             
                        }

                    }
 
                }

                if(numColumna == this.numColumnas-1){

                    for(int i=numFila-1;i<=numFila+1;i++){
                        for(int j=numColumna-1;j<=numColumna;j++){
                            if((i != numFila) || (j != numColumna)){
                                if(matriz[i][j].isBomba()){
                                    valor++; 
                                }
                            }
                        }
                    }
  
                }
            }

            if((numColumna > 0) && (numColumna < this.numColumnas-1)){
                if(numFila == 0){

                    for(int i=numFila;i<=numFila+1;i++){
                        for(int j=numColumna-1;j<=numColumna+1;j++){
                            if((i != numFila) || (j != numColumna)){
                                if(matriz[i][j].isBomba()){
                                    valor++;
                                }
                            }
                        }
                    }
 
                }

                if(numFila == this.numFilas-1){

                    for(int i=numFila-1;i<=numFila;i++){
                        for(int j=numColumna-1;j<=numColumna+1;j++){
                            if((i != numFila) || (j != numColumna)){
                                if(matriz[i][j].isBomba()){
                                    valor++;
                                }
                            }
                        }
                    }
 
                }
            }

            if((numFila == 0) && (numColumna == 0)){

                for(int i=numFila;i<=numFila+1;i++){
                    for(int j=numColumna;j<=numColumna+1;j++){
                        if((i != numFila) || (j != numColumna)){
                            if(matriz[i][j].isBomba()){
                                valor++;
                            }
                        } 
                    }
                }

            }

            if((numFila == 0) && (numColumna == this.numColumnas-1)){

                for(int i=numFila;i<=numFila+1;i++){
                    for(int j=numColumna-1;j<=numColumna;j++){
                        if((i != numFila) || (j != numColumna)){
                            if(matriz[i][j].isBomba()){
                                valor++;
                            }
                        } 
                    }
                }
 
            }    

            if((numFila == this.numFilas-1) && (numColumna == 0)){

                for(int i=numFila-1;i<=numFila;i++){
                    for(int j=numColumna;j<=numColumna+1;j++){
                        if((i != numFila) || (j != numColumna)){
                            if(matriz[i][j].isBomba()){
                                valor++;
                            }
                        } 
                    }
                }

            }

            if((numFila == this.numFilas-1) && (numColumna == this.numColumnas-1)){

                for(int i=numFila-1;i<=numFila;i++){
                    for(int j=numColumna-1;j<=numColumna;j++){
                        if((i != numFila) || (j != numColumna)){
                            if(matriz[i][j].isBomba()){
                                valor++;
                            }
                        } 
                    }
                }
 
            }  
        }
        
        else{ 
            valor = -1; //Valor para las casillas que contengan un topo 
        }
        
        matriz[numFila][numColumna].setValor(valor);
        
    }
    
 
    
    //Método recursivo que se vuelve a lanzar si el valor de la casilla 0
    public void descubrirCasillasDefinitivo(int numFila, int numColumna){ 
        if(!matriz[numFila][numColumna].isVisitado()){
            matriz[numFila][numColumna].setVisitado(true);

            notificarCasilla(numFila, numColumna); 
            numDescubiertas++; 

            if(!(matriz[numFila][numColumna].getValor() == -1)){
                if(matriz[numFila][numColumna].getValor() == 0){

                    if((numFila > 0) && (numFila < this.numFilas-1)){
                        if((numColumna > 0) && (numColumna < this.numColumnas-1)){
                            for(int i=numFila-1;i<=numFila+1;i++){
                                for(int j=numColumna-1;j<=numColumna+1;j++){
                                    if(matriz[i][j].isVisitado() == false){ //Se invoca de nuevo al método con las coordenadas de una casilla siempre que no haya sido visitada anteriormente  
                                        descubrirCasillasDefinitivo(i, j);
                                    }
                                }
                            }
                        }
                    }

                    if((numFila > 0) && (numFila < this.numFilas-1)){
                        if((numColumna == 0)){
                            for(int i=numFila-1;i<=numFila+1;i++){
                                for(int j=numColumna;j<=numColumna+1;j++){
                                    if(matriz[i][j].isVisitado() == false){
                                        descubrirCasillasDefinitivo(i, j);
                                    }
                                }
                            }

                        }

                        if(numColumna == this.numColumnas-1){
                            for(int i=numFila-1;i<=numFila+1;i++){
                                for(int j=numColumna-1;j<=numColumna;j++){
                                    if(matriz[i][j].isVisitado() == false){
                                        descubrirCasillasDefinitivo(i, j);
                                    }
                                }
                            }
                        }

                    }

                    if((numColumna > 0) && (numColumna < this.numColumnas-1)){
                        if(numFila == 0){
                            for(int i=numFila;i<=numFila+1;i++){
                                for(int j=numColumna-1;j<=numColumna+1;j++){
                                    if(matriz[i][j].isVisitado() == false){
                                        descubrirCasillasDefinitivo(i, j);
                                    }
                                }
                            }
                        }

                        if(numFila == this.numFilas-1){
                            for(int i=numFila-1;i<=numFila;i++){
                                for(int j=numColumna-1;j<=numColumna+1;j++){
                                    if(matriz[i][j].isVisitado() == false){
                                        descubrirCasillasDefinitivo(i, j);
                                    }
                                }
                            }
                        }
                    }

                    if((numFila == 0) && (numColumna == 0)){
                        for(int i=numFila;i<=numFila+1;i++){
                            for(int j=numColumna;j<=numColumna+1;j++){
                                if(matriz[i][j].isVisitado() == false){
                                    descubrirCasillasDefinitivo(i, j);
                                }
                            }
                        }
                    }

                    if((numFila == 0) && (numColumna == this.numColumnas-1)){
                        for(int i=numFila;i<=numFila+1;i++){
                            for(int j=numColumna-1;j<=numColumna;j++){
                                if(matriz[i][j].isVisitado() == false){
                                    descubrirCasillasDefinitivo(i, j);
                                }
                            }
                        }
                    }

                    if((numFila == this.numFilas-1) && (numColumna == 0)){
                        for(int i=numFila-1;i<=numFila;i++){
                            for(int j=numColumna;j<=numColumna+1;j++){
                                if(matriz[i][j].isVisitado() == false){
                                    descubrirCasillasDefinitivo(i, j);
                                }
                            }
                        }
                    }

                    if((numFila == this.numFilas-1) && (numColumna == this.numColumnas-1)){
                        for(int i=numFila-1;i<=numFila;i++){
                            for(int j=numColumna-1;j<=numColumna;j++){
                                if(matriz[i][j].isVisitado() == false){
                                    descubrirCasillasDefinitivo(i, j);
                                }
                            }
                        }
                    }

                }

            }
        } 
        
    }    
    
    
    public void marcarCasilla(int fila, int columna){
        if(!matriz[fila][columna].isVisitado()){        
            this.fila = fila; 
            this.columna = columna;
            if(matriz[fila][columna].isMarcado() == false){
                matriz[fila][columna].setMarcado(true); //Marcando casilla
            }
            else{
                matriz[fila][columna].setMarcado(false); //Desmarcando casilla

            }

            setChanged(); 
            notifyObservers();
        }
    }
    
    public void notificarCasilla(int fila, int columna){
        this.fila = fila; 
        this.columna = columna; 
        setChanged(); 
        notifyObservers();
    }
    
    public int devolverValorCasilla(int fila, int columna){
        return matriz[fila][columna].getValor(); 
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public boolean comprobarMatriz(){
        if(((numFilas*numColumnas)-numDescubiertas) <= numBombas){ 
            return true; 
        }
        return false; 
    }
      
}
