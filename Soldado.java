public class Soldado {
    private String nombre;
    private int vida;
    private int fila;
    private String columna;
    private int columna2;
    public void setNombre( String n){
    nombre = n;
    }
    public void setFila(int f){
    fila = f;
    }
    public void setColumna(String c){
    columna = c;
    }
    public void setColumna2(int c2){
    columna2 = c2;
    }
    public void setVida(int v){
    vida = v;
    }
    public String getNombre(){
        return nombre;
    }
    public int getFila(){
        return fila;
    }
    public String getColumna(){
        return columna;
    }
    public int getVida(){
        return vida;
    }
    public int getColumna2(){
        return columna2;
    }
}