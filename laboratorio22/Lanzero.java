public class Lanzero extends Soldado {
    //Atributos de la clase

    private int longLanza;

    // Métodos mutadores

    public void setLongLanza(int newL){
        longLanza=newL;
    }

    public Lanzero(boolean ejer){
        super("Lanzero",(((int) (Math.random() * 4)) + 5),ejer);
        this.setAtaque(5);
        this.setDefensa(10);
    }

    // Métodos accesores
    public int getLongLanza(){
        return longLanza;
    }

    //Otros métodos
    public void schiltrom(){
        this.setDefensa(this.getDefensa()+1);
    }
    
}
