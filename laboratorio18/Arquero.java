public class Arquero extends Soldado {
    public Arquero(boolean ejer){
        super("Arquero",(((int) (Math.random() * 3)) + 1),ejer);
    }    
}
