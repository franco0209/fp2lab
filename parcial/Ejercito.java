import java.util.*;

public class Ejercito {
    private int fila;
    private String columna;
    private int columna2;
    private boolean reino;
    private String reino2;
    private ArrayList<Soldado> misSoldados=new ArrayList<>();
    private int numInicialSoldados;
    private int sumaDeVidas;
    //datos actualizables en tiempo de ejecucion del propio ejercito
    public static int numSoldados;
    //datos generales
    public static int totalEjercitos;
    public static int totalEjercitos1;
    public static int totalEjercitos2;  
    public static final int maxEjercitos=10;
    public static int totalSoldados;
    public static int totalSoldados1;
    public static int totalSoldados2;  
    public static final int maxSoldados=10;


    //Métodos modificadores
    public Ejercito(){

    }
    public Ejercito(String nomReino, int numSoldados2){
        numInicialSoldados=numSoldados2;
        reino2=nomReino;
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
    
    public void setReino(boolean r){
        reino= r;
    }

    public void setReino2(String r2) {
        reino2 = r2;
    }

    public void addSoldado(Soldado soldado){
        misSoldados.add(soldado);
    }
    public void generarSoldados(){
        for(int i=0; i<numInicialSoldados; i++){
            Soldado soldadito=new Soldado(("Soldado"+i),(((int) (Math.random() * 5)) + 1),(((int) (Math.random() * 5)) + 1),(((int) (Math.random() * 5)) + 1));
            misSoldados.add(soldadito);
        }
        sumarVidas();
    }
    public void generarSoldadosManual(){
        Scanner scan=new Scanner(System.in);
        for(int i=0;i<numInicialSoldados;i++){
            System.out.println("Ingrese el nombre del soldado "+i);
            String nom=scan.next();
            int vid, atq,def;
            do{
                System.out.println("Ingrese la vida del soldado"+ i +" debe estar entre 1-5 ");
                vid=scan.nextInt();
            }
            while (vid>5||vid<1);
            do{
                System.out.println("Ingrese el ataque del soldado"+ i +" debe estar entre 1-5 ");
                atq=scan.nextInt();
            }
            while (atq>5||atq<1);
            do{
                System.out.println("Ingrese la defensa del soldado"+ i +" debe estar entre 1-5 ");
                def=scan.nextInt();
            }
            while (def>5||def<1);
            misSoldados.add(new Soldado(nom,vid,atq,def));
        }
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
    public int getNumSoldados(){
        return numInicialSoldados;
    }
    public int getSumaVidas(){
        return sumaDeVidas;
    }

    public void tooString(){
        System.out.println("Reino: "+reino2+"\nNúmero de soldados: "+numSoldados+"\nSoldados:");
        int i=1;
        for(Soldado soldado:misSoldados){
            System.out.println(i+" . Nombre: "+soldado.getNombre()+"Vida: "+soldado.getVida()+"Nivel de ataque: "+soldado.getNivelAtaque()+" Nivel de defensa" +soldado.getNivelDefensa());
            i++;
        }
    }
    public void plusTerritorio(){
        for(int i=0;i<misSoldados.size();i++){
            misSoldados.get(i).setVida((misSoldados.get(i).getVida())+1);
        }
        sumarVidas();
    }
    public void sumarVidas(){
        for(int i=0;i<misSoldados.size();i++){
            sumaDeVidas=sumaDeVidas+(misSoldados.get(i).getVida());
        }
    }



}
