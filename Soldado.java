public class Soldado {
    private String nombre;
    private int vida;
    private int fila;
    private String columna;
    private int columna2;
    private boolean ejercito;
    private int actitud;
    private String actitud2;
    private int velocidad;
    private boolean vive;
    private int vidaActual;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;

    // Accesores y mutadores
    public Soldado() {
        vida = 0;
        velocidad = 0;
        vidaActual = vida;
    }

    public Soldado(int v) {
        vida = v;
        velocidad = 0;
        vidaActual = vida;
    }

    public Soldado(int v, int ve) {
        vida = v;
        velocidad = ve;
        vidaActual = vida;
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

    public void setNivelAtaque(int na) {
        nivelAtaque = na;
    }

    public void setNivelDefensa(int nd) {
        nivelDefensa = nd;
    }

    public void setEjercito(boolean b) {
        ejercito = b;
    }

    public void setActitud(int a) {
        actitud = a;
    }

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

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public int getColumna2() {
        return columna2;
    }

    public boolean getEjercito() {
        return ejercito;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int va) {
        vida = va;
    }

    public int getActitud() {
        return actitud;
    }

    public String getActitud2() {
        if (actitud == 0) {
            return "defensiva";
        } else if (actitud == 1) {
            return "ofensiva";
        } else {
            return "fuga";
        }
    }

    // Otros métodos
    public void atacar() {
        avanzar();
    }

    public void defender() {
        parar();
    }

    public void huir() {
        velocidad += 2;
    }

    public void retroceder() {
        if (velocidad > 0) {
            parar();
            actitud = 0;
        } else if (velocidad == 0) {
            velocidad--;
        }
    }

    public void avanzar() {
        velocidad++;
    }

    public void parar() {
        velocidad = 0;
    }

    public void serAtacado() {
        vidaActual--;
        if (vidaActual == 0) {
            morir();
        }
    }

    public void morir() {
        vive = false;
    }
}
