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

}
