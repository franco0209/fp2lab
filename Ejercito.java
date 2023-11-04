public class Ejercito {
    private int fila;
    private String columna;
    private int columna2;
    private boolean reino;
    private String reino2;
    private int numSoldados;

    public static int totalEjercitos;
    public static int totalEjercitos1;
    public static int totalEjercitos2;  
    public static final int maxEjercitos=10;
    public static int totalSoldados;
    public static int totalSoldados1;
    public static int totalSoldados2;  
    public static final int maxSoldados=10;

    //Métodos modificadores

    public void setFila(int f) {
        fila = f;
    }

    public void setColumna(String c) {
        columna = c;
    }

    public void setColumna2(int c2) {
        columna2 = c2;
    }
    
    public void setReino(boolean r){
        reino= r;
    }

    public void setReino2(String r2) {
        reino2 = r2;
    }

    public void setNumSoldados(int nS) {
        numSoldados = nS;
    }
    

    //Métodos accesores

    public int getFila() {
        return fila;
    }

    public String getColumna() {
        return columna;
    }

    public int getColumna2() {
        return columna2;
    }

    public boolean getReino(){
        return reino;
    }
    
    public String getReino2() {
        return reino2;
    }

    public int getNumSoldados() {
        return numSoldados;
    }

}
