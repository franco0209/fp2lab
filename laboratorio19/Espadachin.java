public class Espadachin extends Soldado {

    //Atributos de la clase

    private int longEspada;

    // Métodos mutadores

    public void setLongEspada(int newL){
        longEspada=newL;
    }

    public Espadachin(boolean ejer){
        super("Espadachin",(((int) (Math.random() * 2)) + 3),ejer);
    }

    // Métodos accesores
    public int setLongEspada(){
        return longEspada;
    }

    //Otros métodos
    public void crearMuro(){

    }
    
}
