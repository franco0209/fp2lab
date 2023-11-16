public class Caballero extends Soldado {
    public Caballero(boolean ejer){
        super("Caballero",(((int) (Math.random() * 3)) + 3),ejer);
    }    
}
