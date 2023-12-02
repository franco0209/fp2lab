public class Arquero extends Soldado {
    //Atributos de la clase

    private int numFlechas;

    // Métodos mutadores

    public void setNumFlechas(int newN){
        numFlechas=newN;
    }

    public Arquero(boolean ejer){
        super("Arquero",(((int) (Math.random() * 3)) + 3),ejer);
        this.setAtaque(7);
        this.setDefensa(3);
    }    

    // Métodos accesores
    public int getNumFlechas(){
        return numFlechas;
    }

    //Otros métodos
    public void disparar(){
        if(numFlechas!=0){
            numFlechas--;
        }
    }
}
