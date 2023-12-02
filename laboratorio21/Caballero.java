public class Caballero extends Soldado {
    //Atributos de la clase

    private boolean usaEspada;
    private boolean estaMontando;

    // Métodos mutadores

    public void setUsaEspada(boolean usa){
        usaEspada=usa;
    }

    public void setMontando(boolean mont){
        estaMontando=mont;
    }

    public Caballero(boolean ejer){
        super("Caballero",(((int) (Math.random() * 3)) + 3),ejer);
    }  

    // Métodos accesores
    public boolean getUsaEspada(){
        return usaEspada;
    }
    public boolean getMontando(){
        return estaMontando;
    }

    //Otros métodos
    public void montar(){
        if(!estaMontando){
            estaMontando=true;
            usaEspada=false;
            envestir();
        }
    }
    public void desmontar(){
        if(estaMontando){
            estaMontando=false;
            usaEspada=true;
            
        }

    }
    public void envestir(){

    }
        
}
