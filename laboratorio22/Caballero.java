public class Caballero extends Soldado {
    //Atributos de la clase

    private boolean usaEspada;
    private boolean estaMontando;
    private boolean esFranco;
    private boolean esMoro;
    private String tag;
    // Métodos mutadores

    public void setUsaEspada(boolean usa){
        usaEspada=usa;
    }

    public void setMontando(boolean mont){
        estaMontando=mont;
    }

    public Caballero(boolean ejer){
        super("Caballero",(((int) (Math.random() * 3)) + 10),ejer);
        this.setAtaque(13);
        this.setDefensa(7);
        if(this.getVida()==12){
            this.setEsEspecial(true);
            if(this.getReino().equals("Francia")){
                this.setNombre("Caballero Franco");
                this.setVida(15);
                this.esFranco=true;
                this.tag="CF";
            }
            if(this.getReino().equals("Moros")){
                this.setNombre("Caballero Moro");
                this.setVida(13);
                this.esMoro=true;
                this.tag="CM";
            }                     
        }
    }  

    // Métodos accesores
    public boolean getUsaEspada(){
        return usaEspada;
    }
    public boolean getMontando(){
        return estaMontando;
    }
    public String getTag(){
        return tag;
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
    public int lanzar(){
        int daño;
        int dañoLanza=0;
        int dañoFlecha=0;
        if(esFranco){
            daño=dañoLanza;
        }
        else if(esMoro){
            daño=dañoFlecha;
        }
        else{
            daño=0;
        }
        return daño;        
    }
        
}
