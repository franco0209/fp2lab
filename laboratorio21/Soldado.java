import java.util.ArrayList;

public class Soldado {

    //Atributos de la clase

    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int fila;
    private String columna;
    private int columna2;
    private boolean ejercito;
    private String reino;

    // Métodos mutadores
    public Soldado() {

    }
    public Soldado(String no, int vi,boolean ejer) {
        this.nombre = no ;
        this.vida = vi;
        this.ejercito=ejer;
        if(ejer){
            this.reino=Ejercito.datoReino1;
        }
        else{
            this.reino=Ejercito.datoReino2;
        }
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public void setFila(int f) {
        fila = f;
    }

    public void setColumna(String c) {
        columna = c;
    }

    public void setColumna2(int c2) {
        columna2 = c2;
    }

    public void setVida(int v) {
        vida = v;
    }

    public void setDefensa(int def) {
        defensa = def;
    }

    public void setAtaque(int atq) {
        ataque = atq;
    }

    public void setEjercito(boolean b) {
        ejercito = b;
    }
     
    //Métodos accesores

    public String getNombre() {
        return nombre;
    }

    public int getFila() {
        return fila;
    }

    public String getColumna() {
        return columna;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }
    

    public int getColumna2() {
        return columna2;
    }

    public boolean getEjercito() {
        return ejercito;
    }

    // Otros métodos
    public void mostrarDatos(){
        if(ejercito){
            System.out.print(Atajos.BLUE);
        }
        else{
            System.out.print(Atajos.RED);
        }
        System.out.println("Nombre: "+nombre+"\tVida: "+vida+"\tReino: "+reino);
        System.out.print(Atajos.RESET);
    }
    //Mostrar un tablero bidimensional
    public static void imprimirTablero(Soldado[][]tablero){
         for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                if ((tablero[fila][columna] != null)) {
                        if (tablero[fila][columna].getEjercito()) {
                            System.out.print("|"+Atajos.BLUE+(tablero[fila][columna].getNombre()).substring(0,1)+tablero[fila][columna].getVida()+Atajos.RESET);
                        }
                        else {
                            System.out.print("|"+Atajos.RED+(tablero[fila][columna].getNombre()).substring(0,1)+tablero[fila][columna].getVida()+Atajos.RESET);
                        }
                }
                else {
                    if(fila==0){
                        if(columna==0){
                           System.out.print("  "+"\t "); 
                        }
                        else{
                            System.out.print(Atajos.convertir(columna)+"  ");
                        }
                    }
                    else if(columna==0){
                        System.out.print(fila+"\t");
                    }
                    else{
                        System.out.print("|__");
                    }
                }
            }
            if(fila!=0){
                System.out.println("|");
            }
            else{
                System.out.println("");
            }
        }  
    }
    //mostrar datos de un ArrayList
    public static void mostrarDatosSol(ArrayList<Soldado>soldados){
        for(int i=0;i<soldados.size();i++){
            soldados.get(i).mostrarDatos();
        }
    }
    //ordenar un ArrayListe
    public static void ordenarArray(ArrayList<Soldado>soldados){
        for (int i = 1; i < soldados.size(); i++) {
            for (int j = 0; j < soldados.size() - i; j++) {
                if ((soldados.get(j).getVida()) < (soldados.get(j+1).getVida())) {
                    Atajos.intercambiar(soldados, j, j + 1);
                }
            }
        }        
    }
}
