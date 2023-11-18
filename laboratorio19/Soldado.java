public class Soldado {

    //Atributos de la clase

    private String nombre;
    private int vida;
    private int fila;
    private String columna;
    private int columna2;
    private boolean ejercito;

    // Métodos mutadores
    public Soldado() {

    }
    public Soldado(String no, int vi,boolean ejer) {
        this.nombre = no ;
        this.vida = vi;
        this.ejercito=ejer;
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
        System.out.println("Nombre: "+nombre+"\tVida: "+vida);
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
}
