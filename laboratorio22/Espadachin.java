public class Espadachin extends Soldado {

    //Atributos de la clase

    private int longEspada;
    private boolean esConquistador;
    private boolean esReal;
    private boolean esTeutonico;
    private String tag;

    // Métodos mutadores

    public void setLongEspada(int newL){
        longEspada=newL;
    }

    public Espadachin(boolean ejer){
        super("Espadachin",(((int) (Math.random() * 3)) + 8),ejer);
        this.setAtaque(10);
        this.setDefensa(8);
        if(this.getVida()==10){
            this.setEsEspecial(true);
            if(this.getReino().equals("Castilla Aragón ")){
                this.setNombre("Espadachin Conquistador");
                this.setVida(14);
                this.esConquistador=true;
                this.tag="EC";
            }
            if(this.getReino().equals("Inglaterra")){
                this.setNombre("Espadachin Real");
                this.setVida(12);
                this.esReal=true;
                this.tag="ER";
            }
            if(this.getReino().equals("Sacro Imperio Romano Germánico")){
                this.setNombre("Espadachin Teutonico");
                this.setVida(13);
                this.esTeutonico=true;
                this.tag="ET";
            }                      
        }
    }

    // Métodos accesores
    public int getLongEspada(){
        return longEspada;
    }
    public String getTag(){
        return tag;
    }

    //Otros métodos
    public void crearMuro(){
    }
    public int lanzar(){
        int daño;
        int dañoJabalina=0;
        int dañoCuchillo=0;
        int dañoHacha=0;
        if(esConquistador){
            daño=dañoHacha;
        }
        else if(esReal){
            daño=dañoCuchillo;
        }
        else if(esTeutonico){
            daño=dañoJabalina;
        }
        else{
            daño=0;
        }
        return daño;   
    }
    
}
